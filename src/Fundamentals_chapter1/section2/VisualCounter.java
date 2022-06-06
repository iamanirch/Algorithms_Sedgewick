package Fundamentals_chapter1.section2;

import edu.princeton.cs.algs4.*;

/*
 * Ex 1.2.10 
 * Develop a class VisualCounter that allows both increment and decrement
 * operations. Take two arguments N and max in the constructor, where N specifies the
 * maximum number of operations and max specifies the maximum absolute value for
 * the counter. As a side effect, create a plot showing the value of the counter each time its tally changes
 */
public class VisualCounter {

    private int countOps, countVal, maxOps, maxVal;

    public VisualCounter(int n, int max){
        this.maxOps = n;
        this.maxVal = Math.abs(max);

        StdDraw.setCanvasSize(800, 450);
        StdDraw.setPenRadius(.015);
		StdDraw.setXscale(0, n+1);
        StdDraw.setYscale(-max-3, max+3);
    }
    
    private void increment() {
        if(countOps < maxOps && countVal < maxVal){
            countOps++;
            countVal++;

            plotter();
        }
    }

    private void decrement(){
        if(countOps < maxOps && (Math.abs(countVal) < maxVal)){
            countOps++;
            countVal--;

            plotter();
        }
    }

    private void plotter() 
    { StdDraw.point(countOps, countVal);}

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);

        VisualCounter vc = new VisualCounter(N, max);

        for (int i = 0; i < trials; i++) {
            if(StdRandom.bernoulli(0.25)) vc.increment();
            else vc.decrement();
        }
    }
}
