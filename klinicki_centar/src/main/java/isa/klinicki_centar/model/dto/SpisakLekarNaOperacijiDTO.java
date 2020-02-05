package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.SpisakLekaraNaOperaciji;

public class SpisakLekarNaOperacijiDTO {

	private Integer spisakID;
	
	private Integer operacijaID;
	
	private Integer lekarID;
	
	public SpisakLekarNaOperacijiDTO() {
		
	}
	
	public SpisakLekarNaOperacijiDTO(SpisakLekaraNaOperaciji spisak) {
		this(
				spisak.getSpisakID(), spisak.getOperacijaID(), spisak.getLekarID()
				);
	}
	
	public SpisakLekarNaOperacijiDTO(
			Integer spisakID, Integer operacijaID, Integer lekarID
			) {
		super();
		this.setLekarID(lekarID);
		this.setOperacijaID(operacijaID);
		this.setSpisakID(spisakID);
	}

	public Integer getSpisakID() {
		return spisakID;
	}

	public void setSpisakID(Integer spisakID) {
		this.spisakID = spisakID;
	}

	public Integer getOperacijaID() {
		return operacijaID;
	}

	public void setOperacijaID(Integer operacijaID) {
		this.operacijaID = operacijaID;
	}

	public Integer getLekarID() {
		return lekarID;
	}

	public void setLekarID(Integer lekarID) {
		this.lekarID = lekarID;
	}
}
