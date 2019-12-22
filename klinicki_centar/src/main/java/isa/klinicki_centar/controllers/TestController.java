package isa.klinicki_centar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.klinicki_centar.model.Dijagnoza;
import isa.klinicki_centar.repositories.DijagnozaRepository;

@Controller
@RequestMapping(path="/test")
public class TestController {
	
	@Autowired
	private DijagnozaRepository dijagnozaRepozitory;

	@GetMapping(path="/dijagnoza")
	public void addDijagnoza() {
		System.out.println("Adding dijagnoza");
		Dijagnoza d = new Dijagnoza();
		d.setNaziv("Moja dijagnoza");
		dijagnozaRepozitory.save(d);
	}
}
