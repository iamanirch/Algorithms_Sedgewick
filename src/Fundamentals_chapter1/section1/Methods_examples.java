package Fundamentals_chapter1.section1;

import java.io.IOException;
import edu.princeton.cs.algs4.*;

public class Methods_examples {

    // square root of a number using Newton's method
    public static double sqrt_Newton(double c) {
        if (c <0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err*t)
            t =(c/t + t)/ 2.0;
        return t;
    }

    // absolute of a int number
    public static int abs(int x) {
        if(x<0) return -x;
        return x;
    }

    // absolute of a double number
    public static double abs(double x) {
        if(x<0) return -x;
        return x;
    }

    // primality test
    public static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i*i <= N; i++)
           if (N % i == 0) return false;
        return true;
    }

    // hypoteneuse 
    public static double hypoteneuse(double a, double b) {
        return Math.sqrt(a*a + b*b);
    }

    // recursive binary search
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length- 1);    
    }
    public static int rank(int key, int[] a, int lo, int hi) {
        if(lo > hi) return -1;
        int mid = lo + (hi-lo)/2;
        if(key < a[mid]) return rank(key, a, lo, mid-1);
        else if(key < a[mid]) return rank(key, a, mid+1, hi);
        else return mid;
        
    }

    // random double value in [a,b)
    public static double uniform(double a, double b) {
        return a + StdRandom.uniform()* (b-a);    
    }

    // random integer value in [0,N)
    public static int uniform(int N) {
        return (int) (StdRandom.uniform()* N);    
    }

    // random integer value from discrete distribuition with probability 
    public static int discrete(double[] a) {
        double r    = StdRandom.uniform();
        double sum  = 0.0;
        for (int i = 0; i < a.length; i++) 
        {
            sum += a[i];
            if (sum >= r) return i;
        }
        return -1;
    }

    /**
     * randomly shuffle the elements in an array of double values
     */
    public static void shuffle(double[] a) {
        
        int N= a.length;
        for (int i = 0; i < N; i++) {
            int r= i + StdRandom.uniform(N-i);
            double temp = a[i];
            a[i]= r;
            a[r]= temp;
        }
    }

    /**
     * randomly shuffle the elements in an array of integer values
     */
    public static void shuffle(int[] a) {
        
        int N= a.length;
        for (int i = 0; i < N; i++) {
            int r= i + StdRandom.uniform(N-i);
            int temp = a[i];
            a[i]= r;
            a[r]= temp;
        }
    }

    public static void main(String[] args) throws IOException {
        double[] arr= {1,2,3,4,5,6,7,8};
        StdOut.println("Original: ");
        for (double d : arr) {
            StdOut.println(d);    
        }

        shuffle(arr);
        StdOut.println("Shuffled: ");
        for (int i = 0; i < arr.length; i++) {
            StdOut.println(arr[i]);
        }
    }
}
