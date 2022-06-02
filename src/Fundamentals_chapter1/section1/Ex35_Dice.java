/* The value dist[i] is the probability that the dice sum to k. 
 * Run experiments to validate this calculation simulating N dice throws, 
 * keeping track of the frequencies of occurrence of each value when you compute 
 * the sum of two random integers between 1 and 6. 
 * How large does N have to be before your empirical results match the exact results 
 * to three decimal places?
 * 
 * Answer = from experiments; 750000 N required to match exact results by 3 decimals.
 */
package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;


public class Ex35_Dice {

    static int SIDES = 6;

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        
        double[] Real = diceSim();
        double[] Experiment = diceExperiment(N);
        double[] Gap = Ex33_Matrix.subtract(Real, Experiment);

        StdOut.println("Actual");
        Printing_Arrays.printArray(Real);
        StdOut.println("Experiment");
        Printing_Arrays.printArray(Experiment);
        
        StdOut.println("Gap = Real-Experiment");
        Printing_Arrays.printArray(Gap);
    }

    public static double[] diceSim() {
        
        double[] distSim = new double[2*SIDES+1];

        // count frequency
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                distSim[i+j] += 1.0;

        // convert to probability
        for (int k = 2; k <= 2*SIDES; k++)
            distSim[k] /= 36.0;
        
        return distSim;
    }

    private static double[] diceExperiment(int N) {
		
		double[] distExperiment = new double[2 * SIDES + 1];
		int diceOne = 0;
		int diceTwo = 0;
		int sum = 0;

		// count frequency
		for (int i = 0; i < N; i++) {
			diceOne = StdRandom.uniform(1, 7);
			diceTwo = StdRandom.uniform(1, 7);
			
			sum = diceOne + diceTwo;
			
			distExperiment[sum]++;
		}
		
        // convert to probability
		for (int k = 2; k <= 2 * SIDES; k++) {
			distExperiment[k] /= N;
		}
		return distExperiment;
	}
}
