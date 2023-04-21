/*
 * Made by: Monica
 * This program looks at the effects of different hash table sizes and hash functions on the number of collisions that occur while inserting data into a hash table using simple hash techniques. This is counting collisions, not probes.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Lab5 {

    /**
     * Creates 12 hash tables for each method's results.
     * Displays the hash table outputs for a data file, with 12 different result
     * numbers.
     * Calls each hash function for each of the 12 combinations of functions and
     * sizes.
     * 
     * @param filename, String
     */
    public void DoTheStuff(String filename) {

        try {
            // Get the names from the text file as an array
            String[] namesList = storeFileNames(filename);
            int N = namesList.length;

            // 12 hash tables for: 3 different functions, 4 different sizes (N, 2N, 5N, 10N)
            String[] h1_N = new String[N];
            String[] h1_2N = new String[2 * N];
            String[] h1_5N = new String[5 * N];
            String[] h1_10N = new String[10 * N];

            String[] h2_N = new String[N];
            String[] h2_2N = new String[2 * N];
            String[] h2_5N = new String[5 * N];
            String[] h2_10N = new String[10 * N];

            String[] h3_N = new String[N];
            String[] h3_2N = new String[2 * N];
            String[] h3_5N = new String[5 * N];
            String[] h3_10N = new String[10 * N];

            // Stores the total number of collisions for each hash table
            int[] collisionCounts = new int[12];

            // Call all 12 different combinations of hash methods and size numbers for each
            // name in the array
            for (String currName : namesList) {
                // Hash function 1 method
                int hashValueH1_N = H1(currName, N);
                boolean hasCollisionH1_N = placeNameInTable(currName, hashValueH1_N, h1_N);
                if (hasCollisionH1_N) {
                    collisionCounts[0] += 1;
                }

                int hashValueH1_2N = H1(currName, 2 * N);
                boolean hasCollisionH1_2N = placeNameInTable(currName, hashValueH1_2N, h1_2N);
                if (hasCollisionH1_2N) {
                    collisionCounts[1] += 1;
                }

                int hashValueH1_5N = H1(currName, 5 * N);
                boolean hasCollisionH1_5N = placeNameInTable(currName, hashValueH1_5N, h1_5N);
                if (hasCollisionH1_5N) {
                    collisionCounts[2] += 1;
                }

                int hashValueH1_10N = H1(currName, 10 * N);
                boolean hasCollisionH1_10N = placeNameInTable(currName, hashValueH1_10N, h1_10N);
                if (hasCollisionH1_10N) {
                    collisionCounts[3] += 1;
                }

                // Hash function 2 method
                double hashValueH2_N = H2(currName, N);
                boolean hasCollisionH2_N = placeNameInTable(currName, hashValueH2_N, h2_N);
                if (hasCollisionH2_N) {
                    collisionCounts[4] += 1;
                }

                double hashValueH2_2N = H2(currName, 2 * N);
                boolean hasCollisionH2_2N = placeNameInTable(currName, hashValueH2_2N, h2_2N);
                if (hasCollisionH2_2N) {
                    collisionCounts[5] += 1;
                }

                double hashValueH2_5N = H2(currName, 5 * N);
                boolean hasCollisionH2_5N = placeNameInTable(currName, hashValueH2_5N, h2_5N);
                if (hasCollisionH2_5N) {
                    collisionCounts[6] += 1;
                }

                double hashValueH2_10N = H2(currName, 10 * N);
                boolean hasCollisionH2_10N = placeNameInTable(currName, hashValueH2_10N, h2_10N);
                if (hasCollisionH2_10N) {
                    collisionCounts[7] += 1;
                }

                // Hash function 3 method
                int hashValueH3_N = H3(currName, N);
                boolean hasCollisionH3_N = placeNameInTable(currName, hashValueH3_N, h3_N);
                if (hasCollisionH3_N) {
                    collisionCounts[8] += 1;
                }

                int hashValueH3_2N = H3(currName, 2 * N);
                boolean hasCollisionH3_2N = placeNameInTable(currName, hashValueH3_2N, h3_2N);
                if (hasCollisionH3_2N) {
                    collisionCounts[9] += 1;
                }

                int hashValueH3_5N = H3(currName, 5 * N);
                boolean hasCollisionH3_5N = placeNameInTable(currName, hashValueH3_5N, h3_5N);
                if (hasCollisionH3_5N) {
                    collisionCounts[10] += 1;
                }

                int hashValueH3_10N = H3(currName, 10 * N);
                boolean hasCollisionH3_10N = placeNameInTable(currName, hashValueH3_10N, h3_10N);
                if (hasCollisionH3_10N) {
                    collisionCounts[11] += 1;
                }
            }

            // Display results for all collision counts
            System.out.println("Total collisions for " + filename + ":");

            // These variables keep track of the current hash function number and current
            // index in the collisionCounts array. They are used in the while loop to print
            // the results to the console
            int currPrintHash = 1;
            int currPrintIndex = 0;

            // This loop prints the results of each hash method (hash 1, hash 2, hash 3) to
            // the console in the format:
            // Hash function #
            // N    2*N     5*N     10*N
            while (currPrintIndex < 12) {
                System.out.println("Hash function " + currPrintHash + ":");
                for (int i = 0; i < 4; i++) {
                    System.out.print(collisionCounts[currPrintIndex] + "\t");
                    currPrintIndex++;
                }
                System.out.println();
                currPrintHash++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads all names from a text file and stores the names into an array.
     * 
     * @param fileName, String name of the file
     * @return namesList, String array of all names in the text file
     * @throws FileNotFoundException if file doesn't exist
     */
    private String[] storeFileNames(String fileName) throws FileNotFoundException {

        try {
            // Create BufferedReader and FileReader objects to read through each line in the
            // file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            // Read each line in the file
            String currLine = bufferedReader.readLine();

            // Get each name value separated by commas
            String[] namesList = currLine.split(",");

            // Close BufferedReader object
            bufferedReader.close();

            // Return the array of names from the file
            return namesList;

        } catch (Exception e) {
            // If an error occurs
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Helper function to place a name in a valid index of the hash table array.
     * 
     * @param currName,  String of a name
     * @param hashValue, double
     * @param hashTable, String array
     * @return hasCollision, boolean. The value is true if there was a collision,
     *         otherwise the value is false
     */
    private boolean placeNameInTable(String currName, double hashValue, String[] hashTable) {
        // Stores value of whether or not there was a collision
        boolean hasCollision = false;

        // Get hash value as an integer
        int currHashIndex = (int) hashValue;

        // If there is a collision, loop through the array until an empty spot is found
        while (hashTable[currHashIndex] != null) {
            hasCollision = true;

            // Circular loop to find next empty array index
            if (currHashIndex == hashTable.length - 1) {
                // If the end of the array was reached and there were no available spots, go
                // back to the beginning of the array and keep checking
                currHashIndex = 0;
            } else {
                // Increment to the next index
                currHashIndex++;
            }
        }

        // Store the name in the next valid array index
        hashTable[currHashIndex] = currName;

        // Return if a collision occurred
        return hasCollision;
    }

    /**
     * Hash function 1 is found by getting the sum of the values of the name string
     * letters, then mod the sum by the number of names.
     * 
     * @param nameString, String
     * @param N,          int. Number of names in the file
     * @return hashValue, integer value of the hashed name
     */
    private int H1(String nameString, int N) {
        // Stores the sum of the letter indices
        int lettersSum = 0;

        // Alphabet letters, used to reference each letter's position in the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Loop through each letter in the name string
        for (int index = 0; index < nameString.length(); index++) {
            // Get the character at the current index
            char currLetter = nameString.charAt(index);

            // Get the character's index number
            int letterIndex = alphabet.indexOf(currLetter) + 1;

            // Add the letter's index to the sum
            lettersSum += letterIndex;
        }

        // Mod the sum result
        int hashValue = lettersSum % N;
        return hashValue;
    }

    /**
     * Hash function 2 is found by getting the sum of the name string letters,
     * multiplying their character value in the alphabet by 26 to the power of the
     * index of the string, then mod that result by the number of names.
     * 
     * @param nameString, String
     * @param N,          int. Number of names in the file
     * @return hashValue, double value of the hashed name. A double is used to store
     *         the hashed value to prevent integer overflow problems with long
     *         names.
     */
    private double H2(String nameString, int N) {
        // Stores the sum of the letter indices
        double lettersSum = 0;

        // Alphabet letters, used to reference each letter's position in the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Loop through each letter in the name string
        for (int index = 0; index < nameString.length(); index++) {
            // Get the character at the current index
            char currLetter = nameString.charAt(index);

            // Get character as a number
            int letterIndex = alphabet.indexOf(currLetter) + 1;

            // Get value of 26 to the power of the current index
            double twentySixPower = Math.pow(26, index);

            // Multiply the character index by 26 to the power of the character index, then
            // add this number to the sum
            lettersSum += (letterIndex * twentySixPower);
        }

        // Mod the sum result
        double hashValue = lettersSum % N;
        return hashValue;
    }

    /**
     * Hash function 3 is a function I created. The hash value is found by getting
     * the sum of each name string letter's ASCII number,
     * then multiply and add the sum by a random number,
     * then call the hash 1 function on my name (Monica) using that random number as
     * the size,
     * and mod this result by the number of names.
     * 
     * @param nameString, String
     * @param N,          int. Number of names in the file
     * @return hashValue, integer value of the hashed name
     */
    private int H3(String nameString, int N) {
        // Stores the sum of the letter indices
        int lettersSum = 0;

        // Loop through each letter in the name string
        for (int index = 0; index < nameString.length(); index++) {
            // Get the character at the current index
            char currLetter = nameString.charAt(index);

            // Get character's corresponding ASCII number
            int letterNum = (int) currLetter;

            // Add ASCII number to the sum
            lettersSum += letterNum;
        }

        // Stores a random number
        int randomNum = 123;

        // Multiply and add the random number to the sum, then call the hash 1 function
        // on the name Monica with the random number as the size parameter
        lettersSum *= H1("MONICA", randomNum);

        // Mod the sum result
        int hashValue = lettersSum % N;
        return hashValue;
    }

    /*
     * Main method that runs the program and calls the DoTheStuff() method on each
     * text file.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Lab5 object to call methods
        Lab5 lab5 = new Lab5();

        // Call DoTheStuff method on each text file
        // Note: this code assumes the text files are in the same directory as this Java
        // file
        lab5.DoTheStuff("Lab5/37_names.txt");
        lab5.DoTheStuff("Lab5/333_names.txt");
        lab5.DoTheStuff("Lab5/5163_names.txt");
    }
}