package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "LEK")
public class Lek {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer lekID;
	
	private String naziv;
	
	private String proizvodjac;
	
	private String doza;

	public Lek() {
		
	}

	public Integer getLekID() {
		return lekID;
	}

	public void setLekID(Integer lekID) {
		this.lekID = lekID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public String getDoza() {
		return doza;
	}

	public void setDoza(String doza) {
		this.doza = doza;
	}
}
