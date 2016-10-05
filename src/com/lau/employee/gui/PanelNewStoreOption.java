package com.lau.employee.gui;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lau.employee.sys.Controller;

public class PanelNewStoreOption extends JPanel {
	public PanelNewStoreOption() {
		JPanel storeOption = new JPanel(new GridLayout(0,1));
		JTextField employeeNumber = new JTextField("0");
		JCheckBox defaultStore = new JCheckBox("Default Store");
		storeOption.add(new JLabel("Enter the number of employees"));
		storeOption.add(employeeNumber);
		storeOption.add(defaultStore);
		int result = JOptionPane.showConfirmDialog(null, storeOption, "Store Size",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {	
			if (defaultStore.isSelected()){		
				Controller.createDefaultStore();
				Controller.newPage(0, "View", true, false);
				}
			else {
				boolean accepted = false;
				try {
					int input = Integer.parseInt(employeeNumber.getText().trim());
					accepted = true;
				}
				catch (NumberFormatException ex) {
				}
				if (accepted = true) {
					Controller.createNewStore();
					Controller.newPage(0, "View", true, false);
				}
			}
		}
	}
}