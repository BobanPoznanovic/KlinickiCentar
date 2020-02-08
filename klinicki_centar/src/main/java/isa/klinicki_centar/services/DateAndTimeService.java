package isa.klinicki_centar.services;

import java.time.LocalTime;
import java.util.List;

import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;

public interface DateAndTimeService {

	Boolean checkOverlapping(List<Operacija> listaOperacija, List<Pregled> listaPregleda, Operacija operacija);
	
	Boolean checkIfOverlaps(Operacija novaOperacija, Operacija staraOperacija);
	
	Boolean checkIfOverlaps(Operacija operacija, Pregled pregled);
	
	Boolean checkIfOverlaps(LocalTime eventAStart, LocalTime eventAEnd, LocalTime eventBStart, LocalTime eventBEnd);
}
