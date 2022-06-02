package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

public class Printing_Arrays {

    public static void printArray(double[][] arr) 
    {   // printing a 2D array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                StdOut.printf("%5.3f ",arr[i][j]);
            }
            StdOut.println();
        }
    }

    public static void printArray(double[] arr) 
    {   // printing a vector
        for (int i = 0; i < arr.length; i++) {
            StdOut.printf("%5.3f%n",arr[i]);
        }
    }

    public static void printArray(int[][] arr) 
    {   // printing a 2D array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                StdOut.printf("%d ",arr[i][j]);
            }
            StdOut.println();
        }
    }

    public static void printArray(int[] arr) 
    {   // printing a vector
        for (int i = 0; i < arr.length; i++) {
            StdOut.printf("%d%n",arr[i]);
        }
    }
}
