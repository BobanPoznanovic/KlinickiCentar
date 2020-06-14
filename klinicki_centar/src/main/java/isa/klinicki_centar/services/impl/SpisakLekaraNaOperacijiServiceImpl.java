package isa.klinicki_centar.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.SpisakLekaraNaOperaciji;
import isa.klinicki_centar.repositories.SpisakLekaraNaOperacijiRepository;
import isa.klinicki_centar.services.SpisakLekaraNaOperacijiService;

@Service
public class SpisakLekaraNaOperacijiServiceImpl implements SpisakLekaraNaOperacijiService{

	@Autowired
	private SpisakLekaraNaOperacijiRepository spisakLekaraNaOperacijiRepository;

	@Override
	public Iterable<SpisakLekaraNaOperaciji> findAll() {
		// TODO Auto-generated method stub
		return spisakLekaraNaOperacijiRepository.findAll();
	}

	@Override
	public SpisakLekaraNaOperaciji findOne(Integer id) {
		// TODO Auto-generated method stub
		return spisakLekaraNaOperacijiRepository.findById(id).orElseGet(null);
	}

	@Override
	public SpisakLekaraNaOperaciji save(SpisakLekaraNaOperaciji spisak) {
		// TODO Auto-generated method stub
		return spisakLekaraNaOperacijiRepository.save(spisak);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		spisakLekaraNaOperacijiRepository.deleteById(id);
	}

	@Override
	public ArrayList<SpisakLekaraNaOperaciji> findByLekarID(Integer lekarID) {
		// TODO Auto-generated method stub
		return spisakLekaraNaOperacijiRepository.findByLekarID(lekarID);
	}
}
