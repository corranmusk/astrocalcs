/*
 * ConvertDate.java
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
 
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class ConvertDate {
	
	public static double toJulianDay(GregorianCalendar GregDate)
	{
		double JulianDay;
		int yr=GregDate.get(GregorianCalendar.YEAR);
		int mth=GregDate.get(GregorianCalendar.MONTH);
		mth++; // Adjust for fact that Gregorian Date is Jan=0;
		int day=GregDate.get(GregorianCalendar.DAY_OF_MONTH);
		
		if (mth>2) {
			mth+=12;
			yr-=1;
		}
		
		int a = yr/100;
		int b = 2 -a + (int) (a/4);
		int c = (int) (365.25 * (yr + 4716));
		int d = (int) (30.6 * (mth+1));
		
		JulianDay= c + d + day + b -1524.5;
		
		return JulianDay;
		
	}
	
	public static GregorianCalendar fromJulianDay ( double JulianDay)
	{
		GregorianCalendar gregDate;
		
		int z = (int) JulianDay;
		double f= JulianDay - z;
		
		int a;
		if ( z<2299161){
			a=z;
		} else {
			int alpha= (int) (( z-1867216.25)/36524.25);
			a=z+1+alpha- (int) (alpha/4);
		}
		int b = a+1524;
		int c = (int) ((b-122.1)/365.25);
		int d = (int) (365.25 * c);
		int e = (int) ((b-d)/30.6001);
		
		int tmp = (int) (30.6001 *e);
		int dom = b - d - tmp; // need to add f to this but worried about doubles etc..
		
		int mth;
		if(e<14){
			mth=e-1;
		} else {
			mth=e-13;
		}
		int yr;
		if(mth>2){
			yr=c-4716;
		} else {
			yr=c-4715;
		}
		
		gregDate = new GregorianCalendar(yr,mth-1,dom);
		
		return gregDate;
	}
	
	public static void main (String args[]) {
		
		double JD;
		
		GregorianCalendar testDate=new GregorianCalendar(1957,9,4);
		JD=toJulianDay(testDate);
		System.out.println("Julian Date is " + JD);
		
		SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
		System.out.println(date_format.format(fromJulianDay(JD).getTime()));

	}
}

