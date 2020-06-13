package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.model.dto.KlinikaDTO;
import isa.klinicki_centar.services.KlinikaService;
import isa.klinicki_centar.services.OperacijaService;
import isa.klinicki_centar.services.PregledService;

@RestController
@RequestMapping(path = "/klinika")
@CrossOrigin(origins = "*")
public class KlinikaController {
	
	@Autowired
	private KlinikaService klinikaService;
	
	@Autowired
	private PregledService pregledService;
	
	@Autowired
	private OperacijaService operacijaService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<KlinikaDTO>> getAll() {
		
		List<KlinikaDTO> retVaI = new ArrayList<KlinikaDTO>();
		
		Iterable<Klinika> queryResult = klinikaService.findAll();
		
		for(Klinika k : queryResult) {
			retVaI.add(new KlinikaDTO(k));
		}
		
		return new ResponseEntity<>(retVaI, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<KlinikaDTO> getKlinika(@PathVariable Integer id) {
		
		Klinika klinika = klinikaService.findOne(id);
		
		if(klinika == null) {
			return new ResponseEntity<KlinikaDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<KlinikaDTO>(new KlinikaDTO(klinika), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/search/{nazivOrGrad}")
	public ResponseEntity<KlinikaDTO> getKlinikaByNazivOrGrad(@PathVariable String nazivOrGrad) {
		Klinika klinika = klinikaService.findByNazivOrGrad(nazivOrGrad);
		
		if(klinika == null) {
			return new ResponseEntity<KlinikaDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<KlinikaDTO>(new KlinikaDTO(klinika), HttpStatus.OK);
	} 
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<KlinikaDTO> saveKlinika(@RequestBody KlinikaDTO klinikaDTO) {
		
		Klinika klinika = new Klinika();
		
		klinika.setAdresa(klinikaDTO.getAdresa());
		klinika.setNaziv(klinikaDTO.getNaziv());
		klinika.setOpis(klinikaDTO.getOpis());
		
		klinika = klinikaService.save(klinika);
		
		return new ResponseEntity<KlinikaDTO>(new KlinikaDTO(klinika), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<KlinikaDTO> updateKlinika(@RequestBody KlinikaDTO klinikaDTO) {
		
		Klinika klinika = klinikaService.findOne(klinikaDTO.getKlinikaID());
		
		if(klinika == null) {
			return new ResponseEntity<KlinikaDTO>(HttpStatus.BAD_REQUEST);
		}
		
		klinika.setKlinikaID(klinikaDTO.getKlinikaID());
		klinika.setAdresa(klinikaDTO.getAdresa());
		klinika.setNaziv(klinikaDTO.getNaziv());
		klinika.setOpis(klinikaDTO.getOpis());
		
		klinika = klinikaService.save(klinika);
		
		return new ResponseEntity<KlinikaDTO>(new KlinikaDTO(klinika), HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteKlinika(@PathVariable Integer id) {
		
		Klinika klinika = klinikaService.findOne(id);
		
		if (klinika != null) {
			klinikaService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@GetMapping(value = "/search/tipPregleda_datum")
//	@ResponseBody
//	ArrayList<Klinika> nadjiKlinikePoTipuPregledaIDatumu(@RequestParam(name = "tipPregledaID") Integer tipPregledaID, @RequestParam(name = "datum") Date datum) {
//		return klinikaService.nadjiKlinikePoTipuPregledaIDatumu(tipPregledaID, datum);
//	}
	
	@GetMapping(value = "/search/tipPregleda")
	@ResponseBody
	ArrayList<Klinika> nadjiKlinikePoTipuPregleda(@RequestParam(name = "tipPregledaID") Integer tipPregledaID) {
		return klinikaService.nadjiKlinikePoTipuPregleda(tipPregledaID);
	}
	
	@GetMapping(value = "/search/tipPregleda_ocena")
	@ResponseBody
	ArrayList<Klinika> nadjiKlinikePoTipuPregledaIOceni(@RequestParam(name = "tipPregledaID") Integer tipPregledaID, @RequestParam(name = "ocena") float ocena) {
		return klinikaService.nadjiKlinikePoTipuPregledaIOceni(tipPregledaID, ocena);
	}
	
	@GetMapping(value = "/search/tipPregleda_grad")
	@ResponseBody
	ArrayList<Klinika> nadjiKlinikePoTipuPregledaIGradu(@RequestParam(name = "tipPregledaID") Integer tipPregledaID, @RequestParam(name = "grad") String grad) {
		return klinikaService.nadjiKlinikePoTipuPregledaIGradu(tipPregledaID, grad);
	}
	
	@GetMapping(value = "/search/tipPregleda_grad_ocena")
	@ResponseBody
	ArrayList<Klinika> nadjiKlinikePoTipuPregledaGraduIOceni(@RequestParam(name = "tipPregledaID") Integer tipPregledaID, @RequestParam(name = "grad") String grad, @RequestParam(name = "ocena") float ocena) {
		return klinikaService.nadjiKlinikePoTipuPregledaGraduIOceni(tipPregledaID, grad, ocena);
	}
	
	@PutMapping("/oceniKlinikuPregled/{pregledID}/{ocena}/{klinikaID}")
	public void oceniKlinikuPregled(@PathVariable Integer pregledID, @PathVariable Integer ocena, @PathVariable Integer klinikaID) {
		klinikaService.oceniKliniku(klinikaID, ocena);
		pregledService.klinikaOcenjenaZaPregled(pregledID);
	}
	
	@PutMapping("/oceniKlinikuOperacija/{operacijaID}/{ocena}/{klinikaID}")
	public void oceniKlinikuOperacija(@PathVariable Integer operacijaID, @PathVariable Integer ocena, @PathVariable Integer klinikaID) {
		klinikaService.oceniKliniku(klinikaID, ocena);
		operacijaService.klinikaOcenjenaZaOperaciju(operacijaID);
	}
	
	@GetMapping(value = "/sortPoNazivu")
	public ArrayList<Klinika> sortKlinikePoNazivu() {
		return klinikaService.sortKlinikePoNazivu();
	}

	@GetMapping(value = "/sortPoAdresi")
	public ArrayList<Klinika> sortKlinikePoAdresi() {
		return klinikaService.sortKlinikePoAdresi();
	}

	@GetMapping(value = "/sortPoGradu")
	public ArrayList<Klinika> sortKlinikePoGradu() {
		return klinikaService.sortKlinikePoGradu();
	}

	@GetMapping(value = "/sortPoOceni")
	public ArrayList<Klinika> sortKlinikePoOceni() {
		return klinikaService.sortKlinikePoOceni();
	}
	
	@GetMapping("/pretragaKlinika/{tipPregledaID}/{naziv}/{ocena}")
	public ArrayList<Klinika> pretragaKlinika(@PathVariable Integer tipPregledaID, @PathVariable String naziv, @PathVariable float ocena) {
		if(naziv.equals(" ") && ocena == 0.0){
            return klinikaService.nadjiKlinikePoTipuPregleda(tipPregledaID);
        } else if(naziv.equals(" ")) {
            return klinikaService.nadjiKlinikePoTipuPregledaIOceni(tipPregledaID, ocena);
        } else if(ocena == 0.0){
            return klinikaService.nadjiKlinikePoTipuPregledaINazivu(tipPregledaID, naziv);
        } else {
            return klinikaService.nadjiKlinikePoTipuPregledaNazivuIOceni(tipPregledaID, ocena, naziv);
        }	
	}
	
}
