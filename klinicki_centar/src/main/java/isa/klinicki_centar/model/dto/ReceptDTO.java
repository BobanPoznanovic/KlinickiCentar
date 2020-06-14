package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.Recept;

public class ReceptDTO {
	
	private Integer receptID;
	
	private Integer izvestaj_pregledaID;
	
	private Boolean overen;
	
	private Integer lekID;
	
	private String upotreba;
	
	private Integer overila_medicinska_sestraID;
	
	public ReceptDTO() {
		
	}
	
	public ReceptDTO(Recept recept) {
		this(recept.getReceptID(), recept.getIzvestaj_pregledaID(), recept.getOveren(), recept.getLekID(), recept.getUpotreba(), recept.getOverila_medicinska_sestraID());
	}
	
	public ReceptDTO(Integer id, Integer izvestaj_pregledaID, Boolean overen, Integer lekID, String upotreba, Integer overila_medicinska_sestraID) {
		super();
		this.setReceptID(id);
		this.setIzvestaj_pregledaID(izvestaj_pregledaID);
		this.setOveren(overen);
		this.setLekID(lekID);
		this.setUpotreba(upotreba);
		this.setOverila_medicinska_sestraID(overila_medicinska_sestraID);
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

	public Integer getLekID() {
		return lekID;
	}

	public void setLekID(Integer lekID) {
		this.lekID = lekID;
	}

	public String getUpotreba() {
		return upotreba;
	}

	public void setUpotreba(String upotreba) {
		this.upotreba = upotreba;
	}

	public Integer getOverila_medicinska_sestraID() {
		return overila_medicinska_sestraID;
	}

	public void setOverila_medicinska_sestraID(Integer overila_medicinska_sestraID) {
		this.overila_medicinska_sestraID = overila_medicinska_sestraID;
	}

}
