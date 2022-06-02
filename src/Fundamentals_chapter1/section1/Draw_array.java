package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

public class Draw_array {
    public static void main(String[] args) {
        int N= 10;
        double[] a= new double[N];
        for (int i = 0; i < N; i++) {
            a[i]= StdRandom.uniform();
        }
        for (int i = 0; i < N; i++) {
            double x    = 1.0*i/N;
            double y    = a[i]/2.0;
            double rw   = 0.5/N;
            double rh   = a[i]/2.0;
            StdOut.println(x + " " + y + " " + rw + " " + rh);
            StdDraw.filledRectangle(x, y, rw, rh); 
        }
    }
}
