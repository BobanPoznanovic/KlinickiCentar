package isa.klinicki_centar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "KLINIKA")
public class Klinika {
	
	public Klinika() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "klinikaID")
	private Integer klinikaID;
	
	private String naziv;
	
	private String adresa;
	
	private String grad;
	
	private String opis;
	
	private float prosecna_ocena;
	
	private Integer broj_ocena;

	public Integer getKlinikaID() {
		return klinikaID;
	}

	public void setKlinikaID(Integer klinikaID) {
		this.klinikaID = klinikaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public float getProsecnaOcena() {
		return prosecna_ocena;
	}

	public void setProsecnaOcena(float prosecnaOcena) {
		this.prosecna_ocena = prosecnaOcena;
	}

	public Integer getBrojOcena() {
		return broj_ocena;
	}

	public void setBrojOcena(Integer brojOcena) {
		this.broj_ocena = brojOcena;
	}

}
