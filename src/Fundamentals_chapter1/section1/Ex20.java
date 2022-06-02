package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

public class Ex20 {
    public static double ln(int N) {
        return Math.log(N);
    }

    public static int factorial(int N) {
        int fact=1, i=N;
        while(i>0){
            fact *= i;
            i--;
        }
        return fact;
    }
    public static void main(String[] args) {
        int N= Integer.parseInt(args[0]);
        StdOut.print(ln(factorial(N)));
    }
}
