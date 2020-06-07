package isa.klinicki_centar.services;

import java.util.ArrayList;
import java.util.Date;

import isa.klinicki_centar.model.ZahtevZaPregled;

public interface ZahtevZaPregledService {

	Iterable<ZahtevZaPregled> findAll();
	
	ZahtevZaPregled findOne(Integer id);
	
	ZahtevZaPregled save(ZahtevZaPregled zahtevZaPregled);
	
	void remove(Integer id);
	
	void posaljiZahtev(Integer tipPregledaID, Date datum, Integer klinikaID, Integer lekarID, Integer pacijentID);
	
	ArrayList<ZahtevZaPregled> nadjiLekaroveZahtevePoDatumu(Integer lekarID, Date datum);
    
	ArrayList<ZahtevZaPregled> nadjiLekaroveZahteveUNekomPeriodu(Integer lekarID, Date pocetak, Date kraj);
	
}
