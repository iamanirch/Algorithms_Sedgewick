package Fundamentals_chapter1.section2;

import edu.princeton.cs.algs4.*;

/*
 * Write an Interval2D client that takes command-line arguments N, min, and max
 * and generates N random 2D intervals whose width and height are uniformly distributed
 * between min and max in the unit square. Draw them on StdDraw and print the number
 * of pairs of intervals that intersect and the number of intervals that are contained in one another.
 */
public class Ex3 {
    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
		double max = Double.parseDouble(args[2]);

        Interval2D[] intervals = new Interval2D[n];
        Interval1D[][] interval1ds = new Interval1D[n][2];
        Interval1D x, y;
        double lo, hi, temp;
    
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        for (int i = 0; i < n; i++) {
            
            // width and height uniformly distributed between min, max
            lo = StdRandom.uniform(min, max);
            hi = StdRandom.uniform(min, max);

            if(lo > hi){
                temp = lo;
                lo = hi;
                hi = temp;
            }

            x = new Interval1D(lo, hi);
            y = new Interval1D(lo, hi);
            intervals[i] = new Interval2D(x, y);
            interval1ds[i][0] = x;
            interval1ds[i][1] = y;

            intervals[i].draw();
        }

        int[] result = IntersectionandContained(intervals, interval1ds);
        StdOut.println("Intersecting Intervals: "+ result[0]);
        StdOut.println("Intervals contained in one another: " + result[1]); 
        
    }
    
    public static int[] IntersectionandContained(Interval2D[] inters, Interval1D[][] inter1ds) {

        boolean i_in_j = false, j_in_i = false;
        int[] results = new int[2];
        int intersections = 0, contains = 0;

        for (int i = 0; i < inters.length-1; i++) {
            for (int j = i+1; j < inters.length; j++) {
                
                // intersection check
                if(inters[i].intersects(inters[j])) intersections++;

                // contains check
                i_in_j = inter1ds[i][0].min() > inter1ds[j][0].min() && 
                         inter1ds[i][0].max() < inter1ds[j][0].max() && 
                         inter1ds[i][1].min() > inter1ds[j][1].min() && 
                         inter1ds[i][1].max() < inter1ds[j][1].max();
                
                j_in_i = inter1ds[j][0].min() > inter1ds[i][0].min() && 
                         inter1ds[j][0].max() < inter1ds[i][0].max() && 
                         inter1ds[j][1].min() > inter1ds[i][1].min() && 
                         inter1ds[j][1].max() < inter1ds[i][1].max();
                
                if(i_in_j || j_in_i) contains++; // contained count
            }
        }
        results[0] = intersections;
        results[1] = contains;
        return results;
    }

    
}
