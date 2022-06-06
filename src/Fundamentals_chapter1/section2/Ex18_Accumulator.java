package Fundamentals_chapter1.section2;

import edu.princeton.cs.algs4.*;

/*
 * Variance for accumulator. Validate that the following code, which adds the
 * methods var() and stddev() to Accumulator, computes both the mean and variance
 * of the numbers presented as arguments to addDataValue()
 */
public class Ex18_Accumulator {
    private double m;
    private double s;
    private int N;

    public void addDataValue(double x){
        N++;
        s = s + 1.0 * (N-1) / N * (x - m) * (x - m);
        m = m + (x - m) / N;
    }

    public double mean()
    { return m; }
    
    public double var()
    { return s/(N - 1); }
    
    public double stddev()
    { return Math.sqrt(this.var()); }

    public static void main(String[] args) {
        
        int[] nums = new In(args[0]).readAllInts();
        Ex18_Accumulator df = new Ex18_Accumulator();

        for (int i = 0; i < nums.length; i++) { df.addDataValue(nums[i]); }

        System.out.println("Mean: " + df.mean());
        System.out.println("Variance: " + df.var());
        System.out.println("Standard Deviation: " + df.stddev());
    }
}
