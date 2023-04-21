/*  
 * Made by: Monica
 * This program uses dynamic programming.
 */

import java.time.Instant;

/**
 * Lab9 class is the driver of the program. It includes methods to perform
 * recursive and dynamic programming algorithms for calculating the distance it
 * takes to get from 1 point to another on a grid.
 */
public class Lab9 {

    /**
     * Recursive method to calculate the number of different ways to walk m
     * blocks down and n blocks over on a grid of city streets.
     * 
     * @param m - integer, number of blocks (going down)
     * @param n - integer, number of blocks (going across to the right)
     * @return sum of the distances it took to walk m blocks down and n blocks over
     *         on a grid
     */
    public long SW_Recursive(int m, int n) {
        // Base cases: there is only 1 way to get where you started
        // If m is 0, return 1
        if (m == 0) {
            return 1;
        }
        // If n is 0, return 1
        if (n == 0) {
            return 1;
        }

        // If m or n is less than 0, return 0 since there are no ways to go backwards
        // from where you started, and we are focusing only on paths moving right and
        // down the grid. Therefore, m and n must be at least 0 in order to perform this
        // method accurately.
        if (m < 0 || n < 0) {

            // Print descriptive error message
            System.out.println("Error: values of m and n must be at least 0.");

            // Return 0
            return 0;
        }

        // Recursive case: return the sum of the distances to the left and above the
        // current position
        return SW_Recursive(m - 1, n) + SW_Recursive(m, n - 1);
    }

    /**
     * Function to call the recursive method SW_Recursive(m, n) starting from the
     * first number parameter, until the last number parameter.
     * 
     * @param first - integer, starting number
     * @param last  - integer, ending number
     */
    public void RunRecursive(int first, int last) {

        // Loop through each value starting from the first number to the last number
        for (int index = first; index <= last; index++) {

            // Start a timer which times how long it takes the method to run
            long startingTime = Instant.now().toEpochMilli();

            // Call SW recursive method which returns a number value representing the number
            // of ways to get to the end point
            System.out.print("SW_Recursive(" + index + "," + index + ") = " + SW_Recursive(index, index) + ", ");

            // End the timer
            long endingTime = Instant.now().toEpochMilli();

            // Find how long the method took in milliseconds by calculating the end time
            // minus the start time
            long timeTaken = endingTime - startingTime;

            // Print the time taken to perform the current method
            System.out.println("time is " + timeTaken + " ms");
        }
    }

    /**
     * Dynamic programming method to calculate the number of different ways to walk
     * m blocks down and n blocks over on a grid of city streets.
     * 
     * @param m - integer, number of blocks (going down)
     * @param n - integer, number of blocks (going across to the right)
     * @return sum of the distances it took to walk m blocks down and n blocks over
     *         on a grid
     */
    public long SW_DynamicProg(int m, int n) {
        // Base cases: there is only 1 way to get where you started
        // If m is 0, return 1
        if (m == 0) {
            return 1;
        }
        // If n is 0, return 1
        if (n == 0) {
            return 1;
        }

        // If m or n is less than 0, return 0 since there are no ways to go backwards
        // from where you started, and we are focusing only on paths moving right and
        // down the grid. Therefore, m and n must be at least 0 in order to perform this
        // method accurately.
        if (m < 0 || n < 0) {

            // Print descriptive error message
            System.out.println("Error: values of m and n must be at least 0.");

            // Return 0
            return 0;
        }

        // 2D array stores the number of ways to get to each position in the grid from
        // the starting position
        long matrixResults[][] = new long[m + 1][n + 1];

        // Initial setup: set all values of column 0 to all 1's. There is only 1 path to
        // get down the first column.
        for (int mValue = 0; mValue <= m; mValue++) {
            matrixResults[mValue][0] = 1;
        }

        // Initial setup: set all values of row 0 to all 1's. There is only 1 path to
        // get across the first row.
        for (int nValue = 0; nValue <= n; nValue++) {
            matrixResults[0][nValue] = 1;
        }

        // Loop through each row in the 2D array
        for (int mValue = 1; mValue <= m; mValue++) {

            // Loop through each column in the 2D array
            for (int nValue = 1; nValue <= n; nValue++) {

                // Add the values above and to the left to get the current index value
                matrixResults[mValue][nValue] = matrixResults[mValue - 1][nValue] + matrixResults[mValue][nValue - 1];
            }
        }

        // The result for the number of different paths is the very last position in the
        // array
        long swResult = matrixResults[m][n];

        // Return the number of different paths
        return swResult;
    }

    /**
     * Function to call the dynamic programming method SW_DynamicProg(m, n) starting
     * from the
     * first number parameter, until the last number parameter.
     * 
     * @param first - integer, starting number
     * @param last  - integer, ending number
     */
    public void RunDynamicProg(int first, int last) {

        // Loop through each value starting from the first number to the last number
        for (int index = first; index <= last; index++) {

            // Start a timer which times how long it takes the method to run
            long startingTime = Instant.now().toEpochMilli();

            // Call SW recursive method which returns a number value representing the number
            // of ways to get to the end point
            System.out.print("SW_DynamicProg(" + index + "," + index + ") = " + SW_DynamicProg(index, index) + ", ");

            // End the timer
            long endingTime = Instant.now().toEpochMilli();

            // Find how long the method took in milliseconds by calculating the end time
            // minus the start time
            long timeTaken = endingTime - startingTime;

            // Print the time taken to perform the current method
            System.out.println("time is " + timeTaken + " ms");
        }
    }

    /**
     * Main method that runs the program and calls SW methods to perform the
     * recursive and dynamic programming algorithms to finding the number of
     * different paths to get from one position to another on a grid.
     * 
     * @param args - String array
     */
    public static void main(String[] args) {
        // Create a Lab9 object to use for calling the recursive and dynamic methods for
        Lab9 lab9 = new Lab9();

        // Prints a message for the Recursive Method
        System.out.println("----------------- SW Recursive Method -----------------");

        // Call the SW method to run the recursive algorithm for the numbers 0 to 5
        lab9.RunRecursive(0, 5);

        // Prints a message for the Dynamic Method
        System.out.println("----------------- SW Dynamic Method -------------------");

        // Call the SW method to run the dynamic programming algorithm for the numbers
        // 20 to 24
        lab9.RunDynamicProg(20, 24);
    }
}
