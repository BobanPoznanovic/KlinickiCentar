package isa.klinicki_centar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "SIFARNIK_DIJAGNOZA")
public class Dijagnoza {
	
	public Dijagnoza() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "dijagnozaID")
	private Integer dijagnozaID;
	
	@Column(name = "naziv")
	private String naziv;
	
	public Integer getDijagnozaID() {
		return dijagnozaID;
	}

	public void setDijagnozaID(Integer dijagnozaID) {
		this.dijagnozaID = dijagnozaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
