package Fundamentals_chapter1.section2;


public class Ex11_SmartDate {
    
    private int month, day, year;

    public Ex11_SmartDate(int m, int d, int y) { 
        if(!dateValidity(m,d,y)) throw new RuntimeException("Date is invalid");

        this.month = m;
        this.day = d;
        this.year = y;
        
    }

    public int month() 
    { return month; }
	
	public int day() 
    { return day; }
	
	public int year() 
    { return year; }
	
	public String toString() 
    { return month() + "/" + day() + "/" + year(); }

    private boolean dateValidity(int month, int day, int year) {
        
        //int[] days31 = {1,3,5,7,8,10,12};
        int[] days30 = {4,6,9,11};

        if( month > 12 || month < 1 ||
            day > 31 || day < 1 ||
            year < 1 ||
            year%4 != 0 && month == 2 && day > 28 || 
            year%4 == 0 && month == 2 && day > 29) 
            return false;
        
        for (int i : days30) {
            if(month == i && day > 30) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Ex11_SmartDate d1 = new Ex11_SmartDate(8, 27, 1992);
        System.out.println(d1);

        Ex11_SmartDate d2 = new Ex11_SmartDate(10, 3, 1990);
        System.out.println(d2);
        
        Ex11_SmartDate d3 = new Ex11_SmartDate(13, 3, 1990);
        System.out.println(d3);
        
    }

}
