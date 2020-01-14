package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "SALA")
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer salaID;
	
	private Integer klinikaID;
	
	private String naziv_sale;
	
	private Integer broj_sale;
	
	public Sala() {
		
	}

	public Integer getSalaID() {
		return salaID;
	}

	public void setSalaID(Integer salaID) {
		this.salaID = salaID;
	}

	public Integer getKlinikaID() {
		return klinikaID;
	}

	public void setKlinikaID(Integer klinikaID) {
		this.klinikaID = klinikaID;
	}

	public String getNaziv_sale() {
		return naziv_sale;
	}

	public void setNaziv_sale(String naziv_sale) {
		this.naziv_sale = naziv_sale;
	}

	public Integer getBroj_sale() {
		return broj_sale;
	}

	public void setBroj_sale(Integer broj_sale) {
		this.broj_sale = broj_sale;
	}
}
