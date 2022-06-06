package Fundamentals_chapter1.section2;

import edu.princeton.cs.algs4.*;

/*
 * File input. 
 * Develop a possible implementation of the static readInts() method from In 
 * (which we use for various test clients, such as binary search on page 47) 
 * that is based on the split() method in String
 */
public class Ex15 {
    public static int[] readInts(String name)
    {
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        
        for (int i = 0; i < words.length; i++)
            ints[i] = Integer.parseInt(words[i]);
        
        return ints;
    }

    public static void main(String[] args) {
        String fileName = args[0];

        int[] ints = readInts(fileName);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
