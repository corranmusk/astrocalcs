/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Corran Musk
 */
import java.util.GregorianCalendar;

public class MoslemCalendar {
    
    // Meaningless result pre 622 July 16
    
    static String[] monthNames = {"Muharram","Safar","Rabi\'al-Awwal","Rab\'ath-Thani",
                            "Jumada l-Ula","Jumada t-Tania","Rajab","Sha\'ban",
                            "Ramadan","Shawwal","Dhu l-Qa\'da","Dhu l-Hijja" };
    public int MONTH;
    public int MONTH_NAME;
    public int YEAR;
    public int DAY_OF_MONTH;
    
    public GregorianCalendar gdate;
    
    //Constructors
    public static void MoslemCalendar() {
    }
    
    public static MoslemCalendar fromGregorian (GregorianCalendar gDate){
        
        MoslemCalendar tmp = new MoslemCalendar();
        
        int x=gDate.get(GregorianCalendar.YEAR);
        int m=gDate.get(GregorianCalendar.MONTH)+1; // month starts at 0
        int day=gDate.get(GregorianCalendar.DAY_OF_MONTH);
        
        // convert from Gregorian calendar to Julian Calendar (not JD)
        int alpha= (int) x/100;
        int beta= 2 - alpha + ((int) alpha/4);
        int b= ((int) (365.25 * x)) + ((int) (30.6001 * (m+1))) + day + 1722519 + beta;
        int c = (int) ((b-122.1)/365.25);
        int d = (int) (365.25 * c);
        int e = (int) ((b-d)/30.6001);
        
        
        return tmp;
    }
    
}
