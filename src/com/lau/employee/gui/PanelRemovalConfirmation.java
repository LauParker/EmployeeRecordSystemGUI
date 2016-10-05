package com.lau.employee.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lau.employee.sys.Controller;

public class PanelRemovalConfirmation extends JPanel {
	public PanelRemovalConfirmation(int empIndex) {
		this.add(new PanelEditPerson(empIndex, false));
		this.add(new PanelEditEmployee(empIndex,false));
		
		int result = JOptionPane.showConfirmDialog(null, this, "Confirm",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {	
			Controller.employeeStore.remove(empIndex);
			Controller.newPage(0, "View", false, true);
		}
	}
}