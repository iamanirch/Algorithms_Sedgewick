package Fundamentals_chapter1.section2;

/*
 * Using our implementation of equals() in Date as a model (page 103), develop
 * implementations of equals() for Transaction.
 */
public class Ex14_Transactionv2 {
    
    private String who;
    private Date when;
    private double amount;

    public Ex14_Transactionv2(String client, Date date, double transactionValue){
        this.who = client;
        this.when = date;
        this.amount = transactionValue;
    }

    public String who() 
    {return who;}
    
    public Date when() 
    {return when;}
    
    public double amount() 
    {return amount;}

    public String toString()
    { return "Client: "+ who() + "\tDate: " + when() + "\tValue: "+ amount();}

    public boolean equals(Object x){
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Ex14_Transactionv2 that = (Ex14_Transactionv2) x;
        if (!this.who.equals(that.who)) return false;
        else if (!this.when.equals(that.when)) return false;
        else if (this.amount != that.amount) return false;
        return true;
    }
    public static void main(String[] args) {
        
        Date order1Date = new Date(6, 5, 2021);
        Date order2Date = new Date(6, 5, 2022);

        Ex14_Transactionv2 order1 = new Ex14_Transactionv2("Manish", order1Date, 25000.0);
        Ex14_Transactionv2 order2 = new Ex14_Transactionv2("Chandni", order1Date, 35000.0);
        Ex14_Transactionv2 order3 = new Ex14_Transactionv2("Manish", order2Date, 25000.0);
        Ex14_Transactionv2 order4 = new Ex14_Transactionv2("Manish", order1Date, 25000.0);
        
        System.out.println("Order 1:\n"+ order1);
        if(!order1.equals(order2)) System.out.println("Order 2:\n"+ order2);
        else System.out.println("Order 2 is same as Order 1");
        if(!order1.equals(order3) && !order2.equals(order3)) System.out.println("Order 3:\n"+ order3);
        else System.out.println("Order 3 is same as Order 1 or 2");
        if(!order1.equals(order4) && !order2.equals(order4) && !order3.equals(order4)) System.out.println(order4);
        else System.out.println("Order 4 is same as Order 1 or 2 or 3");
    }
}
