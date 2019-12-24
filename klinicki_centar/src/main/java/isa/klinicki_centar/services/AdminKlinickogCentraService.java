package isa.klinicki_centar.services;

import isa.klinicki_centar.model.AdminKlinickogCentra;

public interface AdminKlinickogCentraService {

	Iterable<AdminKlinickogCentra> findAll();
	
	AdminKlinickogCentra save(AdminKlinickogCentra admin);
}
