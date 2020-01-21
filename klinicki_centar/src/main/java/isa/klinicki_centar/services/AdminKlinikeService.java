package isa.klinicki_centar.services;

import isa.klinicki_centar.model.AdminKlinike;

public interface AdminKlinikeService {
	
	Iterable<AdminKlinike> findAll();
	
	AdminKlinike findOne(Integer id);
	
	AdminKlinike save(AdminKlinike admin);
	
	void remove(Integer id);

}
