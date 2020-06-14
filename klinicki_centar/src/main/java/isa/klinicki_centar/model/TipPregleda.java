package isa.klinicki_centar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "TIP_PREGLEDA")
public class TipPregleda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tip_pregledaID")
	private Integer tip_pregledaID;
	
	private String naziv;
	
	private float cena;
	
	public Integer getTip_pregledaID() {
		return tip_pregledaID;
	}

	public void setTip_pregledaID(Integer tip_pregledaID) {
		this.tip_pregledaID = tip_pregledaID;
	}

	public TipPregleda() {
		
	}

	public TipPregleda(String naziv, float cena) {
		this.naziv = naziv;
		this.cena = cena;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}
	
	

}
