package isa.klinicki_centar.model.dto;

import java.util.ArrayList;

import isa.klinicki_centar.model.CalendarEvent;
import isa.klinicki_centar.model.CalendarWeek;

public class CalendarWeekDTO {

	private ArrayList<CalendarEventDTO> monday;
	
	private ArrayList<CalendarEventDTO> tuesday;
	
	private ArrayList<CalendarEventDTO> wednesday;
	
	private ArrayList<CalendarEventDTO> thursday;
	
	private ArrayList<CalendarEventDTO> friday;
	
	private ArrayList<CalendarEventDTO> saturday;
	
	private ArrayList<CalendarEventDTO> sunday;
	
	private boolean firstWeekInMonth;
	
	private boolean lastWeekInMonth;
	
	private int month;
	
	private int year;
	
	public CalendarWeekDTO() {
		
	}
	
	public CalendarWeekDTO(CalendarWeek week) {
		this(
				dayToDTO(week.getSunday()),
				dayToDTO(week.getMonday()),
				dayToDTO(week.getTuesday()),
				dayToDTO(week.getWednesday()),
				dayToDTO(week.getThursday()),
				dayToDTO(week.getFriday()),
				dayToDTO(week.getSaturday()),
				week.isFirstWeekInMonth(),
				week.isLastWeekInMonth(),
				week.getMonth(),
				week.getYear());
	}
	
	public CalendarWeekDTO(
			ArrayList<CalendarEventDTO> sunday,
			ArrayList<CalendarEventDTO> monday,
			ArrayList<CalendarEventDTO> tuesday,
			ArrayList<CalendarEventDTO> wednesday,
			ArrayList<CalendarEventDTO> thursday,
			ArrayList<CalendarEventDTO> friday,
			ArrayList<CalendarEventDTO> saturday,
			boolean firstWeekInMonth,
			boolean lastWeekInMonth,
			int month,
			int year) {
		super();
		this.setSunday(sunday);
		this.setMonday(monday);
		this.setTuesday(tuesday);
		this.setWednesday(wednesday);
		this.setThursday(thursday);
		this.setFriday(friday);
		this.setSaturday(saturday);
		this.setFirstWeekInMonth(firstWeekInMonth);
		this.setLastWeekInMonth(lastWeekInMonth);
		this.setMonth(month);
		this.setYear(year);		
	}

	public ArrayList<CalendarEventDTO> getMonday() {
		return monday;
	}

	public void setMonday(ArrayList<CalendarEventDTO> monday) {
		this.monday = monday;
	}

	public ArrayList<CalendarEventDTO> getTuesday() {
		return tuesday;
	}

	public void setTuesday(ArrayList<CalendarEventDTO> tuesday) {
		this.tuesday = tuesday;
	}

	public ArrayList<CalendarEventDTO> getWednesday() {
		return wednesday;
	}

	public void setWednesday(ArrayList<CalendarEventDTO> wednesday) {
		this.wednesday = wednesday;
	}

	public ArrayList<CalendarEventDTO> getThursday() {
		return thursday;
	}

	public void setThursday(ArrayList<CalendarEventDTO> thursday) {
		this.thursday = thursday;
	}

	public ArrayList<CalendarEventDTO> getFriday() {
		return friday;
	}

	public void setFriday(ArrayList<CalendarEventDTO> friday) {
		this.friday = friday;
	}

	public ArrayList<CalendarEventDTO> getSaturday() {
		return saturday;
	}

	public void setSaturday(ArrayList<CalendarEventDTO> saturday) {
		this.saturday = saturday;
	}

	public ArrayList<CalendarEventDTO> getSunday() {
		return sunday;
	}

	public void setSunday(ArrayList<CalendarEventDTO> sunday) {
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
	
	public static ArrayList<CalendarEventDTO> dayToDTO(ArrayList<CalendarEvent> day) {
		ArrayList<CalendarEventDTO> retVal = new ArrayList<CalendarEventDTO>();
		
		for(CalendarEvent e : day) {
			retVal.add(new CalendarEventDTO(e));
		}
		
		return retVal;
	}
}
