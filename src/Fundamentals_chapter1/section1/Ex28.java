package Fundamentals_chapter1.section1;

/* 
 * Remove duplicates. Modify the test client in BinarySearch to remove any 
 * duplicate keys in the whitelist after the sort.
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class Ex28
{
    public static void main(String[] args)
    {
        int[] whitelist = new In(args[0]).readAllInts();
        String s = args[1];
        Arrays.sort(whitelist); 
        
        // Removing duplicates
        int[] CompactWhitelist = unique(whitelist);

        //StdOut.printf("Key\tdepth\tlo\thi%n");
        while (!StdIn.isEmpty())
        { // Read key, and print based on second argument 
            int key = StdIn.readInt();
            if(s.equals("+") && rank(key, CompactWhitelist) < 0)
                StdOut.printf("Missing member: %d%n",key);
            else if (s.equals("-") && rank(key, CompactWhitelist) >= 0)
                StdOut.printf("Present Member: %d%n",key);
        }
    }

    public static int[] unique(int[] arr) {
        
        int[] new_arr = new int[arr.length];
        int j = 0;
        new_arr[0] = arr[0];
        
        for (int i = 1; i < arr.length; i++) {

            if(new_arr[j] != arr[i]) {
                j++;
                new_arr[j] = arr[i];
            }    
        }
        j++;

        int[] CompactArr = new int[j];
        System.arraycopy(new_arr, 0, CompactArr, 0, j);
        
        return CompactArr;
    }

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
}
