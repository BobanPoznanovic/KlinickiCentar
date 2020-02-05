package isa.klinicki_centar.services;

import isa.klinicki_centar.model.ZdravstveniKarton;

public interface ZdravstveniKartonService {

	Iterable<ZdravstveniKarton> findAll();
	
	ZdravstveniKarton findOne(Integer id);
	
	ZdravstveniKarton save(ZdravstveniKarton karton);
	
	void remove(Integer id);
}
