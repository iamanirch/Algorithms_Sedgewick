package Fundamentals_chapter1.section1;

import java.util.Arrays;
import edu.princeton.cs.algs4.*;

/*
 * Recursive implementation of BinarySearch - basic version
 */
public class Ex_BinarySearch 
{
    public static int rank(int key, int[] a)
    { return rank(key, a, 0, a.length - 1); }

    public static int rank(int key, int[] a, int lo, int hi)
    {   // Index of key in a[], if present, is not smaller than lo
        // and not larger than hi.
        if (lo > hi) return -1;
        
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }

    public static void main(String[] args)
    {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist); 
        
        while (!StdIn.isEmpty())
        { // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0)
                StdOut.printf("Missing member: %d%n",key);
        }
    }
}
