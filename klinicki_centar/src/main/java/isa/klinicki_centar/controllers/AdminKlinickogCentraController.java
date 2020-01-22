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

import isa.klinicki_centar.model.AdminKlinickogCentra;
import isa.klinicki_centar.model.dto.AdminKlinickogCentraDTO;
import isa.klinicki_centar.services.AdminKlinickogCentraService;

@Controller
@RequestMapping(path = "/admin/centar")
public class AdminKlinickogCentraController {
	
	@Autowired
	private AdminKlinickogCentraService adminKlinickogCentraService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<AdminKlinickogCentraDTO>> getAll() {
		
		List<AdminKlinickogCentraDTO> retVal = new ArrayList<AdminKlinickogCentraDTO>();
		
		Iterable<AdminKlinickogCentra> admini = adminKlinickogCentraService.findAll();
		
		for(AdminKlinickogCentra admin : admini) {
			retVal.add(new AdminKlinickogCentraDTO(admin));
		}
		
		return new ResponseEntity<List<AdminKlinickogCentraDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdminKlinickogCentraDTO> getAdminKlinickogCentra(@PathVariable Integer id) {
		
		AdminKlinickogCentra queryResult = adminKlinickogCentraService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<AdminKlinickogCentraDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AdminKlinickogCentraDTO>(new AdminKlinickogCentraDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<AdminKlinickogCentraDTO> saveAdminKlinickogCentra(@RequestBody AdminKlinickogCentraDTO admin) {
		
		AdminKlinickogCentra noviAdmin = new AdminKlinickogCentra();
		
		noviAdmin.setAdminID(admin.getAdminID());
		noviAdmin.setIme(admin.getIme());
		noviAdmin.setPrezime(admin.getPrezime());
		noviAdmin.setUsername(admin.getUsername());
		noviAdmin.setPassword(admin.getPassword());
		noviAdmin.setEmail(admin.getEmail());
		noviAdmin.setKontakt_telefon(admin.getKontakt_telefon());
		noviAdmin.setAdresa(admin.getAdresa());
		noviAdmin.setIzmenjana_sifra_nakon_prvog_logovanja(admin.getIzmenjana_sifra_nakon_prvog_logovanja());
		
		noviAdmin = adminKlinickogCentraService.save(noviAdmin);
		
		return new ResponseEntity<AdminKlinickogCentraDTO>(new AdminKlinickogCentraDTO(noviAdmin), HttpStatus.CREATED);		
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<AdminKlinickogCentraDTO> updateAdminKlinickogCentra(@RequestBody AdminKlinickogCentraDTO admin) {
		
		AdminKlinickogCentra queryResult = adminKlinickogCentraService.findOne(admin.getAdminID());
		
		if(queryResult == null) {
			return new ResponseEntity<AdminKlinickogCentraDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setAdminID(admin.getAdminID());
		queryResult.setIme(admin.getIme());
		queryResult.setPrezime(admin.getPrezime());
		queryResult.setUsername(admin.getUsername());
		queryResult.setPassword(admin.getPassword());
		queryResult.setEmail(admin.getEmail());
		queryResult.setKontakt_telefon(admin.getKontakt_telefon());
		queryResult.setAdresa(admin.getAdresa());
		queryResult.setIzmenjana_sifra_nakon_prvog_logovanja(admin.getIzmenjana_sifra_nakon_prvog_logovanja());
		
		queryResult = adminKlinickogCentraService.save(queryResult);
		
		return new ResponseEntity<AdminKlinickogCentraDTO>(new AdminKlinickogCentraDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAdminKlinickogCentra(@PathVariable Integer id) {
		
		AdminKlinickogCentra queryResult = adminKlinickogCentraService.findOne(id);
		
		if(queryResult != null) {
			adminKlinickogCentraService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
