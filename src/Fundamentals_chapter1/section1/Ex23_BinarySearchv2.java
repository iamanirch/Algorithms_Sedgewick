package Fundamentals_chapter1.section1;

/* 
 * Add to the BinarySearch test client the ability to respond to a second argument: 
 * + to numbers from standard input that are not in the whitelist, 
 * - to print numbers that are in the whitelist
 */

import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class Ex23_BinarySearchv2
{
    public static int rank(int key, int[] a)
    {   return rank(key, a, 0, a.length - 1, 0); }
    
    public static int rank(int key, int[] a, int lo, int hi, int depth)
    {   // Index of key in a[], if present, is not smaller than lo
        // and not larger than hi.
        if (lo > hi) return -1;
        
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]){
            depth++;
            //StdOut.printf("%d\t%d\t%d\t%d%n",key, depth, lo, hi);
            return rank(key, a, lo, mid - 1, depth);
        } 
        else if (key > a[mid]){
            depth++;
            //StdOut.printf("%d\t%d\t%d\t%d%n",key, depth, lo, hi);
            return rank(key, a, mid + 1, hi, depth);
        } 
        else return mid;
    }
    public static void main(String[] args)
    {
        int[] whitelist = new In(args[0]).readAllInts();
        String s= args[1];
        Arrays.sort(whitelist); 
        
        StdOut.printf("Key\tdepth\tlo\thi%n");
        while (!StdIn.isEmpty())
        { // Read key, and print based on second argument 
            int key = StdIn.readInt();
            if(s.equals("+") && rank(key, whitelist) < 0)
                StdOut.printf("Missing member: %d%n",key);
            else if (s.equals("-") && rank(key, whitelist) > 0)
                StdOut.printf("Present Member: %d%n",key);
        }
    }
}
