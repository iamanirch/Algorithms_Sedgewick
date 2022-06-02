package Fundamentals_chapter1.section1;

import java.io.IOException;

import edu.princeton.cs.algs4.*;

public class Ex5 {

	public static void main(String[] args) throws IOException
    {

		// Write a code fragment that prints  true if the double variables x and y are both strictly between 0 and 1 and false otherwise
		
        double x= StdIn.readDouble();
        double y= StdIn.readDouble();
        if(x>0 && y>0 && x<1 && y<1){ 
            StdOut.printf("x: %f y: %f%n",x, y);
            StdOut.println("True");
        }
        else{
            StdOut.printf("x: %f y: %f%n",x, y);
            StdOut.println("False");
        }
    }
}
