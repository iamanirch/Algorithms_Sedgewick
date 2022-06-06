package Fundamentals_chapter1.section2;

/*
 * Using our implementation of Date as a model (page 91), 
 * develop an implementation of Transaction
 */
public class Ex13_Transaction {
    
    private String who;
    private Date when;
    private double amount;

    public Ex13_Transaction(String client, Date date, double transactionValue){
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
    { return "Client: "+ who() + "\nDate: " + when() + "\nValue: "+ amount();}


    public static void main(String[] args) {
        
        Date order1Date = new Date(6, 5, 2021);
        Ex13_Transaction order1 = new Ex13_Transaction("Manish", order1Date, 25000.0);

        System.out.println(order1);
    }
}
