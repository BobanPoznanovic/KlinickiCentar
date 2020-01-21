package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.AdminKlinike;
import isa.klinicki_centar.repositories.AdminKlinikeRepository;
import isa.klinicki_centar.services.AdminKlinikeService;

@Service
public class AdminKlinikeServiceImpl implements AdminKlinikeService{
	
	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;

	@Override
	public Iterable<AdminKlinike> findAll() {
		// TODO Auto-generated method stub
		return adminKlinikeRepository.findAll();
	}

	@Override
	public AdminKlinike findOne(Integer id) {
		// TODO Auto-generated method stub
		return adminKlinikeRepository.findById(id).orElseGet(null);
	}

	@Override
	public AdminKlinike save(AdminKlinike admin) {
		// TODO Auto-generated method stub
		return adminKlinikeRepository.save(admin);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		adminKlinikeRepository.deleteById(id);
	}

}
