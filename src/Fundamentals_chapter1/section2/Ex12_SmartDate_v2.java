package Fundamentals_chapter1.section2;

import java.time.*;

public class Ex12_SmartDate_v2 {
    
    private int month, day, year;
    
    public Ex12_SmartDate_v2(int m, int d, int y) { 
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

    private String dayOfTheWeek(){
        String currentDay = "";
        
        LocalDate localDate = LocalDate.of(year, month, day);  
        DayOfWeek dayOfWeek = DayOfWeek.from(localDate);  
        currentDay = dayOfWeek.name();
        
        return currentDay;
    }
    public static void main(String[] args) {

        Ex12_SmartDate_v2 d1 = new Ex12_SmartDate_v2(8, 27, 1992);
        System.out.println("Manish\t"+ d1 + "\tDay: "+ d1.dayOfTheWeek());
        
        Ex12_SmartDate_v2 d3 = new Ex12_SmartDate_v2(10, 22, 1960);
        System.out.println("Dad\t" + d3 + "\tDay: "+ d3.dayOfTheWeek());
        
        Ex12_SmartDate_v2 d4 = new Ex12_SmartDate_v2(4, 25, 1962);
        System.out.println("Mom\t" + d4 + "\tDay: "+ d4.dayOfTheWeek());
        
        Ex12_SmartDate_v2 d5 = new Ex12_SmartDate_v2(2, 23, 1991);
        System.out.println("Akka\t" + d5 + "\tDay: "+ d5.dayOfTheWeek());

        Ex12_SmartDate_v2 d2 = new Ex12_SmartDate_v2(10, 3, 1990);
        System.out.println("Thani\t" + d2 + "\tDay: "+ d2.dayOfTheWeek());

        Ex12_SmartDate_v2 d6 = new Ex12_SmartDate_v2(11, 22, 1962);
        System.out.println("Manickam\t" + d6 + "\tDay: "+ d6.dayOfTheWeek());
        
        Ex12_SmartDate_v2 d7 = new Ex12_SmartDate_v2(10, 18, 1972);
        System.out.println("Meenakshi\t" + d7 + "\tDay: "+ d7.dayOfTheWeek());
    }
}
