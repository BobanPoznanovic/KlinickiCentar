package isa.klinicki_centar.services;

import isa.klinicki_centar.model.AdminKlinickogCentra;

public interface AdminKlinickogCentraService {

	Iterable<AdminKlinickogCentra> findAll();
	
	AdminKlinickogCentra findOne(Integer id);
	
	AdminKlinickogCentra save(AdminKlinickogCentra admin);
	
	void remove(Integer id);
}
