package Fundamentals_chapter1.section1;

import java.io.IOException;

import edu.princeton.cs.algs4.*;

public class Ex3 {

	public static void main(String[] args) throws IOException
    {
        // Write  a  program  that  takes  three  integer  command-line  arguments  and  prints equal if all three are equal, and not equal otherwise
        
        int[] arr = new int[10];
		
        for(int i=0; i<3; i+=1){
            
            arr[i]=  StdIn.readInt();
        }
        if(arr[0] == arr[1] && arr[1] == arr[2]) StdOut.println("Equal");
        else StdOut.println("Not Equal");

    }
}
