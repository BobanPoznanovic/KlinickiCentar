package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "SPISAK_LEKARA_NA_OPERACIJI")
public class SpisakLekaraNaOperaciji {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer spisakID;
	
	private Integer operacijaID;
	
	private Integer lekarID;
	
	public SpisakLekaraNaOperaciji() {
		
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
