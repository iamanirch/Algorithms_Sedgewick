package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

/**
 * Generate random sequence of digits using command line input
 */
public class RandomSequence
{
   public static void main(String[] args)
   {  
      // Print N random values in (lo, hi).
      int N = Integer.parseInt(args[0]);
      double lo = Double.parseDouble(args[1]);
      double hi = Double.parseDouble(args[2]);
      for (int i = 0; i < N; i++)
      {
         double x = StdRandom.uniform(lo, hi);
         StdOut.printf("%.2f\n", x);
      }
   } 
}