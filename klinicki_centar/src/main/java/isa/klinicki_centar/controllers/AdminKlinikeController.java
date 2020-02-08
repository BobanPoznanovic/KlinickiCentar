package isa.klinicki_centar.controllers;

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

import isa.klinicki_centar.model.AdminKlinike;
import isa.klinicki_centar.model.dto.AdminKlinikeDTO;
import isa.klinicki_centar.services.AdminKlinikeService;

@Controller
@RequestMapping(path="/admin/klinika")
public class AdminKlinikeController {
	
	@Autowired
	private AdminKlinikeService adminKlinikeService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<AdminKlinikeDTO>> getAll() {
		
		List<AdminKlinikeDTO> retVal = new ArrayList<AdminKlinikeDTO>();
		
		Iterable<AdminKlinike> queryResult = adminKlinikeService.findAll();
		
		for(AdminKlinike admin : queryResult) {
			retVal.add(new AdminKlinikeDTO(admin));
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdminKlinikeDTO> getAdminKlinike(@PathVariable Integer id) {
		
		AdminKlinike queryResult = adminKlinikeService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<AdminKlinikeDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AdminKlinikeDTO>(new AdminKlinikeDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<AdminKlinikeDTO> saveAdminKlinike(@RequestBody AdminKlinikeDTO admin) {
		
		AdminKlinike adminKlinike = new AdminKlinike();
		
		adminKlinike.setAdresa(admin.getAdresa());
		adminKlinike.setEmail(admin.getEmail());
		adminKlinike.setIme(admin.getIme());
		adminKlinike.setIzmenjana_sifra_nakon_prvog_logovanja(false);
		adminKlinike.setKlinikaID(admin.getKlinikaID());
		adminKlinike.setKontakt_telefon(admin.getKontakt_telefon());
		adminKlinike.setPassword(admin.getPassword());
		adminKlinike.setPrezime(admin.getPrezime());
		adminKlinike.setUsername(admin.getUsername());
		
		adminKlinike = adminKlinikeService.save(adminKlinike);
		
		return new ResponseEntity<AdminKlinikeDTO>(new AdminKlinikeDTO(adminKlinike), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<AdminKlinikeDTO> updateAdminKlinike(@RequestBody AdminKlinikeDTO admin) {
		
		AdminKlinike adminKlinike = adminKlinikeService.findOne(admin.getAdminID());
		
		if(adminKlinike == null) {
			return new ResponseEntity<AdminKlinikeDTO>(HttpStatus.BAD_REQUEST);
		}
		
		adminKlinike.setAdminID(admin.getAdminID());
		adminKlinike.setAdresa(admin.getAdresa());
		adminKlinike.setEmail(admin.getEmail());
		adminKlinike.setIme(admin.getIme());
		adminKlinike.setIzmenjana_sifra_nakon_prvog_logovanja(admin.getIzmenjana_sifra_nakon_prvog_logovanja());
		adminKlinike.setKlinikaID(admin.getKlinikaID());
		adminKlinike.setKontakt_telefon(admin.getKontakt_telefon());
		adminKlinike.setPassword(admin.getPassword());
		adminKlinike.setPrezime(admin.getPrezime());
		adminKlinike.setUsername(admin.getUsername());
		
		adminKlinike = adminKlinikeService.save(adminKlinike);
		
		return new ResponseEntity<AdminKlinikeDTO>(new AdminKlinikeDTO(adminKlinike), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAdminKlinike(Integer id) {
		
		AdminKlinike adminKlinike = adminKlinikeService.findOne(id);
		
		if(adminKlinike != null) {
			adminKlinikeService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
