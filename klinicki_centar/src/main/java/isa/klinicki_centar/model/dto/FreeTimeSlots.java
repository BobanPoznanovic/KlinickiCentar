package isa.klinicki_centar.model.dto;

import java.time.LocalTime;

public class FreeTimeSlots {

	private String startTime;
	
	private String endTime;
	
	public FreeTimeSlots() {
		
	}
	
	public FreeTimeSlots(LocalTime startTime, LocalTime endTime) {
		super();
		this.setStartTime(startTime.toString());
		this.setEndTime(endTime.toString());
	}
	
	public FreeTimeSlots(String startTime, String endTime) {
		super();
		this.setStartTime(startTime);
		this.setEndTime(endTime);
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
