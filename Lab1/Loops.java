/*
 * Made by: Monica
 * This is a program for determining basic operation and calculating the running time of (non-recursive) algorithms.
 */
public class Loops {

    // public boolean problem4(int A[][]) {
    //     for (int i = 0; i < n - 1; i++) {
    //         if (A[i][i] == 0) {
    //             System.out.println("First if statement");
    //             return false;
    //         }
    //     }
    //     for (int r = 1; r < n - 1; r++) {
    //         for (int c = 0; c < r - 1; c++) {
    //             if (A[r][c] != A[c][r]) {
    //                 System.out.println("Second if statement");
    //                 return false;
    //             }
    //         }
    //     }
    // }

    public static void main(String args[]) {
        int n = 3;
        int A[][] = new int[n][n];

        for (int i = 0; i < n - 1; i++) { // Runs i=0,1,2 --> runs 3 times (n times)
            for (int j = 0; j < n - 1; j++) { // Runs i=0,1,2 --> runs 3 times (n times)
                A[i][j] = i * j;
            }
        }

        // Loops loops = new Loops();
        // loops.problem4(A);



        n = 7;
        int B[][] = new int[n][n];
        // Set outer row & col 0 values to 1
        for (int i = 0; i < n; i++) {
            B[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            B[0][i] = 1;
        }


        for (int r = 1; r < n - 1; r++) {
            for (int c = 1; c < n - 1; c++) {
                // System.out.println("i: " + i + ", " + "c: " + c);
                B[r][c] = (B[r-1][c]) + (B[r][c-1]);
            }
        }


        for (int i = 0; i < n - 1; i++) {
            for (int c = 0; c < n - 1; c++) {
                System.out.print(B[i][c] + "\t");
            }
            System.out.println();
        }

    }
}
