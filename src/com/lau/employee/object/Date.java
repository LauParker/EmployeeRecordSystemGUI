package com.lau.employee.object;

public class Date {
    private int day, month, year;
    
    /**
     * Null constructor
     */
	public Date() {
		super();
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}

	/**
	 * Defined constructor
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Clone constructor
	 * @param other
	 */
	public Date (Date other) {
        day = other.day;
        month = other.month;
        year = other.year;
    }

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * set to copy values of another date
	 * @param other
	 */
	public void CopyDate(Date other) {
        day = other.day;
        month = other.month;
        year = other.year;		
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the object as a string
	 */
    public String toString() {
        return " DD: " + day + " MM: " + month + " YY: " + year;            
    }

    /**
     * check if current date is older than other date
     * @param other
     * @return the boolean check, true if current date is older
     */
    public boolean lessThan(Date other) {
        if (year < other.year)
            return true;
        else if (year == other.year && month < other.month)
            return true;
        else if (year == other.year && month == other.month && day < other.day)
            return true;
        else
            return false;    
    }
    
    /**
     * check if current date is the same value as other date
     * @param other
     * @return the boolean check, true if dates match
     */
    public boolean equals(Date other) {
        return day == other.day && month == other.month && year == other.year;
    }
	   
    /**
     * convert month integer to three letter string to represent the month.
     * @return the three letter string
     */
    public String monthAsString() {
    	switch (month)
        {
        	case 1: return "Jan";
         	case 2: return "Feb";
           	case 3: return "Mar";
            case 4: return "Apr";
            case 5: return "May";
            case 6: return "Jun";
            case 7: return "Jul";
            case 8: return "Aug";
            case 9: return "Sep";
            case 10:return "Oct";
            case 11:return "Nov";
            case 12:return "Dec";
            default: return "invalid month";
	    }
    }
}
