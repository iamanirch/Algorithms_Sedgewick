package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

/**
 * Mathematical summary of an array
 */
public class Maths_array {
    public static void main(String[] args) {
        
        int[] a = {1, 1, 5, 0, 3};
        int sum = 0;
        int max= a[0];
        double avg = 0.0;

        for(int i=1; i<a.length; i++)
        {
            sum += a[i]; // average
            if (a[i]>max) max = a[i]; // maximum
        }
        avg = (double) sum/a.length;
        StdOut.printf("Maximum : %d%n",max);
        StdOut.printf("Sum : %d%n",sum);
        StdOut.printf("Maximum : %3.4f%n",avg);
    }
}