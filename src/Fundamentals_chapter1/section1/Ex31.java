/* Random connections. Write a program that takes as command-line arguments
 * an integer N and a double value p (between 0 and 1), 
 * plots N equally spaced dots of size .05 on the circumference of a circle, 
 * and then, with probability p for each pair of points,
 * draws a gray line connecting them
 */

package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex31 {
    public static void main(String[] args) {
        
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setScale(-2.0, 2.0);
        StdDraw.setPenRadius(.015);

        double[][] d = new double[N][2];
        for (int i = 0; i < N; i++) {
            d[i][0] = Math.cos(2 * Math.PI * i / N);
            d[i][1] = Math.sin(2 * Math.PI * i / N);
            StdDraw.point(d[i][0], d[i][1]);
        }
        
        StdDraw.setPenColor(StdDraw.GRAY);
        for (int i = 0; i < N - 1; i++) {
        	for (int j = i + 1; j < N; j++) {
        		if (StdRandom.bernoulli(p)) {
        			StdDraw.line(d[i][0], d[i][1], d[j][0], d[j][1]);
        		}
        	}
        }
        /* for (int i = 0; i < N; i++) {
            if(StdRandom.bernoulli(p)) 
                StdDraw.line(d[i][0], d[i][1], d[i+1][0], d[i+1][1]);
        } */
    }
}
