package isa.klinicki_centar.model.dto;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import isa.klinicki_centar.model.CalendarDay;
import isa.klinicki_centar.model.CalendarMonth;
import isa.klinicki_centar.services.RadniKalendarService;

public class CalendarMonthDTO {
	
	@Autowired
	private RadniKalendarService radniKalendarService;

	private int month;
	
	private int year;
	
	private ArrayList<CalendarDayDTO> days;
	
	public CalendarMonthDTO() {
		
	}
	
	public CalendarMonthDTO(CalendarMonth month) {
		this(month.getMonth(), month.getYear(), month.getDays());
	}
	
	public CalendarMonthDTO(int month, int year, ArrayList<CalendarDay> days) {
		super();
		this.setMonth(month);
		this.setYear(year);
		this.setDays(radniKalendarService.daysToDTO(days));
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

	public ArrayList<CalendarDayDTO> getDays() {
		return days;
	}

	public void setDays(ArrayList<CalendarDayDTO> days) {
		this.days = days;
	}
}
