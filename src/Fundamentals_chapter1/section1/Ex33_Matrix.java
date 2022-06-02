/*
 * static double dot(double[] x, double[] y) vector dot product
 * static double[][] mult(double[][] a, double[][] b) matrix-matrix product
 * static double[][] transpose(double[][] a) transpose
 * static double[] mult(double[][] a, double[] x) matrix-vector product
 * static double[] mult(double[] y, double[][] a) vector-matrix product
 */

package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

public class Ex33_Matrix {
    public static void main(String[] args) { 
        double[] x = {1,2,3};
        double[] y = {4,5,6};
        double[][] a = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        double[][] b = {
            {7, 8, 9},
            {4, 5, 6}
        };
        
        dot(x, y);
        mult(a, b);
        transpose(a);
        mult(b, y);
        mult(x, a);
    }

    public static void dot(double[] arr1, double[] arr2) 
    {   // dot product of two vectors
        double result = 0.0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(i==j) result += arr1[i] * arr2[j];
            }
        }
        StdOut.println("Dot Product");
        StdOut.println(result);
    }

    public static void mult(double[][] arr1, double[][] arr2) 
    {   // matrix multiplication
        
        double[][] result = new double[arr1.length][arr2[0].length]; 
        try {      
            for (int i = 0; i < arr1.length; i++) {
                for (int k = 0; k < arr2[0].length; k++) {
                    for (int j = 0; j < arr1[0].length; j++) {
                        result[i][k] += arr1[i][j] * arr2[j][k];
                    }
                }
            }
        }
        catch(Exception e)  
        {  // handling the exception  
            System.out.println("Index of arrays are not compatible");  
        }
        StdOut.println("Matrix-Matrix Product");
        printArray(result);
    }

    public static void transpose(double[][] arr) 
    {   // transposition
        double[][] result = new double[arr[0].length][arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[j][i] = arr[i][j];
            }
        }
        printArray(result);
    }

    public static void mult(double[][] arr1, double[] arr) 
    {   // matrix multiplication
        
        double[] result = new double[arr1.length]; 
        try {      
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    result[i] = arr1[i][j] * arr[j];
                }
            }
        }
        catch(Exception e)  
        {  // handling the exception  
            System.out.println("Index of arrays are not compatible");  
        }
        StdOut.println("Matrix-Vector Product");
        printArray(result);
    }

    public static void mult(double[] arr, double[][] arr2) 
    {   // matrix multiplication
        
        double[] result = new double[arr2[0].length]; 
        try {      
            for (int i = 0; i < arr2[0].length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    result[i] += arr2[j][i] * arr[j];
                }
            }
        }
        catch(Exception e)  
        {  // handling the exception  
            StdOut.println("Index of arrays are not compatible");  
        }
        StdOut.println("Vector-Matrix Product");
        printArray(result);
    }

    public static double[] subtract(double[] arr1 , double[] arr2) 
    {   // subtract arr1 - arr2
        double[] result = new double[arr1.length];
        try {
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    result[i] = arr1[i] - arr2[i];
                }
            }
        } catch (Exception e) {
            // handle exception
            StdOut.println("Inconsistent indices");
        }
        return result;
    }

    public static int[] subtract(int[] arr1 , int[] arr2) 
    {   // subtract arr1 - arr2
        int[] result = new int[arr1.length];
        try {
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    result[i] = arr1[i] - arr2[i];
                }
            }
        } catch (Exception e) {
            // handle exception
            StdOut.println("Inconsistent indices");
        }
        return result;
    }
    
    public static double[] add(double[] arr1 , double[] arr2) 
    {   // add arr1 + arr2
        double[] result = new double[arr1.length];
        try {
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    result[i] = arr1[i] + arr2[i];
                }
            }
        } catch (Exception e) {
            // handle exception
            StdOut.println("Inconsistent indices");
        }
        return result;
    }

    public static int[] add(int[] arr1 , int[] arr2) 
    {   // add arr1 + arr2
        int[] result = new int[arr1.length];
        try {
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    result[i] = arr1[i] + arr2[i];
                }
            }
        } catch (Exception e) {
            // handle exception
            StdOut.println("Inconsistent indices");
        }
        return result;
    }

    public static double[][] add(double[][] arr1, double[][] arr2) 
    {   // 2D matrix addition double values
        
        double[][] result = new double[arr1.length][arr1[0].length]; 
        try {      
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[0].length; j++) {
                        result[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
        }
        catch(Exception e)  
        {  // handling the exception  
            System.out.println("Index of arrays are not compatible");  
        }
        return result;
    }

    public static int[][] add(int[][] arr1, int[][] arr2) 
    {   // 2D matrix addition integer values
        
        int[][] result = new int[arr1.length][arr1[0].length]; 
        try {      
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[0].length; j++) {
                        result[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
        }
        catch(Exception e)  
        {  // handling the exception  
            System.out.println("Index of arrays are not compatible");  
        }
        return result;
    }

    public static void printArray(double[][] arr) 
    {   // printing a 2D array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                StdOut.print(arr[i][j]+ " ");
            }
            StdOut.println();
        }
    }

    public static void printArray(double[] arr) 
    {   // printing a vector
        for (int i = 0; i < arr.length; i++) {
            StdOut.println(arr[i]);
        }
    }
}
