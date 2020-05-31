package isa.klinicki_centar.services;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.repository.query.Param;

import isa.klinicki_centar.model.Klinika;

public interface KlinikaService {

	Iterable<Klinika> findAll();
	
	Klinika findOne(Integer id);
	
	Klinika save(Klinika klinika);
	
	Klinika findByNazivOrGrad(String nazivOrGrad);
	
	void remove(Integer id);
	
	//ArrayList<Klinika> nadjiKlinikePoTipuPregledaIDatumu(Integer tipPregledaID, Date datum);
	
	ArrayList<Klinika> nadjiKlinikePoTipuPregleda(Integer tipPregledaID);
	
	ArrayList<Klinika> nadjiKlinikePoTipuPregledaIOceni(Integer tipPregledaID, float ocena);
	
	ArrayList<Klinika> nadjiKlinikePoTipuPregledaIGradu(Integer tipPregledaID, String grad);
	
	ArrayList<Klinika> nadjiKlinikePoTipuPregledaGraduIOceni(Integer tipPregledaID, String grad, float ocena);
	
}
