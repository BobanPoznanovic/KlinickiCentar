package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "RECEPT")
public class Recept {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer receptID;
	
	private Integer izvestaj_pregledaID;
	
	private Boolean overen;
	
	public Recept() {
		
	}

	public Integer getReceptID() {
		return receptID;
	}

	public void setReceptID(Integer receptID) {
		this.receptID = receptID;
	}

	public Integer getIzvestaj_pregledaID() {
		return izvestaj_pregledaID;
	}

	public void setIzvestaj_pregledaID(Integer izvestaj_pregledaID) {
		this.izvestaj_pregledaID = izvestaj_pregledaID;
	}

	public Boolean getOveren() {
		return overen;
	}

	public void setOveren(Boolean overen) {
		this.overen = overen;
	}

}
