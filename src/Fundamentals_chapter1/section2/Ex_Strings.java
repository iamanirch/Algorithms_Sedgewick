package Fundamentals_chapter1.section2;


/*
 * Solutions for Ex 1.2.4 to 1.2.7 on Strings as objects
 */
public class Ex_Strings {
    
    public static void main(String[] args) {
        
        // Ex 1.2.4
        String s1 = "hello";
        String s2 = s1;
        s1 = "world";

        System.out.println(s1); // hello
        System.out.println(s2); // world

        // Ex 1.2.5
        String s = "Hello World";
        s.toUpperCase(); // HELLO WORLD
        s.substring(6, 11); 
        System.out.println(s); // Hello World
        
        // Ex 1.2.6
        System.out.println("Circular T/F: "+circularity(args[0], args[1]));

        // Ex 1.2.7
        System.out.println(mystery(args[0]));
    }

    public static boolean circularity(String s1, String s2) {

        if(s1.length() == s2.length()){
            for (int i = 0; i < s1.length(); i++) {
                s1 = s1.substring(1) + s1.substring(0,1);
                if(s2.equals(s1)) return true;
            }
        }

        // alternate version: return s1.length() == s2.length() && (s1+s1).contains(s2);
        return false;
    }

    public static String mystery(String s)
    {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }
}
