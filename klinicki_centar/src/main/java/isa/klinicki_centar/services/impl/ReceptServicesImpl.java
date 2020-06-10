package isa.klinicki_centar.services.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.IzvestajPregleda;
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.Recept;
import isa.klinicki_centar.repositories.IzvestajPregledaRepository;
import isa.klinicki_centar.repositories.LekarRepository;
import isa.klinicki_centar.repositories.PregledRepository;
import isa.klinicki_centar.repositories.ReceptRepository;
import isa.klinicki_centar.services.IzvestajPregledaService;
import isa.klinicki_centar.services.LekarService;
import isa.klinicki_centar.services.PregledService;
import isa.klinicki_centar.services.ReceptService;

@Service
public class ReceptServicesImpl implements ReceptService {

	@Autowired
	private ReceptRepository receptRepository;
	
	@Autowired
	private LekarService lekarService;
	
	@Autowired
	private PregledService pregledService;
	
	@Autowired
	private IzvestajPregledaService izvestajPregledaService;
	
	@Override
	public Iterable<Recept> findAll() {
		// TODO Auto-generated method stub
		return receptRepository.findAll();
	}

	@Override
	public Recept findOne(Integer id) {
		// TODO Auto-generated method stub
		return receptRepository.findById(id).orElse(null);
	}

	@Override
	public Recept save(Recept recept) {
		// TODO Auto-generated method stub
		return receptRepository.save(recept);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		receptRepository.deleteById(id);
	}

	@Override
	public Iterable<Recept> findByOveren(Boolean status) {
		// TODO Auto-generated method stub
		if(status == true) {
			return receptRepository.findByOveren(true);
		}
		else
			return receptRepository.findByOveren(false);
	}
	
	@Override
	public Iterable<Recept> findAllNeovereniByPregledID(Integer pregledID) {
		// TODO Auto-generated method stub
		
		IzvestajPregleda izvestaj = izvestajPregledaService.getIzvestajByPregledID(pregledID);
		
		ArrayList<Recept> neoverniRecepti = receptRepository.findNeovereniByIzvestajID(izvestaj.getIzvestaj_pregledaID());
		
		return neoverniRecepti;
	}

	@Override
	public Iterable<Recept> findAllNeovereniByKlinika(Integer id) {
		// TODO Auto-generated method stub
		
		ArrayList<Lekar> lekari = lekarService.pretregaLekaraPoKliniciUKojojSeNalazi(id);
		
		ArrayList<Pregled> pregledi = new ArrayList<Pregled>();
		
		for(Lekar lekar : lekari)  {
			ArrayList<Pregled> temp_pregledi = pregledService.sviZavrseniDoktoroviPregledi(lekar.getLekarID());
			
			pregledi.addAll(temp_pregledi);
		}
		
		ArrayList<IzvestajPregleda> izvestaji = izvestajPregledaService.getIzvestajiByPregledID(pregledi);
		
		ArrayList<Recept> neoverniRecepti = new ArrayList<Recept>();
		
		for(IzvestajPregleda izvestaj : izvestaji)
			neoverniRecepti.addAll(receptRepository.findNeovereniByIzvestajID(izvestaj.getIzvestaj_pregledaID()));
		
		return neoverniRecepti;
	}

}
