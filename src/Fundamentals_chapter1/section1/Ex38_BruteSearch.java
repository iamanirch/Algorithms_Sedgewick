package Fundamentals_chapter1.section1;

import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.*;

/*
 * Binary search versus brute-force search. Write a program BruteForceSearch
 * that uses the brute-force search method given on page 48 and compare its running time
 * on your computer with that of BinarySearch for largeW.txt and largeT.txt
 */
public class Ex38_BruteSearch {
    public static void main(String[] args) {
        
        int[] whitelist = new In(args[0]).readAllInts();
        ArrayList<Integer> keys = new ArrayList<Integer>();
        long startTime, endTime, duration;
        
        Arrays.sort(whitelist); 

        while (!StdIn.isEmpty())
        { // Read keys from Standard input
            keys.add(StdIn.readInt());
        }

        // Binary Search
        startTime = System.nanoTime();
        BruteSearch(keys, whitelist);
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        StdOut.println("Brute Force Duration: " + duration + " nanoseconds.");

        // Brute Search
        startTime = System.nanoTime();
        binarySearch(keys, whitelist);
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        StdOut.println("Binary Duration: " + duration + " nanoseconds.");
    }
    
    /*
     * Rank method for Brute Force search for key in whitelist 
     */
    public static int BruteRank(int key, int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == key) return i;
        return -1;
    }

    /*
     * Brute Force search method 
     */
    public static void BruteSearch(ArrayList<Integer> keys, int[] a) 
    {    
        for (int key : keys) {
            if (BruteRank(key, a) < 0)
                StdOut.printf("Missing member: %d%n",key);    
        }
    }

    /*
     * Binary search method 
     */
    public static void binarySearch(ArrayList<Integer> keys, int[] a) 
    {    
        for (int key : keys) {
            if (Ex_BinarySearch.rank(key, a) < 0)
                StdOut.printf("Missing member: %d%n",key);    
        }
    }
}
