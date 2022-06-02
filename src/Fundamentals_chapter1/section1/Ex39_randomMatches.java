package Fundamentals_chapter1.section1;

import java.util.*;
import edu.princeton.cs.algs4.*;

/*
 * Random matches. Write a BinarySearch client that takes an int value T as
 * command-line argument and runs T trials of the following experiment for N = 1000, 10000,
 * 100000, and 1000000: generate two arrays of N randomly generated positive six-digit int values,
 * and find the number of values that appear in both arrays. Print a table giving the average
 * value of this quantity over the T trials for each value of N
 */
public class Ex39_randomMatches {

	public static void main(String[] args) {
		int t = Integer.parseInt(args[0]);

		int n1 = 1000;
		int n2 = 10000;
		int n3 = 100000;
		int n4 = 1000000;
		
		int[] results = new int[4];
		
		for (int i = 0; i < t; i++) {
			results[0] += experiment(n1);
			results[1] += experiment(n2);
			results[2] += experiment(n3);
			results[3] += experiment(n4);
		}

		StdOut.printf("%10s %37s\n", "Array size", "AVG number of values in both arrays");
		StdOut.printf("10^3 %17.2f \n", ((double) results[0]) / t);
		StdOut.printf("10^4 %17.2f \n", ((double) results[1]) / t);
		StdOut.printf("10^5 %17.2f \n", ((double) results[2]) / t);
		StdOut.printf("10^6 %17.2f \n", ((double) results[3]) / t);
	}
	
	private static int experiment(int arraySize) {
		int[] array1 = new int[arraySize];
		int[] array2 = new int[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			array1[i] = StdRandom.uniform(100000, 1000000); // 6 digit random value
			array2[i] = StdRandom.uniform(100000, 1000000);
		}
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int numbersInBothArrays = 0;
		
		for (int i = 0; i < arraySize; i++) {
			if (i > 0 && array1[i] == array1[i - 1]) {
				continue;
			}

			if (binarySearch(array1[i], array2, 0, array2.length - 1)) {
				numbersInBothArrays++;
			}
		}
		
		return numbersInBothArrays;
	}
	
	private static boolean binarySearch(int key, int[] arr, int lo, int hi) {
		if (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if (key < arr[mid]) {
				return binarySearch(key, arr, lo, mid - 1);
			} else if (key > arr[mid]) {
				return binarySearch(key, arr, mid + 1, hi);
			} else {
				return true;
			}
		}
		return false;
	}

}
