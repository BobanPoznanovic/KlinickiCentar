package isa.klinicki_centar.model;

import java.util.ArrayList;

public class CalendarDay {
	
	private Integer day;
	
	private int dayInWeek;
	
	private ArrayList<CalendarEvent> events;

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public ArrayList<CalendarEvent> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<CalendarEvent> events) {
		this.events = events;
	}

	public int getDayInWeek() {
		return dayInWeek;
	}

	public void setDayInWeek(int dayInWeek) {
		this.dayInWeek = dayInWeek;
	}

}
