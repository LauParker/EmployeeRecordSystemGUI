package com.lau.employee.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.lau.employee.sys.Controller;

public class PanelNewLoad extends JPanel{
	public PanelNewLoad(){

	this.setLayout(new GridLayout());
	JButton newStore = new JButton("New Store");
	JButton loadStore = new JButton("Load Store");
	
	newStore.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent e) {
			Controller.newStoreCreationOption();
			Controller.newPage(0, "View", false, true);
		}
	});
	
	loadStore.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("this will load an existing store");
			// TODO pop up for file load.
		}
	});
	
	this.add(newStore);
	this.add(loadStore);
	}
}

