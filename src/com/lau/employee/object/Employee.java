package com.lau.employee.object;

import java.io.File;

/**
 * 
 * @author Laurence Parker
 *
 */
public class Employee extends Person {

	protected Date dateStarted;
	protected float salary;
	protected String id;
	protected String image;
	
	/**
	 * null constructor
	 */
	public Employee() {
		super();
		dateStarted = new Date();
		id = "";
		salary= 0;
		image = "";
	}
        
	/**
	 * Defined constructor
	 * @param nme name
	 * @param sex gender
	 * @param dob date of birth
	 * @param number id number
	 * @param start start date
	 * @param image string of file location to display empoyee picture
	 */
	public Employee(String nme,char sex,Date dob, 
			String IDNumber, Date start, String pic) {
		super(nme,sex,dob);
		salary = 0;
		id = IDNumber;
		dateStarted = new Date(start);
		image = pic;
	}
	
	/** 
	 * Clone constructor
	 * @param other
	 */
	public Employee (Employee other) {
		super(other.name, other.gender.trim().charAt(0), other.birthDate);
		id = other.id; 
		dateStarted = new Date(other.dateStarted);  
		image = other.image;
	}
	
	/**
	 * @param dateStarted the dateStarted to set
	 */
	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param sal the salary to set
	 */
    public void setSalary(float sal) {
        salary = sal;
    }
    
    /**
     * @param file location of employee image
     */
    public void setImage(String pic) {
    	image = pic;
    }
    
    /**
     * Coppy Employee to current
     * @param other
     */
    public void copy(Employee other) {
    	super.copyPerson(other);
        dateStarted = new Date(other.dateStarted);
        salary = other.salary;
        id = other.id;
        image = other.image;
    }
    
    /**
	 * @return the dateStarted
	 */
	public Date getDateStarted() {
		return dateStarted;
	}

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the image file location
	 */
	public String getImage() {
		return image;
	}
	/**
     * Override, Check if two employees are the same
     * @param other employee in comparison 
     * @return boolean true if they are the same
     */
    public boolean equalsEmployee (Employee other) {
        return super.equals(other) && id == other.id && salary == other.salary &&
        dateStarted.equals(other.dateStarted);
    }

    public String toString() {
        return super.toString() + "Employee Number:"+ id + " salary:" + salary + " Started:" + dateStarted.toString();
    }
}
