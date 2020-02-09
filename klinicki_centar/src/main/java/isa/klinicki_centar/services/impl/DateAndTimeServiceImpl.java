package isa.klinicki_centar.services.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.services.DateAndTimeService;

@Service
public class DateAndTimeServiceImpl implements DateAndTimeService{

	@Override
	public Boolean checkOverlapping(List<Operacija> listaOperacija, List<Pregled> listaPregleda, Operacija operacija) {
		// TODO Auto-generated method stub
		
		Boolean retVal = false;
		
		for(Operacija o : listaOperacija) {
			if(checkIfOverlaps(operacija, o))
				return true;
		}
		
		for(Pregled p : listaPregleda) {
			if(checkIfOverlaps(operacija, p))
				return true;
		}
		
		return retVal;
	}

	@Override
	public Boolean checkIfOverlaps(Operacija novaOperacija, Operacija staraOperacija) {
		// TODO Auto-generated method stub
		
		return checkIfOverlaps(novaOperacija.getSatnica_pocetka_operacije(), 
				novaOperacija.getSatnica_kraja_operacije(), 
				staraOperacija.getSatnica_pocetka_operacije(), 
				staraOperacija.getSatnica_kraja_operacije());
	}

	@Override
	public Boolean checkIfOverlaps(LocalTime eventAStart, LocalTime eventAEnd, LocalTime eventBStart,
			LocalTime eventBEnd) {
		// TODO Auto-generated method stub
		
		Boolean retVal = false;
		
		if(eventAStart.compareTo(eventBStart) < 0) {
			if(eventAEnd.compareTo(eventBStart) < 0)
				return false;
			else if(eventAEnd.compareTo(eventBStart) > 0)
				return true;
			else if(eventAEnd.compareTo(eventBEnd) > 0)
				return true;
		}
		else if(eventAStart.compareTo(eventBStart) > 0) {
			if(eventAStart.compareTo(eventBEnd) > 0)
				return false;
			else if(eventAEnd.compareTo(eventBEnd) < 0)
				return true;
			else if(eventAStart.compareTo(eventBEnd) < 0)
				return true;
		}
		else if(eventAStart.compareTo(eventBStart) == 0) {
			return true;
		}
		
		return retVal;
	}

	@Override
	public Boolean checkIfOverlaps(Operacija operacija, Pregled pregled) {
		// TODO Auto-generated method stub
		return checkIfOverlaps(operacija.getSatnica_pocetka_operacije(), 
								operacija.getSatnica_kraja_operacije(), 
								pregled.getSatnica_pocetak(), 
								pregled.getSatnica_kraj());
	}

	@Override
	public long eventLength(LocalTime startTime, LocalTime endTime) {
		// TODO Auto-generated method stub
		return startTime.until(endTime, ChronoUnit.MINUTES);
	}

	@Override
	public LocalDate findNextDay(LocalDate previousDate) {
		// TODO Auto-generated method stub
		return previousDate.plusDays(1);
	}

}
