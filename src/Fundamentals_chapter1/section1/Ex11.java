package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

/*
 * Write a code fragment that prints the contents of a two-dimensional boolean array, 
 * using * to represent true and a space to represent false. 
 * Include row and column numbers
 */
public class Ex11 {
    

    public static void main(String[] args) {
        
        // create and declare 2D array
        boolean[][] a = new boolean[3][3];
        double temp;

        // randomly initialize 
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                temp = StdRandom.uniform();
                if(temp < 0.5){
                    a[i][j] = false;
                    StdOut.print("|*");
                } 
                else{
                    a[i][j] = true;
                    StdOut.print("| ");
                } 
            }
            StdOut.println("|");
        }
        
    }
}
