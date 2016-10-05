package com.lau.employee.gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lau.employee.object.Employee;
import com.lau.employee.sys.Controller;

public class PanelAddEmployee extends JPanel {
	public PanelAddEmployee() {
		PanelEditPerson newPerson = new PanelEditPerson(-1,true);
		PanelEditEmployee newEmployee = new PanelEditEmployee(-1,true);
		
		this.add(newPerson);
		this.add(newEmployee);
		
		int result = JOptionPane.showConfirmDialog(null, this, "Confirm",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {	
			Controller.addNewEmployee(-1,newPerson,newEmployee,"");
		}
	}
}
