/*
 * Add to BinarySearch a static method rank() that takes a key and
 * a sorted array of int values (some of which may be equal) as arguments and returns the
 * number of elements that are smaller than the key and a similar method count() that
 * returns the number of elements equal to the key. Note : If i and j are the values returned
 * by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in
 * the array that are equal to key
 */

package Fundamentals_chapter1.section1;

import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class Ex29 
{
    public static int rank(int key, int[] a)
    {   // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int lessThanKey(int key, int[] a) {
        int nums = 0;

        for (int i : a) {
            if(key > i) nums++;
        }

        return nums;
    }

    public static int count(int key, int[] a) {
        int c = 0;

        for (int i : a) { if(i == key) c++; }
        return c;
    }

    public static void main(String[] args)
    {
        int[] whitelist = new In(args[0]).readAllInts();
        int nums = 0;
        Arrays.sort(whitelist); 
        
        while (!StdIn.isEmpty())
        { // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            
            if (rank(key, whitelist) < 0){
                nums = lessThanKey(key, whitelist);
                StdOut.printf("Missing:%d %d%n",key, nums);
            }
            else {
                nums = rank(key, whitelist);
                StdOut.printf("Present:%d %d%n",key, nums);
            }
                
        }
    }
}