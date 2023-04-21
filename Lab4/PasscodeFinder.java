/*
 * Made by: Monica
 * This program uses a binary-search-like Decrease and Conquer algorithm.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class PasscodeFinder {
    // Stores number of comparisons for the brute force method
    private int bruteComparisonsCount = 0;

    // Stores number of comparisons for the binary search method
    private int binaryComparisonsCount = 0;


    /*
     * Uses the brute force algorithm to find the smallest missing number (passcode) for a given list of data.
     * Assumes the list of data is sorted.
     * Starts at the beginning of the list, checks each number until the missing number is found.
     * Returns: smallest number missing
     */
    public Integer getPasscodeBruteForce(Integer[] posUniqueIntegers) {
        // Stores the smallest number missing
        Integer smallestNumber = -1;

        // Reset the counter for brute force comparisons
        bruteComparisonsCount = 0;

        // Loop through each value in the array
        for (int index = 0; index < posUniqueIntegers.length; index++) {
            bruteComparisonsCount++;

            // Check if the current number in the array does not match it's index value (meaning there's a number missing)
            if (posUniqueIntegers[index] != index) {

                // Store the value of the missing number
                smallestNumber = index;

                // Print the smallest number result
                System.out.println("Smallest number that is missing (passcode): " + index);

                // Return the smallest number missing
                return index;
            }
        }

        // If the missing number is not found, return -1
        return smallestNumber;
    }

    /*
     * Getter function that returns the number of comparisons performed by the most recent getPasscodeBruteForce() call.
     */
    public int bruteForceComparisons() {
        return bruteComparisonsCount;
    }


    /*
     * Uses the binary search algorithm to find the smallest missing number (passcode) for a given list of data.
     * Assumes the list of data is sorted.
     * Starts at the beginning of the list, checks each number until the missing number is found.
     * Returns: smallest number missing
     */
    public Integer getPasscodeBinarySearch(Integer[] posUniqueIntegers) {
        // Reset the counter for binary search comparisons
        binaryComparisonsCount = 0;

        // Stores the current start and end positions of the array
        int start = 0;
        int end = posUniqueIntegers.length-1;

        // Stores the current smallest number in the array during each loop iteration
        int smallestNumber = -1;

        // Continue looping while the start position is less than the end position
        while (start <= end) {

            // Get the middle index of the array and store it as the smallest number in the array
            int middlePos = Math.floorDiv((start + end), 2);
            smallestNumber = middlePos;

            // Check if the current number matches its index in the array
            boolean numMatchesIndex = posUniqueIntegers[middlePos] == middlePos;

            // Check if the previous and next numbers match their indices in the array
            boolean prevNumMatchesIndex = posUniqueIntegers[middlePos-1] == middlePos-1;
            boolean nextNumMatchesIndex = posUniqueIntegers[middlePos+1] == middlePos+1;

            // If all numbers match their indices in the array
            if (numMatchesIndex && prevNumMatchesIndex && nextNumMatchesIndex) {
                // Number of comparison statements executed is 1
                binaryComparisonsCount += 1;

                // The smallest missing number must be in the larger half of the array,
                // so move the start position to the middle position + 1
                start = middlePos+1;

            // If the current number matches its index, but the next number doesn't
            } else if (numMatchesIndex && !nextNumMatchesIndex) {
                // Second conditional if statement checked, number of comparisons is 2
                binaryComparisonsCount += 2;

                // Move the start and end positions to this number's index
                start = middlePos+1;
                end = start;

            // If the current number matches its index, but the previous number doesn't
            } else if (numMatchesIndex && !prevNumMatchesIndex) {
                // Third conditional statement checked, number of comparisons is 3
                binaryComparisonsCount += 3;

                // Move the start and end positions to this number's index
                end = middlePos-1;

                // If the current number doesn't match its index
            } else if (!numMatchesIndex) {
                // Fourth conditional statement checked, number of comparisons is 4
                binaryComparisonsCount += 4;

                // Move the end position to this number's index
                end = middlePos-1;
            }
        }

        // Print the smallest number result
        System.out.println("Smallest number that is missing (passcode): " + smallestNumber);

        // If the end of the loop is reached and the number is not found return -1 (represents no valid number)
        return smallestNumber;
    }

    /*
     * Getter function that returns the number of comparisons performed by the most recent getPasscodeBinarySearch() call.
     */
    public int binarySearchComparisons() {
        return binaryComparisonsCount;
    }

    

    /* 
     * Reads all number from a text file and Stores the numbers into an Arraylist.
     */
    public Integer[] storeFileNumbers(String fileName) throws FileNotFoundException {
        // List to store all numbers
        ArrayList<Integer> numbersList = new ArrayList<>();
      
        try {
            // Create BufferedReader and FileReader objects to read through each line in the
            // file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            // Read each line in the file
            String currLine = bufferedReader.readLine();

            // Read the file line by line until the end of the file is reached
            while (currLine != null) {
                // Convert each number to an Integer object and add it to the Arraylist
                Integer currNumber = Integer.valueOf(currLine);
                numbersList.add(currNumber);

                // Read the next line
                currLine = bufferedReader.readLine();
            }

            // Close BufferedReader object
            bufferedReader.close();

        } catch (Exception e) {
            // If an error occurs
            e.printStackTrace();
        }

        // Sort the Arraylist
        Collections.sort(numbersList);

        // Call helper function to convert the Arraylist to an array
        Integer[] numbersArray = convertArraylistToArray(numbersList);
        
        // Return the array of numbers from the file
        return numbersArray;
    }

    /*
     * Helper function for storeFileNumbers() to convert an Arraylist of integers to an integer array.
     * Copies each value from the Arraylist into the array.
     * Returns an array of integers.
     */
    private Integer[] convertArraylistToArray(ArrayList<Integer> numbersList) {
        // Create an array to store all numbers from the Arraylist
        Integer[] numbersArray = new Integer[numbersList.size()];

        // Loop through each element in the Arraylist and store it in the array
        for (int index = 0; index < numbersArray.length; index++) {
            numbersArray[index] = numbersList.get(index);
        }

        // Return the array of integers
        return numbersArray;
    }



    /* Main method that runs the program and calls the methods */
    public static void main(String[] args) throws FileNotFoundException {
        // Create PasscodeFinder object to call brute force and binary search methods
        PasscodeFinder passcodeFinder = new PasscodeFinder();

        // Store each file's numbers into Integer arrays
        // This code assumes the text files are in the same folder and level as this Java file
        Integer[] file1 = passcodeFinder.storeFileNumbers("Lab4/length_2_N_44.txt");
        Integer[] file2 = passcodeFinder.storeFileNumbers("Lab4/length_3_N_021.txt");
        Integer[] file3 = passcodeFinder.storeFileNumbers("Lab4/length_3_N_429.txt");
        Integer[] file4 = passcodeFinder.storeFileNumbers("Lab4/length_4_N_0930.txt");
        Integer[] file5 = passcodeFinder.storeFileNumbers("Lab4/length_4_N_8589.txt");
        Integer[] file6 = passcodeFinder.storeFileNumbers("Lab4/length_5_N_27100.txt");
       
        // Call brute force and binary search methods for each file
        passcodeFinder.getPasscodeBruteForce(file1);
        System.out.println("Number of brute force comparisons: " + passcodeFinder.bruteForceComparisons());
        passcodeFinder.getPasscodeBinarySearch(file1);
        System.out.println("Number of binary search comparisons: " + passcodeFinder.binarySearchComparisons());

        passcodeFinder.getPasscodeBruteForce(file2);
        System.out.println("Number of brute force comparisons: " + passcodeFinder.bruteForceComparisons());
        passcodeFinder.getPasscodeBinarySearch(file2);
        System.out.println("Number of binary search comparisons: " + passcodeFinder.binarySearchComparisons());

        passcodeFinder.getPasscodeBruteForce(file3);
        System.out.println("Number of brute force comparisons: " + passcodeFinder.bruteForceComparisons());
        passcodeFinder.getPasscodeBinarySearch(file3);
        System.out.println("Number of binary search comparisons: " + passcodeFinder.binarySearchComparisons());

        passcodeFinder.getPasscodeBruteForce(file4);
        System.out.println("Number of brute force comparisons: " + passcodeFinder.bruteForceComparisons());
        passcodeFinder.getPasscodeBinarySearch(file4);
        System.out.println("Number of binary search comparisons: " + passcodeFinder.binarySearchComparisons());

        passcodeFinder.getPasscodeBruteForce(file5);
        System.out.println("Number of brute force comparisons: " + passcodeFinder.bruteForceComparisons());
        passcodeFinder.getPasscodeBinarySearch(file5);
        System.out.println("Number of binary search comparisons: " + passcodeFinder.binarySearchComparisons());

        passcodeFinder.getPasscodeBruteForce(file6);
        System.out.println("Number of brute force comparisons: " + passcodeFinder.bruteForceComparisons());
        passcodeFinder.getPasscodeBinarySearch(file6);
        System.out.println("Number of binary search comparisons: " + passcodeFinder.binarySearchComparisons());
    }
}
