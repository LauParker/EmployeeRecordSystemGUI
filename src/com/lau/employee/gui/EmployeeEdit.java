package com.lau.employee.gui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.lau.employee.sys.Controller;

public class EmployeeEdit extends JPanel {
	public EmployeeEdit(final int empIndex) {
		this.setLayout(new GridBagLayout());
		final PanelEditPerson editPerson = 
				new PanelEditPerson(empIndex, true);
		final PanelEditEmployee editEmployee = 
				new PanelEditEmployee(empIndex, true);
		final PanelImageEmployee imageEmployee = 
				new PanelImageEmployee(
						Controller.employeeStore.get(empIndex).getImage());
		this.add(editPerson, 
				Controller.setLayoutConstraints(1,1,1));
		this.add(editEmployee, 
				Controller.setLayoutConstraints(1,2,1));

		GridBagConstraints gbc = 
				Controller.setLayoutConstraints(2,0,9);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.fill =  GridBagConstraints.BOTH;
		gbc.weightx = 10;
		gbc.weighty = 10;
		this.add(imageEmployee, gbc);

		JPanel updatePanel = new JPanel(new FlowLayout());
		JButton updateBtn = new JButton("Update");
		JButton removeBtn = new JButton("Remove");
		
		updateBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
System.out.println(Controller.employeeStore.get(empIndex).getImage());
System.out.println(imageEmployee.getEmployeeImage());
				Controller.addNewEmployee(empIndex, 
						editPerson, 
						editEmployee,
						imageEmployee.getEmployeeImage());
				Controller.newPage(empIndex, "View", false, true);
			}
		});
		
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PanelRemovalConfirmation(empIndex);
			}
		});

		updatePanel.add(updateBtn);
		updatePanel.add(removeBtn);
		this.add(updatePanel,
				Controller.setLayoutConstraints(1, 3, 1));
	}
}