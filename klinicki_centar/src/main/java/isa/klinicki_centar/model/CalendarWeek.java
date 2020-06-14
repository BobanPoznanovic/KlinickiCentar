package isa.klinicki_centar.model;

import java.util.ArrayList;

public class CalendarWeek {
	
	private ArrayList<CalendarEvent> sunday;
	
	private ArrayList<CalendarEvent> monday;
	
	private ArrayList<CalendarEvent> tuesday;
	
	private ArrayList<CalendarEvent> wednesday;
	
	private ArrayList<CalendarEvent> thursday;
	
	private ArrayList<CalendarEvent> friday;
	
	private ArrayList<CalendarEvent> saturday;
	
	private boolean firstWeekInMonth;
	
	private boolean lastWeekInMonth;
	
	private int month;
	
	private int year;
	
	public CalendarWeek() {
		
	}
	
	public CalendarWeek(
			
			ArrayList<CalendarEvent> sunday,
			ArrayList<CalendarEvent> monday, 
			ArrayList<CalendarEvent> tuesday, 
			ArrayList<CalendarEvent> wednesday, 
			ArrayList<CalendarEvent> thursday,
			ArrayList<CalendarEvent> friday,
			ArrayList<CalendarEvent> saturday,
			int month,
			int year,
			boolean firstWeekInMonth,
			boolean lastWeekInMonth) {
		
	}

	public ArrayList<CalendarEvent> getMonday() {
		return monday;
	}

	public void setMonday(ArrayList<CalendarEvent> monday) {
		this.monday = monday;
	}

	public ArrayList<CalendarEvent> getTuesday() {
		return tuesday;
	}

	public void setTuesday(ArrayList<CalendarEvent> tuesday) {
		this.tuesday = tuesday;
	}

	public ArrayList<CalendarEvent> getWednesday() {
		return wednesday;
	}

	public void setWednesday(ArrayList<CalendarEvent> wednesday) {
		this.wednesday = wednesday;
	}

	public ArrayList<CalendarEvent> getThursday() {
		return thursday;
	}

	public void setThursday(ArrayList<CalendarEvent> thursday) {
		this.thursday = thursday;
	}

	public ArrayList<CalendarEvent> getFriday() {
		return friday;
	}

	public void setFriday(ArrayList<CalendarEvent> friday) {
		this.friday = friday;
	}

	public ArrayList<CalendarEvent> getSaturday() {
		return saturday;
	}

	public void setSaturday(ArrayList<CalendarEvent> saturday) {
		this.saturday = saturday;
	}

	public ArrayList<CalendarEvent> getSunday() {
		return sunday;
	}

	public void setSunday(ArrayList<CalendarEvent> sunday) {
		this.sunday = sunday;
	}

	public boolean isFirstWeekInMonth() {
		return firstWeekInMonth;
	}

	public void setFirstWeekInMonth(boolean firstWeekInMonth) {
		this.firstWeekInMonth = firstWeekInMonth;
	}

	public boolean isLastWeekInMonth() {
		return lastWeekInMonth;
	}

	public void setLastWeekInMonth(boolean lastWeekInMonth) {
		this.lastWeekInMonth = lastWeekInMonth;
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

}
