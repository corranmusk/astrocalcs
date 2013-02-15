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

    JulianDay test = new JulianDay();
    JTextField JDay = new JTextField(String.valueOf(test.getJD()), 10);
    JLabel JDayLab = new JLabel("Julian Day");
    JButton JBut = new JButton("Calculate");
    JLabel GDate = new JLabel("GDATE:" + test.displayGregDate());

    public JulianDayCalculator() {

        super("Julian Day Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        setSize(250, 100);

        FlowLayout flow = new FlowLayout();
        Container content = this.getContentPane();
        content.setLayout(flow);

        JBut.addActionListener(this);
        content.add(JDayLab);
        content.add(JDay);
        content.add(JBut);
        content.add(GDate);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == JBut) {
            try {
                test.setJD(Double.parseDouble(JDay.getText()));
            } catch (Exception e) {
                // do nowt... okay, set it internally to zero
                test.setJD(0);
            }
            GDate.setText("GDate is :" + test.displayGregDate());
        }
    }

    public static void main(String[] args) {

        JulianDayCalculator frame = new JulianDayCalculator();

    }
}
