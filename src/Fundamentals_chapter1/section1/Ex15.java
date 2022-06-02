package Fundamentals_chapter1.section1;

import edu.princeton.cs.algs4.*;

// Write a static method histogram() that takes an array a[] of int values 
// and an integer M as arguments and returns an array of length M 
// whose ith entry is the number of times the integer i appeared in the 
// argument array. If the values in a[] are all between 0 and M–1, 
// the sum of the values in the returned array should be equal to a.length.
public class Ex15 {


    public static int[] histogram(int a[], int M) {
        int temp[] = new int[M];
        for (int i = 0; i < M; i++) {
            temp[i] = counter(a, i);
        }
        return temp;
    }

    public static int counter(int a[], int n) {
        int count= 0;
        for (int i : a){
            if(i==n) count++;
        } 
        return count;
    }

    public static void main(String[] args) {
        StdOut.print("Enter size of array: ");
        int N= StdIn.readInt();
        int[] a = new int[N];

        StdOut.print("Enter size of frequency array: ");
        int M= StdIn.readInt();
        int[] freq = new int[M];  

        for (int i = 0; i < N; i++) 
            a[i] = StdRandom.uniform(0, M);
        StdOut.printf("%nOriginal array: ");
        for (int i : a) StdOut.print(i+" ");

        freq = histogram(a, M);
        StdOut.printf("%nFrequency array: ");
        for (int j : freq) StdOut.print(j+" ");
    }
}
