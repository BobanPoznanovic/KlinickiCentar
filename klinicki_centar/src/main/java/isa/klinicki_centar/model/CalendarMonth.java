package isa.klinicki_centar.model;

import java.util.ArrayList;

public class CalendarMonth {
	
	private int month;
	
	private int year;
	
	private ArrayList<CalendarDay> days;
	
	public CalendarMonth() {
		
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<CalendarDay> getDays() {
		return days;
	}

	public void setDays(ArrayList<CalendarDay> days) {
		this.days = days;
	}

}
