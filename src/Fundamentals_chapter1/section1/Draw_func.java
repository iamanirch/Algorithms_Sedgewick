package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;

public class Draw_func {

    public static void main(String[] args) {
        int N = 100;
        StdDraw.setXscale(0, N); 
        StdDraw.setYscale(0, N*N); 
        StdDraw.setPenRadius(.01); 
        for (int i = 1; i <= N; i++) 
        {
            StdDraw.point(i, i); // 
            StdDraw.point(i, i*i);
            StdDraw.point(i, i*Math.log(i)); 
        }    
    }
}
