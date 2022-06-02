package Fundamentals_chapter1.section1;

//import edu.princeton.cs.algs4.*;

/*
 * Empirical shuffle check. Run computational experiments to check that our
 * shuffling code on page 32 works as advertised. Write a program ShuffleTest that takes
 * command-line arguments M and N, does N shuffles of an array of size M that is 
 * initialized with a[i] = i before each shuffle, and prints an M-by-M table such that row i
 * gives the number of times i wound up in position j for all j. 
 * All entries in the array should be close to N/M
 */
public class Ex36_ShuffleTest {
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
            Methods_examples.shuffle(arr);
            //StdOut.println("Shuffled");
            //Printing_Arrays.printArray(arr);

            temp = countOccurence(arr);
            table = Ex33_Matrix.add(table, temp);
            
        }
        Printing_Arrays.printArray(table);
    }

    /*
     * Count occurrences of i in position j after shuffling
     */
    public static int[][] countOccurence(int[] arr) {
        
        int[][] result = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i == arr[j]){
                    //StdOut.printf("%d %d%n",i,j);
                    result[i][j]++;
                }
            }
        }
        return result;
    }
}
