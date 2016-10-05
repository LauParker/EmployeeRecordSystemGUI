package com.lau.employee.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.lau.employee.sys.Controller;

public class MainFrame extends JFrame {

	public MainFrame() {
		this.setTitle("Employee Record System"); // employee record system frame
		this.setJMenuBar(createFrameMenu());		
		this.setSize(900, 600);
		this.getContentPane().setLayout(new BorderLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public JMenuBar createFrameMenu()
	{	
		JMenuBar menuBar = new JMenuBar();
		JMenuItem newItem = new JMenuItem("New");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO check for save first.
				Controller.newStoreCreationOption();
			}
		});

		openItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//event code for open menu selection
			}
		});

		saveItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//event code for save menu selection
			}
		});

		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// exit program
				System.exit(0);
			}
		});
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		
		return menuBar;
	}
}
