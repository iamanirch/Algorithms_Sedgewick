package Fundamentals_chapter1.section2;

public class RationalRobust {
    private long numerator, denominator;
    private RationalRobust result;
    private final static String ASSERT_AVOIDING_OVERFLOW_MESSAGE = "Operation would cause overflow";

    public RationalRobust(int num, int denum){
        if (denum == 0) throw new RuntimeException("Denominator cannot be 0");

        if(gcd(num, denum) == 1){
            this.numerator = num;
            this.denominator = denum;
        }
        else throw new RuntimeException("Common factors between numerator and denominator");
    }
    public int numerator() 
    { return (int) numerator;}

    public int denominator() 
    { return (int) denominator; }

    public RationalRobust plus(RationalRobust b){
        long num, denum;
        num = this.numerator * b.denominator + this.denominator * b.numerator;
        denum = this.denominator * b.denominator;
        assertions((int) num, (int) denum);
        result = new RationalRobust((int) num, (int) denum);
        return result;
    }
    public RationalRobust minus(RationalRobust b) {
        long num, denum;
        num = this.numerator * b.denominator - this.denominator * b.numerator;
        denum = this.denominator * b.denominator;
        assertions((int) num, (int) denum);
        result = new RationalRobust((int) num, (int) denum);
        return result;
    }
    public RationalRobust times(RationalRobust b){
        long num, denum;
        num = this.numerator * b.numerator;
        denum = this.denominator * b.denominator;
        assertions((int) num, (int) denum);
        result = new RationalRobust((int) num, (int) denum);
        return result;
    }
    public RationalRobust divides(RationalRobust b){
        long num, denum;
        num = this.numerator * b.denominator;
        denum = this.denominator * b.numerator;
        assertions((int) num, (int) denum);
        result = new RationalRobust((int) num, (int) denum);
        return result;
    } 
    public boolean equals(Object x){
        if(this == x) return true;
        if (x == null) return false;
        RationalRobust that = (RationalRobust) x;
        if(this.getClass() != that.getClass()) return false;
        if(this.numerator == that.numerator && this.denominator == that.denominator) return true;
        return false;
    }
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }
    private int gcd(int p, int q){
    if (q == 0) return p;
    int r = p % q;
    return gcd(q, r);
    }
    private void assertions(int n1, int n2){
        assert n1 <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
        assert n2 <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
    }

    public static void main(String[] args) {
        RationalRobust r1 = new RationalRobust(5, 3);
        RationalRobust r2 = new RationalRobust(7, 2);
        
        if(!r1.equals(r2)) System.out.println(r1 + " and " + r2 +" are different numbers");
        else System.out.println(r1 + " and " + r2 +" are same numbers");
        
        System.out.println(r1 + " + " + r2 + " = " + r1.plus(r2) + "\n");
        System.out.println(r1 + " - " + r2 + " = " + r1.minus(r2) + "\n");
        System.out.println(r1 + " / " + r2 + " = " + r1.divides(r2) + "\n");
        System.out.println(r1 + " * " + r2 + " = " + r1.times(r2) + "\n");    
    }
}
