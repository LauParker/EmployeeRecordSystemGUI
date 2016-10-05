package com.lau.employee.gui;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lau.employee.object.Date;

public class PanelEditDate extends JPanel{
	private JComboBox dayCBox;
	private JComboBox monthCBox;
	private JComboBox yearCBox;

	public PanelEditDate(boolean editable) {
		this.setLayout(new GridLayout(2,6,1,1));
		String days[] = buildDaysList();
		dayCBox = new JComboBox(days);
		String months[] = buildMonthsList();
		monthCBox = new JComboBox(months);
		String years[] = buildYearsList();
		yearCBox = new JComboBox(years);
		this.add(new JLabel("  DD:"));
		this.add(new JLabel("  MM:"));
		this.add(new JLabel("  YYYY:"));
		this.add(dayCBox);
		this.add(monthCBox);
		this.add(yearCBox);
		dayCBox.setEnabled(editable);
		monthCBox.setEnabled(editable);
		yearCBox.setEnabled(editable);
		
	}
	
	public PanelEditDate(Date display, boolean editable) {
		this.setLayout(new GridLayout(2,6,1,1));
		String days[] = buildDaysList();
		dayCBox = new JComboBox(days);
		String months[] = buildMonthsList();
		monthCBox = new JComboBox(months);
		String years[] = buildYearsList();
		yearCBox = new JComboBox(years);
		this.add(new JLabel("  DD:"));
		this.add(new JLabel("  MM:"));
		this.add(new JLabel("  YYYY:"));
		this.add(dayCBox);
		this.add(monthCBox);
		this.add(yearCBox);
		dayCBox.setSelectedIndex(display.getDay() -1);
		monthCBox.setSelectedIndex(display.getMonth() -1);
		yearCBox.setSelectedIndex(2014 - display.getYear());
		dayCBox.setEnabled(editable);
		monthCBox.setEnabled(editable);
		yearCBox.setEnabled(editable);
	}
	
	public static String[] buildDaysList() {
		
		String[] daysList = new String[31];
		for (int i = 0; i < 31; i++)
			daysList[i] = daysList[1].valueOf(i + 1); 
		return daysList;
	}

	public static String[] buildMonthsList() {
		String[] monthList = new String[12];
		for (int i = 0; i < 12; i++)
			monthList[i] = monthList[1].valueOf(i + 1); 
		return monthList;
	}
	public static String[] buildYearsList() {
		String[] yearList = new String[65];
		for (int i = 0; i < 65; i++)
			yearList[i] = yearList[1].valueOf(2014 - i); 
		return yearList;
	}
	
	public Date getDate() {
		Date resultDate = new Date(
				(dayCBox.getSelectedIndex()+1), 
				(monthCBox.getSelectedIndex()+1),
				(2014 - yearCBox.getSelectedIndex()));
		return resultDate;
	}
}
