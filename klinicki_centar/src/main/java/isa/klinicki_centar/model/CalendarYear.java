package isa.klinicki_centar.model;

import java.util.ArrayList;

public class CalendarYear {
	
	private int year;
	
	private ArrayList<CalendarMonth> months;
	
	public CalendarYear() {
		setMonths(new ArrayList<CalendarMonth>());
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<CalendarMonth> getMonths() {
		return months;
	}

	public void setMonths(ArrayList<CalendarMonth> months) {
		this.months = months;
	}

}
