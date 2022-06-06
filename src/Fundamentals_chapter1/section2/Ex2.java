package Fundamentals_chapter1.section2;

import edu.princeton.cs.algs4.*;

/*
 * Write an Interval1D client that takes an int value N as command-line argument, 
 * reads N intervals (each defined by a pair of double values) from standard input,
 * and prints all pairs that intersect.
 */
public class Ex2 {
    
    public static void main(String[] args) {
        
        int N = Integer.parseInt(args[0]);
        double lo, hi, temp;

        Interval1D[] intervals = new Interval1D[N]; // Interval1D(double lo, double hi)

        for (int i = 0; i < N; i++) {
            
            lo = StdRandom.uniform(0.0, 10.0);
            hi = StdRandom.uniform(0.0, 10.0);
            
            if(lo > hi){
                temp = lo;
                lo = hi;
                hi = temp;
            }

            intervals[i] = new Interval1D(lo, hi);
            //StdOut.println(lo+ " "+hi);
        }
        StdOut.println("Intersecting Intervals: ");
        pairIntersection(intervals);
        
    }

    public static void pairIntersection(Interval1D[] intervals) {

        for (int i = 0; i < intervals.length-1; i++) {
            for (int j = i+1; j < intervals.length; j++) {
                if(intervals[i].intersects(intervals[j]))   
                    StdOut.printf("Interval1: [%3.4f,%3.4f] , Interval2: [%3.4f,%3.4f] %n", 
                                            intervals[i].min(), intervals[i].max(), 
                                            intervals[j].min(), intervals[j].max());
            }
        }
    }
}
