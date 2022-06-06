package Fundamentals_chapter1.section2;

import edu.princeton.cs.algs4.*;

/*
 * Write a Point2D client that takes an integer value N from the command line,
 * generates N random points in the unit square, and computes the distance separating
 * the closest pair of points
 */
public class Ex1 {
   
    public static void main(String[] args) {
        
        int N = Integer.parseInt(args[0]);
        
        Point2D[] points = new Point2D[N];
        mapPoints(points);
        
        StdOut.printf("Distance between closest pair: %5.3f", shortestDistance(points));
    }
    
    public static void mapPoints(Point2D[] points) {
        
        StdDraw.setCanvasSize(1024, 512);
		StdDraw.setPenRadius(.015);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);

        double x, y;

        for (int i = 0; i < points.length; i++) 
        {   // generate N point objects
            x = StdRandom.uniform();
            y = StdRandom.uniform();
            
            points[i] = new Point2D(x, y);
            points[i].draw();
        }
    }

    public static double shortestDistance(Point2D[] points) {
        
        double shortestDist = Double.MAX_VALUE;
		double currentDist;

		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				currentDist = points[i].distanceTo(points[j]);

				if (currentDist < shortestDist) {
					shortestDist = currentDist;
				}
			}
		}
		return shortestDist;
    }
}
