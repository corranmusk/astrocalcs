/*
 * JulianDayCalculator.java
 * 
 * Copyright 2013 Corran Musk 
 * 
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
import java.awt.*;
import java.awt.event.*;

public class JulianDayCalculator extends JFrame implements ActionListener {

    final public static int CALCBUTTON=1;
    
    JulianDay test = new JulianDay();
    
    JTextField  JDay = new JTextField(20);
    JLabel      JDayLab = new JLabel ("Julian Day");
    JButton     JBut = new JButton("Calculate");
    JLabel      GDate = new JLabel("GDATE:");
    
    public JulianDayCalculator() {

        super("Julian Day Calculator");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        setSize(350,100);
        
        FlowLayout flow = new FlowLayout();
        Container content = this.getContentPane();
        content.setLayout(flow);
        
        JBut.addActionListener(this) ;
        content.add(JDayLab);
        content.add(JDay);
        content.add(JBut);
        content.add(GDate);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        
        JulianDayCalculator frame = new JulianDayCalculator();
  	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if(source==JBut){
            test.JulianDay(Double.parseDouble(JDay.getText()));
            GDate.setText("MJD is " + test.MJD());
        }
    }
}
