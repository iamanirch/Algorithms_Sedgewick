package Fundamentals_chapter1.section2;

public class Ex19_Parsing2 {
    
    private String client;
    private Ex19_Parsing date;
    private double amount;
    private String[] s;

    public Ex19_Parsing2(String transaction){
        s = transaction.split(" ");
        client = s[0];
        date = new Ex19_Parsing(s[1]);
        amount = Double.parseDouble(s[2]);
    }

    public String toString(){
        return "Client: " + client + "\nTransaction Date: " + date + "\nTransaction Value: " + amount;
    }

    public static void main(String[] args) {
        Ex19_Parsing2 order = new Ex19_Parsing2("Turing 5/22/1939 11.99");

        System.out.println(order);
    }
}
