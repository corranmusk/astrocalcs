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
	
	public static void main (String args[]) {
		
		GregorianCalendar testDate=new GregorianCalendar(1957,9,4);
		System.out.println("Julian Date is " + toJulianDay(testDate));
	}
}

