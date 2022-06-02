package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

/* 
 * Write a program that reads in lines from standard input with each line 
 * containing a name and two integers and then uses printf() to print a table 
 * with a column of the names, the integers, and the result of dividing the first 
 * by the second, accurate to three decimal places.
 */
public class Ex21 {
    public static void main(String[] args) {
        String s= StdIn.readLine();
        String[] result= s.split(" ");
        for (String i : result) {
            StdOut.print(i+" ");    
        }
        double a, b, temp;
        a = Double.parseDouble(result[1]);
        b = Double.parseDouble(result[2]);
        temp= a/b;
        StdOut.printf("%3.3f", temp);
    }
}
