package Fundamentals_chapter1.section2;

/*
 * Rational numbers. Implement an immutable data type Rational for rational
 * numbers that supports addition, subtraction, multiplication, and division.
 */
public class Rational {
    
    private long numerator, denominator;
    private Rational result;

    public Rational(long num, long denum){
        if (denum == 0) throw new RuntimeException("Denominator cannot be 0");

        if(gcd(num, denum) == 1){
            this.numerator = num;
            this.denominator = denum;
        }
        else throw new RuntimeException("Common factors between numerator and denominator");
    }
    
    public Rational plus(Rational b){
        long num, denum;
        num = this.numerator * b.denominator + this.denominator * b.numerator;
        denum = this.denominator * b.denominator;
        result = new Rational(num, denum);
        return result;
    }
    public Rational minus(Rational b) {
        result.numerator = this.numerator * b.denominator - this.denominator * b.numerator;
        result.denominator = this.denominator * b.denominator;
        return result;
    }
    public Rational times(Rational b){
        result.numerator = this.numerator * b.numerator;
        result.denominator = this.denominator * b.denominator;
        return result;
    }
    public Rational divides(Rational b){
        result.numerator = this.numerator * b.denominator;
        result.denominator = this.denominator * b.numerator;
        return result;
    } 
    public boolean equals(Object x){
        if(this == x) return true;
        if (x == null) return false;
        Rational that = (Rational) x;
        if(this.getClass() != that.getClass()) return false;
        if(this.numerator == that.numerator && this.denominator == that.denominator) return true;
        return false;
    }
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }
    private long gcd(long p, long q){
    if (q == 0) return p;
    long r = p % q;
    return gcd(q, r);
    }

    public static void main(String[] args) {
        Rational r1 = new Rational(5, 3);
        Rational r2 = new Rational(7, 2);
        
        if(!r1.equals(r2)) System.out.println(r1 + " and " + r2 +" are different numbers");
        else System.out.println(r1 + " and " + r2 +" are same numbers");
        
        System.out.println(r1 + " + " + r2 + " = " + r1.plus(r2) + "\n");
        System.out.println(r1 + " - " + r2 + " = " + r1.minus(r2) + "\n");
        System.out.println(r1 + " / " + r2 + " = " + r1.divides(r2) + "\n");
        System.out.println(r1 + " * " + r2 + " = " + r1.times(r2) + "\n");    
    }
}
