/*  
 * Made by: Monica
 * This lab uses the brute force algorithm.
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Lab2 {

    // Stores the value of 37, which is used to check if a number is a multiple of 37
    public static final int THIRTY_SEVEN = 37;

    
    /* Reads all number from a text file and Stores the numbers into an Arraylist */
    private ArrayList<Integer> storeFileNumbers(String fileName) throws FileNotFoundException {
        // List to store all numbers
        ArrayList<Integer> numbersList = new ArrayList<>();

		try {
            // Create BufferedReader and FileReader objects to read through each line in the file
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

        // Return the Arraylist of numbers from the file
        return numbersList;
    }


    /* Goes through each set of 3 numbers in the array, calculates the sum, and checks if the sum is a multiple of 37 */
    private int[] performBruteForce(ArrayList<Integer> numbersList) {
        // Integers to store each number for each set of 3 numbers
        Integer number1 = 0;
        Integer number2 = 0;
        Integer number3 = 0;

        // Stores result of a sum that's a multiple of 37
        int[] tripleResult = new int[3];

        // Store the 3 number's array indexes
        int first = 0;
        int second = 1;
        int third = 2;

        // Loop through every possible set of 3 number combinations in the array
        for (first = 0; first < numbersList.size(); first++) {
            // The 3 array indexes are always the previous index + 1
            second = first + 1;
            third = second + 1;

            // Store value of first number in this set of 3 numbers
            number1 = numbersList.get(first);

            while (second < numbersList.size()) {
                // Store value of second number
                number2 = numbersList.get(second);

                while (third < numbersList.size()) {
                    // Store value of third number
                    number3 = numbersList.get(third);

                    // Add up the 3 numbers
                    int sum = number1 + number2 + number3;

                    // Check if the numbers add up to a multiple of 37
                    // If the sum divided by 37 has a remainder of 0, the result is a multiple of 37
                    if (sum % THIRTY_SEVEN == 0) {
                        // Store the 3 numbers
                        tripleResult[0] = number1;
                        tripleResult[1] = number2;
                        tripleResult[2] = number3;

                        // Print the 3 numbers in the triple to the console
                        System.out.println(Arrays.toString(tripleResult));

                        // Since a triple was found, we don't need to keep looping through the numbers because we found the answer
                        return tripleResult;
                    }

                    // Increment third index by 1
                    third++;
                }

                // Increment second and third indexes by 1
                second++;
                third = second + 1;
            }
        }

        // If no triple was found
        System.out.println("No triple that adds up to a multiple of 37 was found.");
        return null;
    }


    /*  
    * Calls helper methods that store all numbers from a file into an Arraylist, and calculate each set of 3 numbers
    * to see if the sum is a multiple of 37 
    */
    public void doTheStuff(String fileName) throws FileNotFoundException {
        // Call method to read numbers from the file and store them in an Arraylist
        ArrayList<Integer> numbersList = storeFileNumbers(fileName);

        // Call method to perform a brute force algorithm to find a triple that adds up to a multiple of 37
        performBruteForce(numbersList);
    }


    /* Main method that runs the program and calls the doTheStuff() method for each data text file */
    public static void main(String[] args) throws FileNotFoundException {
        // Create Lab2 object to call the doTheStuff() method
        Lab2 lab2 = new Lab2();
        
        // Test algorithm on all 7 data text files
        for (int num = 0; num < 2; num++) {
            // String object stores the name of the current text file (files go from data0.txt to data6.txt)
            // Note: this code assumes that the text files are located in the same folder
            String fileName = "./data" + num + ".txt";

            // Print the file name
            System.out.print(fileName + "\t");

            // Call doTheStuff() method
            lab2.doTheStuff(fileName);            
        }
    }
}
