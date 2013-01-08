/*
 * AccuracyCheck.java
 * 
 * Copyright 2012 Corran Musk
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


public class AccuracyCheck {
	
	public static void main (String args[]) {
		
		double	x=1.0;
		int		j=0;
		
		while (x != x+1.0) {
			x=x*2;
			j++;
		}
		System.out.println("Significant bits:\t" +j+"\nSignificant digits:\t" + j*0.30103);
		
		double y=1.0000001;
		double y_actual=674530.4707;
		// probably more precise but this is what is given in the book!
		double y_error;
		int i;
		
		for(i=0;i<27;i++){
			y*=y;
		}
		y_error=y-y_actual;
		System.out.println("After " + i + " iterations y=" + y + " error is " + y_error);
	}
}

