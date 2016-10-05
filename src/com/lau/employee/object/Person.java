package com.lau.employee.object;

import java.io.Serializable;

import com.lau.employee.object.Date;

/**
 * 
 * @author Laurence Parker
 *
 */
public class Person implements Serializable {

	protected String name, gender, address, nationalI, phone;
	protected Date birthDate;
	private static int count = 0;
	
	/**
	 * Null constructor
	 */
	public Person() {
		count++;
		name = "";
		gender = "";
		address = "";
		nationalI = "";
		phone = "";
		birthDate = new Date();
	}
	
	/**
	 * Defined constructor
	 * @param nme Name of Person
	 * @param sex Gender of Person
	 * @param dob Birthdate of Person
	 */
	public Person(String nme, char sex, Date dob) {
		count ++;
		name = nme;
		gender = charToString(sex);
		birthDate = new Date(dob);
		address = "";
		nationalI = "";
		phone = "";
	}
	
	/**
	 * Clone constructor
	 * @param other Person to clone
	 */
	public Person(Person other) {
		count ++;
		name = other.name;
		birthDate = new Date(other.birthDate);
		gender = other.gender;
		address = other.address;
		nationalI = other.nationalI;
		phone = other.phone;	
	}
	
	/**
	 * Copy existing Person to current Person.
	 * @param other Person to copy
	 */
	public void copyPerson (Person other) {
		count ++;
		name = other.name;
		birthDate = new Date(other.birthDate);
		gender = other.gender;
		address = other.address;
		nationalI = other.nationalI;
		phone = other.phone;	
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param nationalI the nationalI to set
	 */
	public void setNationalI(String nationalI) {
		this.nationalI = nationalI;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the nationalI
	 */
	public String getNationalI() {
		return nationalI;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the count of Persons created
	 */
	public static int getCount() {
		return count;
	}
	
	/**
	 * Override toString(), formatted
	 */
	public String toString() {
		return "name:" + name + " Gender:" + gender + "address:" + address +
				" birthday:" + birthDate + " NationalI No:" + nationalI +
				" Phone:" + phone;
	}
	
	/**
	 * Convert users char input to a string for records
	 * @param sex char defining Persons gender
	 * @return String defining Persons gender
	 */
	public String charToString(char sex) {
		if ((sex =='m') || (sex == 'M')) {
			return "male";
		} else if ((sex == 'f') || (sex == 'F')) {
			return "female";
		} else 
			return "invalid";
	}
	
	/**
	 * Override equals() object, check if Person is the same as another 
	 * @param other Person used to compare
	 * @return boolean true if they are the same
	 */
	public boolean equals(Person other) {
		return name.equals(other.name) && gender.equals(other.gender) && 
				birthDate.equals(other.birthDate) && address.equals(other.address) && 
				nationalI.equals(other.nationalI) && phone.equals(other.phone); 
	}
}
