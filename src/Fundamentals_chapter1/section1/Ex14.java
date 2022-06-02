package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

/*
 * Write a static method lg() that takes an int value N as argument and 
 * returns the largest int not larger than the base-2 logarithm of N. 
 * Do not use Math.
 */ 
public class Ex14 {
    

    public static int lg(int N) {
        int loga=0, temp= N;
        
        while (temp > 1) {
            temp /= 2;
            loga++;
        }
        return loga;
    }
    public static void main(String[] args) {
        StdOut.print(lg(StdIn.readInt()));
    }
}
