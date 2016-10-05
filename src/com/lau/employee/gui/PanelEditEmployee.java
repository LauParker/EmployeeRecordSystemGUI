package com.lau.employee.gui;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lau.employee.sys.Controller;
import com.lau.employee.object.Date;
import com.lau.employee.object.Employee;

public class PanelEditEmployee extends JPanel {
	JTextField IDTF;
	JTextField salaryTF;
	PanelEditDate startDatePanel;
	
	public PanelEditEmployee(int empIndex, boolean editable) {	
		this.setLayout(new GridBagLayout());
		JLabel employeeLB = new JLabel("EMPLOYEE");
		JLabel IDLB = new JLabel("ID No."); 
		JLabel salaryLB = new JLabel("Salary");
		JLabel startDateLB = new JLabel("Start Date");
		IDTF = new JTextField("id");
		salaryTF = new JTextField("salary");
		startDatePanel = new PanelEditDate(editable);
		
		try { // populate fields with employee info if array no has been passed on
			if (empIndex >= 0){
				IDTF.setText(String.valueOf(Controller.
						employeeStore.get(empIndex).getId()));
				salaryTF.setText(String.valueOf(Controller.
						employeeStore.get(empIndex).getSalary()));
				startDatePanel = new PanelEditDate(Controller.
						employeeStore.get(empIndex).getDateStarted(),
						editable);
			} else empIndex = 0; //do not populate fields
		} catch (NullPointerException e) {}
		
		this.add(employeeLB,Controller.setLayoutConstraints(3,0,7));
		this.add(IDLB,Controller.setLayoutConstraints(0,1,2));
		this.add(salaryLB,Controller.setLayoutConstraints(0,2,2));
		this.add(startDateLB,Controller.setLayoutConstraints(0,3,2));
		this.add(IDTF,Controller.setLayoutConstraints(2,1,3));
		this.add(salaryTF,Controller.setLayoutConstraints(2,2,3));
		this.add(startDatePanel,Controller.setLayoutConstraints(2,3,7));
		
		IDTF.setEnabled(editable);
		salaryTF.setEnabled(editable);
	}
	
	public Employee getEmployee() {
		Employee resultEmployee = new Employee("",' ',new Date(),
				IDTF.getText(),startDatePanel.getDate(),"");
		return resultEmployee;
	}
}