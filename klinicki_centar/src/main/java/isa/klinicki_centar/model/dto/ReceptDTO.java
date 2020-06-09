package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.Recept;

public class ReceptDTO {
	
	private Integer receptID;
	
	private Integer izvestaj_pregledaID;
	
	private Boolean overen;
	
	public ReceptDTO() {
		
	}
	
	public ReceptDTO(Recept recept) {
		this(recept.getReceptID(), recept.getIzvestaj_pregledaID(), recept.getOveren());
	}
	
	public ReceptDTO(Integer id, Integer izvestaj_pregledaID, Boolean overen) {
		super();
		this.setReceptID(id);
		this.setIzvestaj_pregledaID(izvestaj_pregledaID);
		this.setOveren(overen);
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
