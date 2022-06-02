/*
 * Bad shuffling. Suppose that you choose a random integer between 0 and N-1
 * in our shuffling code instead of one between i and N-1. Show that the resulting order is
 * not equally likely to be one of the N! possibilities. Run the test of the previous exercise
 * for this version
 */

package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

public class Ex37_BadShuffle {

    public static void main(String[] args) {
        
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        // array declaration
        int[] arr = new int[M];
        int[][] table = new int[M][M];
        int[][] temp;
        
        for (int j = 0; j < N; j++) 
        {   
            for (int i = 0; i < M; i++) 
            {   // initialization to index position
                arr[i] = i; 
            } 

            // shuffling 
            BadShuffle(arr);
            //StdOut.println("Shuffled");
            //Printing_Arrays.printArray(arr);

            temp = Ex36_ShuffleTest.countOccurence(arr);
            table = Ex33_Matrix.add(table, temp);
            
        }
        Printing_Arrays.printArray(table);
    }

    /*
     * Bad shuffle
     */
    public static void BadShuffle(int[] a) {
        
        int N= a.length;
        for (int i = 0; i < N; i++) {
            int r= StdRandom.uniform(N);
            int temp = a[i];
            a[i]= r;
            a[r]= temp;
        }
    }
}
