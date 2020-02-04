package isa.klinicki_centar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.klinicki_centar.model.AdminKlinickogCentra;
import isa.klinicki_centar.model.Dijagnoza;
import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.repositories.DijagnozaRepository;
import isa.klinicki_centar.services.AdminKlinickogCentraService;
import isa.klinicki_centar.services.KlinikaService;

@Controller
@RequestMapping(path="/test")
public class TestController {
	
	@Autowired
	private DijagnozaRepository dijagnozaRepozitory;
	
	@Autowired
	private AdminKlinickogCentraService akcService;
	
	@Autowired
	private KlinikaService klinikaService;

	@GetMapping(path="/dijagnoza")
	public void addDijagnoza() {
		System.out.println("Adding dijagnoza");
		Dijagnoza d = new Dijagnoza();
		d.setNaziv("Moja dijagnoza");
		dijagnozaRepozitory.save(d);
	}
	
	@GetMapping(path="/getKlinike")
	public ResponseEntity<Iterable<Klinika>> klinike() {
		
		Iterable<Klinika> retVal = klinikaService.findAll();
		
		return new ResponseEntity<Iterable<Klinika>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(path="/akc")
	public ResponseEntity<Iterable<AdminKlinickogCentra>> admini() {
		
		AdminKlinickogCentra testAdmin = new AdminKlinickogCentra();
		
		testAdmin.setAdresa("Beograd");
		testAdmin.setEmail("admin@a.com");
		testAdmin.setIme("Admin");
		testAdmin.setIzmenjana_sifra_nakon_prvog_logovanja(false);
		testAdmin.setKontakt_telefon("011 11 11 22");
		testAdmin.setPassword("samosifra");
		testAdmin.setPrezime("Adminic");
		testAdmin.setUsername("admin");
		
		akcService.save(testAdmin);
	
		
		Iterable<AdminKlinickogCentra> retVal = akcService.findAll();
		
		return new ResponseEntity<Iterable<AdminKlinickogCentra>>(retVal, HttpStatus.OK);
	}
}
