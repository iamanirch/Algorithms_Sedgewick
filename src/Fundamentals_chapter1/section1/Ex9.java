package Fundamentals_chapter1.section1;

import java.io.IOException;

import edu.princeton.cs.algs4.*;

public class Ex9 {
    
    // Write a code fragment that puts the binary representation of a positive integer  N into a String s
	public static void main(String[] args) throws IOException
    {
        int N= Integer.parseInt(args[0]);
        
        String s= "";
        
        while (N > 0) {
            s = N%2 + s;
            N /= 2;
        }
        StdOut.printf("Binary format: %s",s);
    }
}