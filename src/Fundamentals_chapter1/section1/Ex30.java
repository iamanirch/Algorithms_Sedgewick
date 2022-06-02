/*
 * Array exercise. Write a code fragment that creates an N-by-N boolean array
 * a[][] such that a[i][j] is true if i and j are relatively prime (have no common factors), 
 * and false otherwise
 */

package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Ex30 {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[5][3];
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if((j+1)%(i+1) == 0 || (i+1)%(j+1) == 0) arr[i][j] = true;
                else arr[i][j] = false;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                StdOut.print("|" + arr[i][j]);
            }
            StdOut.println("|");
        }
    }
}
