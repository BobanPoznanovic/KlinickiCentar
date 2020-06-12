package isa.klinicki_centar.services;

import java.util.ArrayList;

import isa.klinicki_centar.model.SpisakLekaraNaOperaciji;

public interface SpisakLekaraNaOperacijiService {

	Iterable<SpisakLekaraNaOperaciji> findAll();
	
	SpisakLekaraNaOperaciji findOne(Integer id);
	
	SpisakLekaraNaOperaciji save(SpisakLekaraNaOperaciji spisak);
	
	void remove(Integer id);
	
	ArrayList<SpisakLekaraNaOperaciji> findByLekarID(Integer lekarID);
}
