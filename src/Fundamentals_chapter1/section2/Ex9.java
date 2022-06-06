package Fundamentals_chapter1.section2;

import java.util.*;
import edu.princeton.cs.algs4.*;

/*
 * Instrument BinarySearch (page 47) to use a Counter to count the total number of keys 
 * examined during all searches and then print the total after all searches are complete
 */
public class Ex9 {
    public static void main(String[] args) {
        
        Counter keyCount = new Counter("keys");

        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist); 
        
        while (!StdIn.isEmpty())
        { // Read key, print if not in whitelist.
            int key = StdIn.readInt();

            keyCount.increment();
            if (rank(key, whitelist, keyCount) < 0) 
                System.out.printf("Missing member: %d%n",key);
        }

        System.out.printf("Total keys examined: %d", keyCount.tally());
    }

    public static int rank(int key, int[] a, Counter counter)
    { return rank(key, a, 0, a.length - 1, counter); }

    public static int rank(int key, int[] a, int lo, int hi, Counter counter)
    {   // Index of key in a[], if present, is not smaller than lo
        // and not larger than hi.
        if (lo > hi) return -1;
        
        int mid = lo + (hi - lo) / 2;
        counter.increment();
        if (key < a[mid]) return rank(key, a, lo, mid - 1, counter);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, counter);
        else return mid;
    }
}
