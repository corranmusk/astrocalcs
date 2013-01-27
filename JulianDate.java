/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Corran Musk 2013
 */
import java.util.GregorianCalendar;

public class JulianDate {
    
    int DAY_OF_MONTH;
    int MONTH;
    int YEAR;
    
    // Constructors
    public JulianDate(){
        // Take current date and convert
    }
    
    public JulianDate(GregorianCalendar gDate){
        // Setup using a GregorianDate
       JulianDate tmp=fromGregorian(gDate);
       this.DAY_OF_MONTH=tmp.DAY_OF_MONTH;
       this.MONTH=tmp.MONTH;
       this.YEAR=tmp.YEAR;
       
       

    }
    
    // The functions
    public static JulianDate fromGregorian (GregorianCalendar gDate){
        
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
}
