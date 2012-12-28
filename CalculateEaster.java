/*
 * CalculateEaster.java
 * 
 * Copyright 2012 Corran <corran@R2>
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


public class CalculateEaster {
	
	// Cacluates the date for Easter Sunday in a given year
	// From Astronomical Algorithms 2nd Ed, Meeus, J, 2000
	// Gregorian Calendar valid from 1583
	
	static int yr=1992; // year
	static String[] months={ 
		"Jan","Feb","Mar","Apr","May","Jun",
		"Jul","Aug","Sep","Oct","Nov","Dec"
	};
	
	public static void main (String args[]) {
		
		int a=yr % 19;
		int b=yr / 100;
		int c=yr % 100;
		int d=b / 4;
		int e=b % 4;
		int f=(b+8)/25;
		int g=(b-f+1)/3;
		int h=((19 * a) + b - d - g + 15) % 30;
		int i=c/4;
		int k=c % 4;
		int l=(32 + (2*e) + (2*i) -h -k) % 7;
		int m=(a + (11*h) + (22 *l)) /451;
		int mth=(h + l - (7*m) + 114 )/31;
		int dy= ((h + l - (7*m) + 114 ) % 31) + 1;
	
		System.out.println ("Easter in " + yr + " falls on Sunday " + dy + " of " + months[mth-1]);
		
	}
}

