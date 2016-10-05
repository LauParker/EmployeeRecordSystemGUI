package com.lau.employee.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.lau.employee.sys.Controller;

public class PanelMenu extends JPanel {
	public PanelMenu() {
		this.setLayout(new GridBagLayout());
		JPanel menuPanel = new JPanel(new GridLayout(4,1));
		JButton addEmployee = new JButton("Add Employee");
		JButton removeEmployee = new JButton("Remove Employee");
		JButton searchStore = new JButton("Search Store");		

		GridBagConstraints c = Controller.setLayoutConstraints(1,1,0);
		c.gridheight = GridBagConstraints.REMAINDER;
		c.gridwidth = GridBagConstraints.RELATIVE;
		c.weightx = 10;
		c.weighty = 7;
		c.fill = GridBagConstraints.BOTH;
	
		addEmployee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new PanelAddEmployee();
			}
		});

		menuPanel.add(addEmployee);
		
		this.add(menuPanel,c);
	}
}