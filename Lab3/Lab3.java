/*
 * Made by: Monica
 * This program uses recursive algorithms in the pattern of "Decrease by 1", a subcategory of Decrease and Conquer algorithms.
 */

import java.util.ArrayList;

public class Lab3 {

    // Helper function to recursively get all permutations with the length of the list size
    private ArrayList<String> getNextPattern(int listSize) {

        // Base case is when the list size is 1
        if (listSize == 1) {
            // Get all different number options of length one: 0, 1, and 2
            ArrayList<String> diffNumbers = new ArrayList<>();

            // Store these values into the ArrayList
            diffNumbers.add("0");
            diffNumbers.add("1");
            diffNumbers.add("2");

            // Return base case list
            return diffNumbers;

        } else {

            // Get list of size-1 items
            ArrayList<String> listSizeMinusOne = getNextPattern(listSize-1);

            // Make a copy list to add all values in the smaller list, and those values with 0, 1, and 2 appended to them
            ArrayList<String> allPatterns = new ArrayList<>();

            // Index stores the number of times the while loop has run
            int index = 0;

            // Stores the number of elements in the smaller Arraylist
            int smallListSize = listSizeMinusOne.size();

            // Loop through all values in the smaller list and append 0, 1, and 2 to the current number
            while (index < smallListSize) {
                String newNumberStr0 = listSizeMinusOne.get(index) + "0";
                allPatterns.add(newNumberStr0);

                String newNumberStr1 = listSizeMinusOne.get(index) + "1";
                allPatterns.add(newNumberStr1);

                String newNumberStr2 = listSizeMinusOne.get(index) + "2";
                allPatterns.add(newNumberStr2);

                // Increment index counter
                index++;
            }

            // Return all values in the smaller list and the new values created
            return allPatterns;
        }
    }

    /* 
     * Algorithm for part 1
     * This method calls helper functions to get all patterns of a given length 
     * Parameter: int - length of a pattern
     * Returns: ArrayList of Strings – list of all patterns of the parameter length
     */
    public ArrayList<String> generateAllPatterns(int patternLength) {
        // Print statement to the console to describe the output
        System.out.println("Generating all patterns length " + patternLength + ": ");

        // Call helper function to get all pattern values of the parameter length
        // Stores all values of each pattern in an Arraylist
        ArrayList<String> allPatterns = getNextPattern(patternLength);

        // Print the Arraylist of patterns result
        System.out.println(allPatterns);

        // Return the list of patterns
        return allPatterns;
    }



    // Helper function to check if a string has 2 of the same number consecutively (double digits)
    private boolean hasDoubleDigits(String number) {

        // Loop through each character in the string
        for (int index = 1; index < number.length(); index++) {

            // Check if the characters at the current and previous indexes are the same
            if (number.charAt(index) == number.charAt(index-1)) {
                return true;
            }
        }

        // No double digits were found
        return false;
    }

    // Helper function to recursively get the next patterns with no double digits
    private ArrayList<String> getNextPatternNoDoubleDigits(int listSize) {

        // Base case is when the list size is 1
        if (listSize == 1) {

            // Get all different number options of length one: 0, 1, and 2
            ArrayList<String> diffNumbers = new ArrayList<>();

            // Store these values into the ArrayList
            diffNumbers.add("0");
            diffNumbers.add("1");
            diffNumbers.add("2");

            // Return base case list
            return diffNumbers;

        } else {

            // Get list of size-1 items
            ArrayList<String> listSizeMinusOne = getNextPattern(listSize-1);

            // Make a copy list to add all values in the smaller list, and those values with 0, 1, and 2 appended to them
            ArrayList<String> allPatterns = new ArrayList<>();

            // Stores the number of elements in the smaller Arraylist
            int smallListSize = listSizeMinusOne.size();

            // Loop through all values in the smaller list and append 0, 1, and 2 to the value
            for (int index = 0; index < smallListSize; index++) {

                for (int currNum = 0; currNum <= 2; currNum++) {
                    // Append each of the numbers 0, 1, and 2 to the current string number
                    String newNumberStr = listSizeMinusOne.get(index) + String.valueOf(currNum);
                    
                    // Check if the number does not have double digits by calling a helper function
                    if (hasDoubleDigits(newNumberStr) == false) {

                        // If there are no double digits, add the value to the Arraylist as a new value
                        allPatterns.add(newNumberStr);
                    } 
                }
            }

            // Return all values in the smaller list and the new values created
            return allPatterns;
        }
    }

    /* 
     * Algorithm for part 2
     * This method calls helper functions to get only the patterns that do not have any repeated, consecutive digits
     * Parameter: int - length of a pattern
     * Returns: ArrayList of Strings – list of all patterns of the parameter length
     */
    public ArrayList<String> generatePatternsWithNoDoubleDigits(int patternLength) {
        // Print statement to the console to describe the output
        System.out.println("Generating all patterns of length " + patternLength + " with no double digits: ");

        // Call helper function to get all patterns of the parameter length with no double digits
        // Store this result in an Arraylist 
        ArrayList<String> allPatterns = getNextPatternNoDoubleDigits(patternLength);

        // Print the Arraylist of patterns
        System.out.println(allPatterns);

        // Return the list of patterns
        return allPatterns;
    }


    /* Main method that runs the program and calls the methods for generateAllPatterns() and generatePatternsWithNoDoubleDigits() */
    public static void main(String[] args) {
        // Create a Lab3 object to call the methods
        Lab3 lab3 = new Lab3();

        // Store the length of the pattern
        int patternLength = 3;

        // Call method for part 1 to get all patterns of a certain length
        lab3.generateAllPatterns(patternLength);

        // Call method for part 2 to get all patterns of a certain length with no double digits
        lab3.generatePatternsWithNoDoubleDigits(patternLength);
    }
}