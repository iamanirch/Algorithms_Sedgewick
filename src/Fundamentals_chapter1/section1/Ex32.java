/*
 * Histogram. Suppose that the standard input stream is a sequence of double values. 
 * Write a program that takes an integer N and two double values l and r from the
 * command line and uses StdDraw to plot a histogram of the count of the numbers in the
 * standard input stream that fall in each of the N intervals defined by dividing (l , r) into
 * N equal-sized intervals
 */

package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

public class Ex32 {

	public static void main(String[] args) {

		int N = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]);
		double r = Double.parseDouble(args[2]);

		double[] arr = new double[N];

		for (int i = 0; i < N; i++) 
		{ 	// create input array 
			arr[i] = StdRandom.uniform(l , r);
			//StdOut.printf("%3.2f%n", arr[i]);	
		}

		double[] bins = setIntervals(N, l, r);
		int[] frequency = putIntoIntervals(N, bins, arr);
		histogram(frequency, N, l, r, bins);
	}
		
	public static double[] setIntervals(int N, double l, double r) {
		double[] window = new double[N+1];	
		double wide = (r - l)/N;
		
		for (int i = 0; i < N+1; i++) 
		{ 	// create bins for histogram
			window[i] = l + i*wide; 
			//StdOut.printf("%3.2f%n", window[i]);	
		}
		return window;
	}

	public static int[] putIntoIntervals(int N, double window[], double arr[]) {
		
		int[] count = new int[N];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < window.length-1; j++) {
				if(arr[i] < window[j]){
					count[j-1] += 1;
					break;
				} 
			}
		}
		return count;
	}

	public static void histogram(int[] frequency, int N, double l, double r, double[] window) {
		
		int maxCount = StdStats.max(frequency);

		StdDraw.setCanvasSize(960, 540);
		StdDraw.setXscale(l-1, r+1);
		StdDraw.setYscale(0, maxCount+2);

		for (int i = 0; i < window.length-1; i++) {

			double x = (double) (window[i+1] + window[i])/2;
			double y = (double) frequency[i]/2;
			double halfWidth = (double) (window[i+1] - window[i])/2;
			double halfHeight = (double) frequency[i]/2;
			//StdOut.println(x + "," + y + "," + halfWidth + "," + halfHeight);
			StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
		}
	}

}