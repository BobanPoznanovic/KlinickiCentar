package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "IZVESTAJ_PREGLEDA")
public class IzvestajPregleda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer izvestaj_pregledaID;
	
	private Integer pregledID;
	
	private Integer dijagnozaID;
	
	private String opis_pregleda;
	
	public IzvestajPregleda() {
		
	}

	public Integer getIzvestaj_pregledaID() {
		return izvestaj_pregledaID;
	}

	public void setIzvestaj_pregledaID(Integer izvestaj_pregledaID) {
		this.izvestaj_pregledaID = izvestaj_pregledaID;
	}

	public Integer getPregledID() {
		return pregledID;
	}

	public void setPregledID(Integer pregledID) {
		this.pregledID = pregledID;
	}

	public Integer getDijagnozaID() {
		return dijagnozaID;
	}

	public void setDijagnozaID(Integer dijagnozaID) {
		this.dijagnozaID = dijagnozaID;
	}

	public String getOpis_pregleda() {
		return opis_pregleda;
	}

	public void setOpis_pregleda(String opis_pregleda) {
		this.opis_pregleda = opis_pregleda;
	}
}
