package com.lau.employee.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.lau.employee.sys.Controller;

public class EmployeeView extends JPanel {
	public EmployeeView(int empIndex) {
		this.setLayout(new GridBagLayout());
		this.add(new PanelEditPerson(empIndex, false), 
				Controller.setLayoutConstraints(1,1,1)); 
		this.add(new PanelEditEmployee(empIndex, false), 
				Controller.setLayoutConstraints(1,2,1));
		this.add(new PanelPreviousIndexNext(empIndex),
				Controller.setLayoutConstraints(1,3,10));

		GridBagConstraints gbc = 
				Controller.setLayoutConstraints(2,0,9);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.fill =  GridBagConstraints.BOTH;
		gbc.weightx = 10;
		gbc.weighty = 10;
		this.add(new PanelImageEmployee(
				Controller.employeeStore.get(empIndex).getImage()), gbc);
	}
}
