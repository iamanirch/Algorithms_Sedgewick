package Fundamentals_chapter1.section1;

public class Ex19_Fibonacci {
    public static long F(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }
    public static void main(String[] args)
    {
        for (int N = 0; N < 10; N++)
            System.out.println(N + " " + F(N));
    }
}
