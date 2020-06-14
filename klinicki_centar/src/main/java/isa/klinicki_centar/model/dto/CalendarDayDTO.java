package isa.klinicki_centar.model.dto;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import isa.klinicki_centar.model.CalendarDay;
import isa.klinicki_centar.model.CalendarEvent;
import isa.klinicki_centar.services.RadniKalendarService;

public class CalendarDayDTO {
	
	@Autowired
	private RadniKalendarService radniKalendarService;

	private Integer day;
	
	private int dayInWeek;
	
	private ArrayList<CalendarEventDTO> events;
	
	public CalendarDayDTO() {
		
	}
	
	public CalendarDayDTO(CalendarDay day) {		
		this(day.getDay(), day.getDayInWeek(), day.getEvents());
	}
	
	public CalendarDayDTO(Integer day, int dayInWeek, ArrayList<CalendarEvent> events) {
		super();
		this.setDay(day);
		this.setDayInWeek(dayInWeek);
		this.setEvents(radniKalendarService.eventsToDTO(events));
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public ArrayList<CalendarEventDTO> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<CalendarEventDTO> events) {
		this.events = events;
	}

	public int getDayInWeek() {
		return dayInWeek;
	}

	public void setDayInWeek(int dayInWeek) {
		this.dayInWeek = dayInWeek;
	}
}
