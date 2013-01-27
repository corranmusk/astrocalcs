/*
 * JulianDay.java
 * 
 * Copyright 2013 Corran Musk 
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.util.Date;
import java.util.GregorianCalendar;

public class JulianDay {

    double JD;
    GregorianCalendar gregorianDate=new GregorianCalendar();

    JulianDay() {

        /**
         * Default constructor set to current Date/Time
         */
        
        Date testTime = new Date();
        this.gregorianDate.setTime(testTime);
        this.JD = toJulianDay(this.gregorianDate);
    }

    public JulianDay(double DateValue) {
        // Constructor setting a value for the JD
        this.setJD(DateValue);
    }

    public JulianDay(GregorianCalendar GregDate) {
        // Consructor for GregorianCalendar object
        this.setGregorianDate(GregDate);
    }

    public final void setJD(double JDValue){
        this.JD=JDValue;
        this.gregorianDate=fromJulianDay(this.JD);
    }
    
    public final void setGregorianDate(GregorianCalendar GregDate){
        this.gregorianDate=GregDate;
        this.JD=toJulianDay(this.gregorianDate);
    }
    
    public double MJD() {
        // Returns the Modified Julian Day of the current JD
        double MJDay = MJD(this.JD);
        return MJDay;
    }

    public static double MJD(double JDate) {
        // Caluclutes the Modified Julian Day and returns it
        double MJDay = JDate - 2400000.5;
        return MJDay;
    }

    public static double toJulianDay(GregorianCalendar GregDate) {
        double JulianDay;

        int yr = GregDate.get(GregorianCalendar.YEAR);
        int mth = GregDate.get(GregorianCalendar.MONTH);
        mth++; // Adjust for fact that Gregorian Date is Jan=0;
        int day = GregDate.get(GregorianCalendar.DAY_OF_MONTH);

        //Calculate the time Fraction
        double tm;
        tm = GregDate.get(GregorianCalendar.HOUR_OF_DAY) / 24.0;
        tm += GregDate.get(GregorianCalendar.MINUTE) / (24.0 * 60.0);
        tm += GregDate.get(GregorianCalendar.SECOND) / (24.0 * 60.0 * 60.0);

        if (mth > 2) {
            mth += 12;
            yr -= 1;
        }

        int a = yr / 100;
        int b = 2 - a + (int) (a / 4);
        int c = (int) (365.25 * (yr + 4716));
        int d = (int) (30.6 * (mth + 1));

        JulianDay = ((double) (c + d + day + b)) + tm - 1524.5;

        return JulianDay;

    }

    public static GregorianCalendar fromJulianDay(double JulianDay) {
        /**
         * Calculate the Gregorian Date froma JulianDay
         */
        
        GregorianCalendar gregDate;

        JulianDay += 0.5;
        int z = (int) JulianDay;
        double f = JulianDay - z;

        int a;
        if (z < 2299161) {
            a = z;
        } else {
            int alpha = (int) ((z - 1867216.25) / 36524.25);
            a = z + 1 + alpha - (int) (alpha / 4);
        }
        double b = a + 1524.0;
        double c = (int) ((b - 122.1) / 365.25);
        int d = (int) (365.25 * c);
        int e = (int) ((b - d) / 30.6001);

        int tmp = (int) (30.6001 * e);
        double dom = b - d - tmp + f;

        int mth;
        if (e < 14) {
            mth = e - 1;
        } else {
            mth = e - 13;
        }
        int yr;
        if (mth > 2) {
            yr = (int) c - 4716;
        } else {
            yr = (int) c - 4715;
        }

        int hrs = (int) (f * 24.0);
        int mins = (int) ((f - (hrs / 24.0)) * 60 * 24);
        int secs = (int) ((f - (hrs / 24.0) - (mins / (60.0 * 24))) * 3600 * 24);

        gregDate = new GregorianCalendar(yr, mth - 1, (int) dom, hrs, mins, secs);

        return gregDate;
    }

    public static String displayGregDate(GregorianCalendar gregDate) {

        String tmp = "";

        tmp += gregDate.get(GregorianCalendar.DAY_OF_MONTH);
        tmp += "/";
        tmp += (gregDate.get(GregorianCalendar.MONTH) + 1);
        tmp += "/";
        tmp += gregDate.get(GregorianCalendar.YEAR);
        tmp += " ";
        tmp += gregDate.get(GregorianCalendar.HOUR_OF_DAY);
        tmp += ":";
        tmp += gregDate.get(GregorianCalendar.MINUTE);
        tmp += ":";
        tmp += gregDate.get(GregorianCalendar.SECOND);

        return tmp;
    }

    public String displayGregDate() {

        return displayGregDate(this.gregorianDate);

    }

    public static String displayDay(double JDay) {

        return "Julian Day is : " + JDay;

    }

    public void displayDay() {

        displayDay(this.JD);

    }

    public double getJD() {

        return JD;

    }
    
    public static void main(String[] args){
        // for testing
        JulianDay test=new JulianDay();
        try{
            System.out.println(test.displayGregDate());
        } catch (Exception e) {
            // do nowt
        }
    }
}
