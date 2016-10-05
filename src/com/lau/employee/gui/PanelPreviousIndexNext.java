package com.lau.employee.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.lau.employee.sys.Controller;

public class PanelPreviousIndexNext extends JPanel {
	public PanelPreviousIndexNext(final int empIndex) {
		JPanel switchRecord = new JPanel(new FlowLayout());
		JButton add = new JButton("Add");
		JButton prev = new JButton("Prev");
		JButton next = new JButton("Next");

		add.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new PanelAddEmployee();
			}
		});
		
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the index No is 0 switch to other end of index 
				if (empIndex == 0)
					Controller.newPage((Controller.employeeStore.size() -1), 
							"View", false, true);
				else {
					Controller.newPage(empIndex - 1, 
							"View", false, true);
				}
			}
		});
	
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// if index is at end of array
				if (empIndex == (Controller.employeeStore.size() -1))
					Controller.newPage(0, 
							"View", false, true);
				else {
					Controller.newPage(empIndex + 1, 
							"View", false, true);
				}
			}
		});
	
		this.add(add);
		this.add(new PanelLabel("       "));
		this.add(prev);
		this.add(next);
	}
}