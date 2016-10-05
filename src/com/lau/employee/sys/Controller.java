package com.lau.employee.sys;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import com.lau.employee.gui.EmployeeEdit;
import com.lau.employee.gui.EmployeeView;
import com.lau.employee.gui.MainFrame;
import com.lau.employee.gui.PanelButton;
import com.lau.employee.gui.PanelEditEmployee;
import com.lau.employee.gui.PanelEditPerson;
import com.lau.employee.gui.PanelLabel;
import com.lau.employee.gui.PanelNewLoad;
import com.lau.employee.gui.PanelNewStoreOption;
import com.lau.employee.object.Date;
import com.lau.employee.object.Employee;

public class Controller {
	private static MainFrame frame;
	private static Container container;
	public static ArrayList <Employee> employeeStore;
	

	/*************** Runnable ***************/
	
	public static void main (String Args[]) {
		employeeStore = new ArrayList<Employee>();
		frame = new MainFrame();
		container = frame.getContentPane();
		newPage(0, "Start", false, false);
	}

	/*************** Frame  ***************/
	
	public static void newPage(int employeeRecordNo, 
				String title, boolean view,boolean edit) {
		container.removeAll();
		frame.getContentPane().setLayout(new BorderLayout());		
		frame.getContentPane().add(new PanelLabel("Employee Record System : " 
				+ title), BorderLayout.NORTH);
		frame.getContentPane().add(new PanelButton(employeeRecordNo, view, edit), 
				BorderLayout.SOUTH);
		frame.getContentPane().add(new PanelLabel("             "), 
				BorderLayout.EAST);
		frame.getContentPane().add(new PanelLabel("             "), 
				BorderLayout.WEST);	
		switch (title) {
		case "Start":
			frame.getContentPane().add(new PanelNewLoad(),
					BorderLayout.CENTER);
			break;
		case "Edit":
			frame.getContentPane().add(new EmployeeEdit(
					employeeRecordNo), BorderLayout.CENTER);
			break;
		case "View":
			frame.getContentPane().add(new EmployeeView(
					employeeRecordNo), BorderLayout.CENTER);
			break;
		default: //do nothing
		}
		frame.setVisible(true);
		container = frame.getContentPane();		
	}

	/*************** GridBag Layout defaults ***************/

	public static GridBagConstraints setLayoutConstraints(
			int setX, int setY, int setWidth){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = setX;
		gbc.gridy = setY;
		gbc.gridheight = 1;
		gbc.gridwidth = setWidth;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(3,3,3,3);
		gbc.anchor = GridBagConstraints.WEST;
		return gbc;	
	}

	/*************** Employee Store ***************/

	public static void newStoreCreationOption() {
		new PanelNewStoreOption();
	}
	
	public static void createDefaultStore() {
		employeeStore.removeAll(employeeStore);
		for (int i = 0; i < 10; i++) {
			employeeStore.add(new Employee("Lau"+i, 'M', 
					new Date(4,i+2,1986 - i), "EMP999"+i,
					new Date(i+1,9,1990 - i), "picture/anon0" + (i+1) + ".png"));
		}
	}
	
	public static void createNewStore() {
		employeeStore.removeAll(employeeStore);
		employeeStore = new ArrayList<Employee>();
		employeeStore.add(new Employee());
	}

	public static void addNewEmployee(int empIndex, 
			PanelEditPerson newPerson, PanelEditEmployee newEmployee,
			String ImageEmployee) {
		Employee addPerson = newPerson.getPerson();
		Employee addEmployee = newEmployee.getEmployee();
		addPerson.setId(addEmployee.getId());
		addPerson.setSalary(addEmployee.getSalary());
		addPerson.setDateStarted(addEmployee.getDateStarted());
		addPerson.setImage(ImageEmployee);
		if (empIndex==-1) {
			employeeStore.add(addPerson);
		} else {
			employeeStore.get(empIndex).copy(addPerson);
		}
	}
}