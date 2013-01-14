/*
 * JulianDayCalculator.java
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

import javax.swing.*;
import java.awt.Event;
import java.awt.AWTEvent;
import java.awt.event.WindowEvent;

import java.awt.Toolkit;
import java.awt.Dimension;

public class JulianDayCalculator extends JFrame {

	JulianDay test = new JulianDay();
	static JulianDayCalculator window;
	
	public JulianDayCalculator() {
		
		setTitle("Julian Day Calculator");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	}
	
	protected void processWindowEvent(WindowEvent e){
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			dispose();
			System.exit(0);
		}
		super.processWindowEvent(e);
	}
	
    public static void main(String[] args) {
		window = new JulianDayCalculator();
	
		Toolkit theKit = window.getToolkit();
		Dimension wndSize = theKit.getScreenSize();
		
		window.setBounds(wndSize.width/4, wndSize.height/4,  // Position
						 250, 400); // Size
						 
		window.setVisible(true);
    }	
}
