package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

/* Binomial distribution. Estimate the number of recursive calls that would be
 * used by the code to compute binomial(100, 50). 
 * Develop a better implementation that is based on saving computed values in an array
 */

public class Ex27 {

    static int count= 0;
    public static void main(String[] args) {
        int N= Integer.parseInt(args[0]);
        int k= Integer.parseInt(args[1]);

        //StdOut.println(binomial(N, k, 0.25)); // assume probability of 0.25
        //StdOut.printf("Final Count: %d",count);
        binomialv2Start(N, k, 0.25);

    }

    public static double binomial(int N, int k, double p)
    {   
        count++;
        StdOut.println(count);
        if ((N == 0) && (k == 0)) return 1.0;
        else if ((N < 0) || (k < 0)) return 0.0;
        else return (1-p)*binomial(N-1, k,p) + p*binomial(N-1, k-1,p);
    }

    // Better version
    public static void binomialv2Start(int N, int k, double p) {
        double[][] arr = new double[N+1][k+1];

        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < k+1; j++) {
                arr[i][j] = -1;
            }    
        }

        StdOut.println(binomialv2(arr ,N, k, p));
        StdOut.printf("Final Count: %d",count);
    }

    public static double binomialv2(double[][] arr, int N, int k, double p) {
        count++;
        
        if ((N == 0) && (k == 0)) return 1.0;
        else if ((N < 0) || (k < 0)) return 0.0;
        
        if(arr[N][k] == -1)
            arr[N][k]= (1-p)*binomialv2(arr, N-1, k,p) + p*binomialv2(arr, N-1, k-1,p);

        return arr[N][k];
    }
}
