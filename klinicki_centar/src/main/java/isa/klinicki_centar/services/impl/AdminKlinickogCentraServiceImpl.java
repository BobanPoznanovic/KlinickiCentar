package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.AdminKlinickogCentra;
import isa.klinicki_centar.repositories.AdminKlinickogCentraRepository;
import isa.klinicki_centar.services.AdminKlinickogCentraService;

@Service
public class AdminKlinickogCentraServiceImpl implements AdminKlinickogCentraService {

	@Autowired
	private AdminKlinickogCentraRepository adminKlinickogCentraRepository;
	
	@Override
	public Iterable<AdminKlinickogCentra> findAll() {
		// TODO Auto-generated method stub
		return adminKlinickogCentraRepository.findAll();
	}

	@Override
	public AdminKlinickogCentra save(AdminKlinickogCentra admin) {
		// TODO Auto-generated method stub
		return adminKlinickogCentraRepository.save(admin);
	}

}
