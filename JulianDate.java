/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Corran Musk
 * @version 0.1
 */
import java.util.Date;
import java.util.GregorianCalendar;

public class JulianDate {
    
    int DAY_OF_MONTH;
    int MONTH;
    int YEAR;
    
    // Constructors
    JulianDate(){
        /**
         * Default constructor - does nothing! for now anyway
         */
    }
    
    public void JulianDate(GregorianCalendar gDate){
        /**
         * Constructor using a GregorianCalendar object. Converts to
         * JulianDate object
         * 
         * @param gDate - the date to be converted as GregorianDate object
         * 
         */
        JulianDate tmp=fromGregorian(gDate);
        this.DAY_OF_MONTH=tmp.DAY_OF_MONTH;
        this.MONTH=tmp.MONTH;
        this.YEAR=tmp.YEAR;

    }
    
    // The functions
    public static JulianDate fromGregorian (GregorianCalendar gDate){
       
        /**
         * Converts a GregorianCalendar object to a JulianDate
         * 
         * @param gDate - A GregorianCalendar object
         * @return the converted data as a JulianDate object
         */
         JulianDate tmp=new JulianDate();

        int x=gDate.get(GregorianCalendar.YEAR);
        int m=gDate.get(GregorianCalendar.MONTH)+1; // month starts at 0
        int day=gDate.get(GregorianCalendar.DAY_OF_MONTH);
       
        int alpha= (int) x/100;
        int beta= 2 - alpha + ((int) alpha/4);
        int b= ((int) (365.25 * x)) + ((int) (30.6001 * (m+1))) + day + 1722519 + beta;
        int c = (int) ((b-122.1)/365.25);
        int d = (int) (365.25 * c);
        int e = (int) ((b-d)/30.6001);
       
        tmp.DAY_OF_MONTH=b-d - ((int)(30.6001 * e));
        tmp.MONTH=e-1;
        if (e>13) tmp.MONTH-=12;
        tmp.YEAR=c-4715;
        if (tmp.MONTH>2) tmp.YEAR--;
       
        return tmp;
       
    }
    
    public static GregorianCalendar toGregorian (JulianDate jDate){
        
        GregorianCalendar gDate=new GregorianCalendar();
        
        
        return gDate;
    }

    public static String displayDate (JulianDate jDate){
    
        /**
         * Returns a string for display purposes - may add additional formatting later
         * 
         * @return A String containing the formatted date for Display
        */
        
        String tmp="";
       
        tmp+=jDate.DAY_OF_MONTH;
        tmp+="/";
        tmp+=jDate.MONTH;
        tmp+="/";
        tmp+=jDate.YEAR;
        
        return tmp;
        
    }
    
    public static void main(String[] args){
        
        // for testing purposes!
        
        JulianDate tmp=new JulianDate();
        GregorianCalendar test=new GregorianCalendar();
        Date testTime = new Date();
        test.setTime(testTime);
        tmp=fromGregorian(test);
        
        System.out.println(displayDate(tmp));
    }
}