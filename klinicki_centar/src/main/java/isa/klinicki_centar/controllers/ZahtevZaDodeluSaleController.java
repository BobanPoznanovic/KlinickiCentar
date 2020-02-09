package isa.klinicki_centar.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.Sala;
import isa.klinicki_centar.model.StatusZahtevaZaDodeluSale;
import isa.klinicki_centar.model.ZahtevZaDodeluSale;
import isa.klinicki_centar.model.dto.FreeTimeSlots;
import isa.klinicki_centar.model.dto.SimpleEventDTO;
import isa.klinicki_centar.model.dto.ZahtevZaDodeluSaleDTO;
import isa.klinicki_centar.services.DateAndTimeService;
import isa.klinicki_centar.services.OperacijaService;
import isa.klinicki_centar.services.PregledService;
import isa.klinicki_centar.services.SalaService;
import isa.klinicki_centar.services.ZahtevZaDodeluSaleService;

@Controller
@RequestMapping(path = "/zahtev/sala")
public class ZahtevZaDodeluSaleController {
	
	@Autowired
	private ZahtevZaDodeluSaleService zahtevZaDodeluSaleService;
	
	@Autowired
	private OperacijaService operacijaService;
	
	@Autowired
	private PregledService pregledService;
	
	@Autowired
	private DateAndTimeService dateAndTimeService;
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ZahtevZaDodeluSaleDTO>> findAll() {
		
		List<ZahtevZaDodeluSaleDTO> retVal = new ArrayList<ZahtevZaDodeluSaleDTO>();
		
		Iterable<ZahtevZaDodeluSale> queryResult = zahtevZaDodeluSaleService.findAll();
		
		for(ZahtevZaDodeluSale z : queryResult) {
			retVal.add(new ZahtevZaDodeluSaleDTO(z));
		}
		
		return new ResponseEntity<List<ZahtevZaDodeluSaleDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ZahtevZaDodeluSaleDTO> getZahtevZaDodeluSale(@PathVariable Integer id) {
		
		ZahtevZaDodeluSale queryResult = zahtevZaDodeluSaleService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaDodeluSaleDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ZahtevZaDodeluSaleDTO>(new ZahtevZaDodeluSaleDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaDodeluSaleDTO> saveZahtevZaDodeluSale(@RequestBody ZahtevZaDodeluSaleDTO zahtev) {
		
		ZahtevZaDodeluSale noviZahtev = new ZahtevZaDodeluSale();
		
		noviZahtev.setDatum_kreiranja_zahteva(LocalDate.parse(zahtev.getDatum_kreiranja_zahteva()));
		noviZahtev.setSalaID(zahtev.getSalaID());
		noviZahtev.setStatus_zahteva(StatusZahtevaZaDodeluSale.Nije_procesuiran);
		noviZahtev.setVreme_kreiranja_zahteva(LocalTime.parse(zahtev.getVreme_kreiranja_zahteva()));
		noviZahtev.setOperacijaID(zahtev.getOperacijaID());
		noviZahtev.setZahtevID(zahtev.getZahtevID());
		
		noviZahtev = zahtevZaDodeluSaleService.save(noviZahtev);
		
		return new ResponseEntity<ZahtevZaDodeluSaleDTO>(new ZahtevZaDodeluSaleDTO(noviZahtev), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaDodeluSaleDTO> updateZahtevZaDodeluSale(@RequestBody ZahtevZaDodeluSaleDTO zahtev) {
		
		ZahtevZaDodeluSale queryResult = zahtevZaDodeluSaleService.findOne(zahtev.getZahtevID());
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaDodeluSaleDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setDatum_kreiranja_zahteva(LocalDate.parse(zahtev.getDatum_kreiranja_zahteva()));
		queryResult.setSalaID(zahtev.getSalaID());
		for(StatusZahtevaZaDodeluSale status : StatusZahtevaZaDodeluSale.values()) {
			if(status.name().equalsIgnoreCase(zahtev.getStatus_zahteva())) {
				queryResult.setStatus_zahteva(status);
			}
		}
		queryResult.setVreme_kreiranja_zahteva(LocalTime.parse(zahtev.getVreme_kreiranja_zahteva()));
		queryResult.setOperacijaID(zahtev.getOperacijaID());
		queryResult.setZahtevID(zahtev.getZahtevID());
		
		queryResult = zahtevZaDodeluSaleService.save(queryResult);
		
		return new ResponseEntity<ZahtevZaDodeluSaleDTO>(new ZahtevZaDodeluSaleDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteZahtevZaDodeluSale(@PathVariable Integer id) {
		
		ZahtevZaDodeluSale queryResult = zahtevZaDodeluSaleService.findOne(id);
		
		if(queryResult != null) {
			zahtevZaDodeluSaleService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/check/all")
	public ResponseEntity<List<ZahtevZaDodeluSaleDTO>> checkSveZahteve() {
		
		List<ZahtevZaDodeluSaleDTO> retVal = new ArrayList<ZahtevZaDodeluSaleDTO>();
		
		return new ResponseEntity<List<ZahtevZaDodeluSaleDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/check")
	public ResponseEntity<ZahtevZaDodeluSaleDTO> checkSalaAvailability(@RequestBody ZahtevZaDodeluSaleDTO zahtev) {
		
		Operacija operacija = operacijaService.findOne(zahtev.getOperacijaID());
	
		if(operacija == null) {
			return new ResponseEntity<ZahtevZaDodeluSaleDTO>(HttpStatus.NOT_FOUND);
		}
		
		List<Operacija> operacijeByDateAndSalaID = operacijaService.byDateAndSalaID(operacija.getDatum_operacije().toString(), zahtev.getSalaID());
		
		List<Pregled> preglediByDateAndSalaID = pregledService.byDateAndSalaID(operacija.getDatum_operacije().toString(), zahtev.getSalaID());
		
		Boolean overlappingExists = dateAndTimeService.checkOverlapping(operacijeByDateAndSalaID, preglediByDateAndSalaID, operacija);
		
		if(overlappingExists) {
			//ima preklapanja menjaj vreme operacije
			
			if(pronadjiNovuSaluZaOperaciju(operacija, zahtev)) {
				updateZahtevZaDodeluSale(zahtev);
			}
			else {
				//Pronalazenje novog vremena operacije
				//Racunanje slobodnih slotova po salama tokom jednog data (zapoceti pretragu na datum kada je operacija planirana)
				//Ukoliko je slot veci od duzine trajanja operacije, termin operacije se moze promeniti
				//Promeniti datum operacije i ponoviti gorenavedene korake
				
				/*
				1) DateShifter, returns date
				2) For(Sala s : sveSale)
				3) Pronalazenje termina u sali on date, check operacije & pregledi
				4) Da li postoji odgovarajuci slot?
				4.1) Pomeri operaciju
				4.2) Promeni datum (back to DateShifter) 
				*/
				
				long trajanjeOperacije = dateAndTimeService.eventLength(operacija.getSatnica_pocetka_operacije(), operacija.getSatnica_kraja_operacije());
				NoviRasporedZaOperaciju searchResult = null;
				String dateToCheck = operacija.getDatum_operacije().toString();
				
				do {
					searchResult = pronadjiTerminNaDan(dateToCheck, trajanjeOperacije);
					dateToCheck = dateAndTimeService.findNextDay(LocalDate.parse(dateToCheck)).toString();  
				} while (searchResult == null);
				
				//Search result je pocetak novog slota
				//Vrati dateToCheck unazad za jedan dan
				LocalDate noviDatum = LocalDate.parse(dateToCheck).minusDays(1);
				operacija.setDatum_operacije(noviDatum);
				operacija.setSatnica_pocetka_operacije(searchResult.getPocetakOperacije());
				LocalTime noviKrajOperacije = searchResult.getPocetakOperacije().plusMinutes(trajanjeOperacije);
				operacija.setSatnica_kraja_operacije(noviKrajOperacije);
				operacija.setSalaID(searchResult.getSalaID());
				
				operacijaService.save(operacija);
				
				ZahtevZaDodeluSale noviZahtev = new ZahtevZaDodeluSale();
				noviZahtev.setSalaID(searchResult.getSalaID());
				zahtev.setSalaID(searchResult.getSalaID());
				noviZahtev.setStatus_zahteva(StatusZahtevaZaDodeluSale.Algoritam_pomerio);
				zahtev.setStatus_zahteva("Algoritam_pomerio");
				
				zahtevZaDodeluSaleService.save(noviZahtev);
				
				return new ResponseEntity<ZahtevZaDodeluSaleDTO>(zahtev, HttpStatus.OK);
			}
		
			return new ResponseEntity<ZahtevZaDodeluSaleDTO>(zahtev, HttpStatus.BAD_REQUEST);
		}
		else {
			//nema preklapanja, odobri zahtev, zapisi salu u operaciji
			zahtev.setStatus_zahteva("Algoritam_odobrio");
			
			operacija.setSalaID(zahtev.getSalaID());
			operacija = operacijaService.save(operacija);
			
			//mejl, radni kalednar
			
			updateZahtevZaDodeluSale(zahtev);
		}
		
		return new ResponseEntity<ZahtevZaDodeluSaleDTO>(zahtev, HttpStatus.OK);
	}
	
	public Boolean pronadjiNovuSaluZaOperaciju(Operacija operacija, ZahtevZaDodeluSaleDTO zahtev) {
		Iterable<Sala> sveSaleQueryResult = salaService.findAll();
		List<Sala> sveSale = new ArrayList<Sala>();
		for(Sala s : sveSaleQueryResult) {
			if(s.getSalaID() != zahtev.getSalaID()) {
				sveSale.add(s);
			}
		}
		
		for(Sala s : sveSale) {
			List<Operacija> tempOperacije = operacijaService.byDateAndSalaID(operacija.getDatum_operacije().toString(), s.getSalaID());
			List<Pregled> tempPregledi = pregledService.byDateAndSalaID(operacija.getDatum_operacije().toString(), s.getSalaID());
			
			Boolean overlapping = dateAndTimeService.checkOverlapping(tempOperacije, tempPregledi, operacija);
			
			if(!overlapping) {
				zahtev.setStatus_zahteva("Algoritam_odobrio");
				
				operacija.setSalaID(zahtev.getSalaID());
				operacija = operacijaService.save(operacija);
				
				//mejl, radni kalednar
				
				return true;
			}
		}
		
		return false;
	}
	
	public NoviRasporedZaOperaciju pronadjiTerminNaDan(String dateToCheck, long trajanjeOperacije) {
		
		Iterable<Sala> sveSale = salaService.findAll();
		List<Sala> listaSala = new ArrayList<Sala>();
		for(Sala s : sveSale) {
			listaSala.add(s);
		}
		
		if(!listaSala.isEmpty()) {
			for(Sala s : listaSala) {
				List<Operacija> listaOperacija = operacijaService.byDateAndSalaIDSortedByStartTime(dateToCheck, s.getSalaID());
				List<Pregled> listaPregleda = pregledService.byDateAndSalaIDSortedByStartTime(dateToCheck, s.getSalaID());
				
				List<SimpleEventDTO> listaDogadjaja = sortEvents(listaOperacija, listaPregleda);
				
				//Izracunaj slobodne termine
				List<FreeTimeSlots> slobodniTermini = izracunajSlobodneTermine(listaDogadjaja);
				List<Long> duzinaSlobodnihTermina = izracunajTrajanjeSlobodnihTermina(slobodniTermini);
				
				for(int i = 0; i < duzinaSlobodnihTermina.size(); i++) {
					if(trajanjeOperacije < duzinaSlobodnihTermina.get(i)) {
						return new NoviRasporedZaOperaciju(s.getSalaID(), LocalTime.parse(slobodniTermini.get(i).getStartTime()));
					}
				}
				
 			}
		}
		
		return null;		
	}
	
	public List<SimpleEventDTO> sortEvents(List<Operacija> operacije, List<Pregled> pregledi) {
		
		List<SimpleEventDTO> retVal = new ArrayList<SimpleEventDTO>();
		List<SimpleEventDTO> temp = new ArrayList<SimpleEventDTO>();
		
		for(Operacija o : operacije) {
			temp.add(new SimpleEventDTO(o));
		}
		
		for(Pregled p : pregledi) {
			temp.add(new SimpleEventDTO(p));
		}
		
		int list_size = temp.size();
		
		if(temp.isEmpty())
			return retVal;
		
		while (retVal.size() < list_size) {
			IndexAndSimpleEvent result = findFirstInSchedule(temp);
			retVal.add(result.getEvent());
			temp.remove(result.getIndex());
		}
		
		return retVal;
	}
	
	public IndexAndSimpleEvent findFirstInSchedule(List<SimpleEventDTO> lista) {
		
		IndexAndSimpleEvent retVal = null;
		SimpleEventDTO min = lista.get(0);
		
		for(int i = 1; i < lista.size(); i++) {
			SimpleEventDTO event = lista.get(i);
			LocalTime minTime = LocalTime.parse(min.getStartTime());
			LocalTime checkTime = LocalTime.parse(event.getStartTime());
			
			if(checkTime.isBefore(minTime)) {
				min = event;
				retVal = new IndexAndSimpleEvent(i, min);
			}
		}
		
		return retVal;
	}
	
	public List<FreeTimeSlots> izracunajSlobodneTermine(List<SimpleEventDTO> listaDogadjaja) {
		
		List<FreeTimeSlots> retVal = new ArrayList<FreeTimeSlots>();
		LocalTime startOfFirstEvent = LocalTime.parse(listaDogadjaja.get(0).getStartTime());
		LocalTime endOfLastEvent = LocalTime.parse(listaDogadjaja.get(listaDogadjaja.size()).getEndTime());
		
		if(startOfFirstEvent.compareTo(LocalTime.parse("07:00")) > 0 ) {
			//dodaj
			retVal.add(new FreeTimeSlots(LocalTime.parse("07:00"), startOfFirstEvent));
		}
		
		//prodji kroz listu
		for(int i = 0; i <= listaDogadjaja.size()-2; i++) {
			retVal.add(new FreeTimeSlots(listaDogadjaja.get(i).getEndTime(), listaDogadjaja.get(i+1).getStartTime()));
		}
		
		if(endOfLastEvent.compareTo(LocalTime.parse("17:00")) < 0) {
			//dodaj
			retVal.add(new FreeTimeSlots(endOfLastEvent, LocalTime.parse("17:00")));
		}
		
		return retVal;
	}
	
	public List<Long> izracunajTrajanjeSlobodnihTermina(List<FreeTimeSlots> slobodniTermini) {
		
		List<Long> retVal = new ArrayList<Long>();
		
		for(FreeTimeSlots f : slobodniTermini) {
			retVal.add(dateAndTimeService.eventLength(LocalTime.parse(f.getStartTime()), LocalTime.parse(f.getEndTime())));
		}
		
		return null;
	}
	
	final class IndexAndSimpleEvent {
		private final int index;
		private final SimpleEventDTO event;
		
		public IndexAndSimpleEvent(int index, SimpleEventDTO event) {
			this.index = index;
			this.event = event;
		}
		
		public int getIndex() {
			return index;
		}
		
		public SimpleEventDTO getEvent() {
			return event;
		}
	}

	final class NoviRasporedZaOperaciju {
		private final Integer salaID;
		private final LocalTime pocetakOperacije;
		
		public NoviRasporedZaOperaciju(Integer salaID, LocalTime pocetakOperacije) {
			this.salaID = salaID;
			this.pocetakOperacije = pocetakOperacije;
		}
		
		public Integer getSalaID() {
			return salaID;
		}
		
		public LocalTime getPocetakOperacije() {
			return pocetakOperacije;
		}
	}
}
