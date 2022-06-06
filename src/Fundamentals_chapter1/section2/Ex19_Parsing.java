package Fundamentals_chapter1.section2;

/*
 * Develop the parse constructors for your Date and Transaction implementations of Exercise 1.2.13 
 * that take a single String argument to specify the
 * initialization values, using the formats given in the table below
 */
public class Ex19_Parsing {
    
    private int day, month, year;
    private String[] s;

    public Ex19_Parsing(String date){
        s = date.split("/");
        month = Integer.parseInt(s[0]);
        day = Integer.parseInt(s[1]);
        year = Integer.parseInt(s[2]);
    }

    public String toString(){
        return month + "/" + day + "/" + year;
    }
    public static void main(String[] args) {
        Ex19_Parsing date = new Ex19_Parsing("5/22/1939");

        System.out.println(date);
    }
}
