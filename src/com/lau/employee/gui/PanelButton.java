package com.lau.employee.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.lau.employee.sys.Controller;

public class PanelButton extends JPanel{
	JButton viewBtn = new JButton("View");
	JButton editBtn = new JButton("Edit");
	public PanelButton(final int empIndex, boolean view,boolean edit){
		this.setLayout(new FlowLayout());
		viewBtn = new JButton("View");
		editBtn = new JButton("Edit");
				viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Controller.newPage(empIndex, "View" ,false, true);
			}
		});
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Controller.newPage(empIndex, "Edit", true, false);
			}
		});
		
		this.add(viewBtn);
		this.add(editBtn);
		setBtnPanelVisibility(view, edit);
	}
	
	public void setBtnPanelVisibility(boolean viewVisibility,
			boolean editVisibility) {
		viewBtn.setEnabled(viewVisibility);
		editBtn.setEnabled(editVisibility);
	}
}
