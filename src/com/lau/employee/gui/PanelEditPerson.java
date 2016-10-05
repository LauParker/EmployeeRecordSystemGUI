package com.lau.employee.gui;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lau.employee.object.Date;
import com.lau.employee.object.Employee;
import com.lau.employee.object.Person;
import com.lau.employee.sys.Controller;

public class PanelEditPerson extends JPanel{
	private JTextField nameTF;
	private JTextField genderTF;
	private JTextField addressTF;
	private PanelEditDate dobPanel;
	private JTextField phoneTF;
	private JTextField natTF;
	
	public PanelEditPerson(int empIndex, boolean editable) {
		this.setLayout(new GridBagLayout());
		// PERSON create labels and textfields
		JLabel personlb = new JLabel("PERSON");
		JLabel namelb = new JLabel("Name"); 	
		JLabel genderlb = new JLabel("Gender");	
		JLabel dateOBlb = new JLabel("Date of Birth");	
		JLabel addresslb = new JLabel("Address");
		JLabel phonelb = new JLabel("Phone No.");
		JLabel natINumlb = new JLabel("National I No.");
		nameTF = new JTextField("name");
		genderTF = new JTextField("gender");
		dobPanel = new PanelEditDate(editable);
		addressTF = new JTextField("address");
		phoneTF = new JTextField("phoneNo");
		natTF = new JTextField("national I No.");
		
		try { // update edit fields if array number passed is present
			if (empIndex >= 0){ 
				nameTF.setText(Controller.employeeStore.
						get(empIndex).getName());
				genderTF.setText(Controller.employeeStore.
						get(empIndex).getGender());
				addressTF.setText(Controller.employeeStore.
						get(empIndex).getAddress());
				phoneTF.setText(Controller.employeeStore.
						get(empIndex).getPhone());
				natTF.setText(Controller.employeeStore.
						get(empIndex).getNationalI());
				dobPanel = new PanelEditDate(Controller.employeeStore.
						get(empIndex).getBirthDate(), editable);
			}
			else
				empIndex = 0;
		}
		catch (NullPointerException e){
		}
		
		this.add(natTF,Controller.setLayoutConstraints(2,6,4));
		this.add(phoneTF,Controller.setLayoutConstraints(2,5,4));
		this.add(addressTF,Controller.setLayoutConstraints(2,4,6));
		this.add(dobPanel,Controller.setLayoutConstraints(2,3,7)); 
		this.add(genderTF,Controller.setLayoutConstraints(2,2,3));		
		this.add(nameTF,Controller.setLayoutConstraints(2,1,4));
		this.add(natINumlb,Controller.setLayoutConstraints(0,6,2));
		this.add(phonelb,Controller.setLayoutConstraints(0,5,2));
		this.add(addresslb,Controller.setLayoutConstraints(0,4,2));
		this.add(dateOBlb,Controller.setLayoutConstraints(0,3,2));
		this.add(genderlb,Controller.setLayoutConstraints(0,2,2));		
		this.add(namelb,Controller.setLayoutConstraints(0,1,2));
		this.add(personlb,Controller.setLayoutConstraints(3,0,7));

		nameTF.setEnabled(editable);
		genderTF.setEnabled(editable);
		addressTF.setEnabled(editable);
		natTF.setEnabled(editable);
		phoneTF.setEnabled(editable);
	}
	
	public Employee getPerson() {
		char sex = genderTF.getText().trim().charAt(0);
		Employee personResult = new Employee(nameTF.getText(),
				sex,dobPanel.getDate(),"",new Date(),"");
		personResult.setAddress(addressTF.getText());
		personResult.setNationalI(natTF.getText());
		personResult.setPhone(phoneTF.getText());
		return personResult;
	}
}
