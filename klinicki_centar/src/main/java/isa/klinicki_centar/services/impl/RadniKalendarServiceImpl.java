package isa.klinicki_centar.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.CalendarEvent;
import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.services.PregledService;
import isa.klinicki_centar.services.RadniKalendarService;

@Service
public class RadniKalendarServiceImpl implements RadniKalendarService {
	
	@Autowired
	private PregledService pregledService;

	@Override
	public CalendarEvent fromPregled(Pregled pregled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarEvent fromOperacija(Operacija operacija) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findMinimum(ArrayList<Pregled> lista) {
		// TODO Auto-generated method stub
		Pregled min = lista.get(0);
		int retVal = 0;
		int index = 0;
		
		for(Pregled p : lista) {
			if((min.getSatnica_pocetak().compareTo(p.getSatnica_pocetak()))>0) {
				min = p;
				retVal = index;
			}
			index++;
		}
		
		return retVal;
	}

	@Override
	public Date convertStringToDate(String datum) {
		// TODO Auto-generated method stub
		Date retVal = null;
		
		String[] datumDelovi = datum.split("-");
		String mojDatum = datumDelovi[0]+"/"+datumDelovi[1]+"/"+datumDelovi[2];
		
		try {
			retVal = new SimpleDateFormat("yyyy/MM/dd").parse(mojDatum);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return retVal;
	}

	@Override
	public ArrayList<Date> datesInWeek(Date date) {
		// TODO Auto-generated method stub
ArrayList<Date> retVal = new ArrayList<Date>();
		
		Calendar cal = Calendar.getInstance(new Locale("uk","UA"));
		
		cal.setTime(date);
		
		int initDayInWeek = cal.get(Calendar.DAY_OF_WEEK);
		int toStartOfTheWeek = 0;
		
		if(initDayInWeek != 1)
			toStartOfTheWeek = initDayInWeek - 1;
		
		toStartOfTheWeek *= -1;
		
		cal.add(Calendar.DATE, toStartOfTheWeek);
		
		Date sunday = cal.getTime();
		retVal.add(sunday);
		
		for(int i = 0; i < 6; i++) {
			cal.add(Calendar.DATE, 1);
			Date temp_date = cal.getTime();
			retVal.add(temp_date);
		}
		
		for(Date d : retVal) {
			System.out.println(d);
		}
		
		return retVal;
	}

	@Override
	public ArrayList<Pregled> populateDay(Integer lekarID, Date datum) {
		// TODO Auto-generated method stub
		ArrayList<Pregled> retVal = new ArrayList<Pregled>();
		
		try {
			retVal = pregledService.sviDoktoroviPreglediTrazenogDatuma(lekarID, datum);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return retVal;
	}

	@Override
	public ArrayList<Pregled> sortPregledi(ArrayList<Pregled> pregledi) {
		// TODO Auto-generated method stub
		ArrayList<Pregled> retVal = new ArrayList<Pregled>();
		
		int brojPregleda = pregledi.size();
		int retIntex;
		
		while(retVal.size()<brojPregleda) {
			retIntex = findMinimum(pregledi);
			retVal.add(pregledi.get(retIntex));
			pregledi.remove(retIntex);
		}
		
		return retVal;
	}

	@Override
	public ArrayList<CalendarEvent> preglediToEvents(ArrayList<Pregled> pregledi) {
		// TODO Auto-generated method stub
		ArrayList<CalendarEvent> retVal = new ArrayList<CalendarEvent>();
		
		for(Pregled p : pregledi) {
			CalendarEvent e = new CalendarEvent(p);
			retVal.add(e);
		}
		
		return retVal;
	}

	@Override
	public int getMonth(Date date) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance(new Locale("uk","UA"));
		
		cal.setTime(date);
		
		return cal.get(Calendar.MONTH);
	}

	@Override
	public int getYear(Date date) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance(new Locale("uk","UA"));
		
		cal.setTime(date);
		
		return cal.get(Calendar.YEAR);
	}

}
