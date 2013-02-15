/**
 * Moslem calendar conversion functions
 * Meaningless result pre 622 July 16
 * @author Corran Musk
 */
import java.util.Date;
import java.util.GregorianCalendar;

public class MoslemCalendar {

    static String[] monthNames = {"Muharram", "Safar", "Rabi\'al-Awwal", "Rab\'ath-Thani",
        "Jumada l-Ula", "Jumada t-Tania", "Rajab", "Sha\'ban",
        "Ramadan", "Shawwal", "Dhu l-Qa\'da", "Dhu l-Hijja"};
    public int MONTH;
    public String MONTH_NAME;
    public int YEAR;
    public int DAY_OF_MONTH;

    //Constructors
    MoslemCalendar() {
        // Set date accorinding to current time
        Date now=new Date();
        GregorianCalendar tmp=new GregorianCalendar();
        tmp.setTime(now);
        fromGregorian(tmp);
    }

    MoslemCalendar(GregorianCalendar gDate) {
        /**
         *Set Date according specific given 
         * @param gDate GregorianCalendar Specific date
         */
        fromGregorian(gDate);
    }

    MoslemCalendar(int dayOfMonth, int month, int year) {

        this.DAY_OF_MONTH = dayOfMonth;
        this.MONTH = month;
        this.MONTH_NAME = monthNames[month];
        this.YEAR = year;

    }

    public final void fromGregorian(GregorianCalendar gDate) {

        int x = gDate.get(GregorianCalendar.YEAR);
        int m = gDate.get(GregorianCalendar.MONTH) + 1; // month starts at 0
        int day = gDate.get(GregorianCalendar.DAY_OF_MONTH);

        // convert from Gregorian calendar to Julian Calendar (not JD)
        int alpha = (int) x / 100;
        int beta = 2 - alpha + ((int) alpha / 4);
        int b = ((int) (365.25 * x)) + ((int) (30.6001 * (m + 1))) + day + 1722519 + beta;
        int c = (int) ((b - 122.1) / 365.25);
        int d = (int) (365.25 * c);
        int e = (int) ((b - d) / 30.6001);
        // TO DO 

    }

    public GregorianCalendar toGregorian() {

        GregorianCalendar tmp;
        tmp = toGregorian(this.DAY_OF_MONTH, this.MONTH, this.YEAR);
        return tmp;

    }

    public static GregorianCalendar toGregorian(int dayOfMonth, int Month, int year) {

        GregorianCalendar tmp = new GregorianCalendar();
        // TO DO
        // Main conversion here

        return tmp;
    }

    public String asText() {

        String tmp = "";
        tmp += this.DAY_OF_MONTH;
        tmp += " ";
        tmp += this.MONTH_NAME;
        tmp += " ";
        tmp += this.YEAR;
        return tmp;

    }
}