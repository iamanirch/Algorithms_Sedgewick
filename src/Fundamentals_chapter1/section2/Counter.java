package Fundamentals_chapter1.section2;

import edu.princeton.cs.algs4.*;

/*
 * Counter client 
 */
public class Counter {

    //instance variables
    private final String name;
    private int count;
    
    // constructor
    public Counter(String id)
    { name = id; }
    
    // instance methods
    public void increment()
    { count++; }
    
    public int tally()
    { return count; }

    public String toString()
    { return count + " " + name; }

    // test client
    public static void main(String[] args)
    {   // create and initialize objects
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        heads.increment();
        heads.increment();
        tails.increment();
        
        StdOut.println(heads + " " + tails);
        StdOut.println(heads.tally() + tails.tally() );
    }
}
