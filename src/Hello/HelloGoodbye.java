package Hello;

import edu.princeton.cs.algs4.*;

/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class HelloGoodbye {
    public static void main(String[] args) {
        String firstName, secondName;

        StdOut.println("Enter a name:");
        firstName = StdIn.readLine();
        StdOut.println("Enter a name:");
        secondName = StdIn.readLine();

        StdOut.println("Hello "+firstName+" and "+secondName+".");
        StdOut.println("Goodbye "+secondName+" and "+firstName+".");
    }
}
