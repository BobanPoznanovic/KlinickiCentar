package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "SPECIJALIZACIJA_LEKARA")
public class SpecijalizacijaLekara {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer specijalizacijaID;
	
	private String naziv_specijalizacije;
	
	public SpecijalizacijaLekara() {
		
	}

	public Integer getSpecijalizacijaID() {
		return specijalizacijaID;
	}

	public void setSpecijalizacijaID(Integer specijalizacijaID) {
		this.specijalizacijaID = specijalizacijaID;
	}

	public String getNaziv_specijalizacije() {
		return naziv_specijalizacije;
	}

	public void setNaziv_specijalizacije(String naziv_specijalizacije) {
		this.naziv_specijalizacije = naziv_specijalizacije;
	}
}
