package isa.klinicki_centar.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "ZDRAVSTVENI_KARTON")
public class ZdravstveniKarton {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kartonID;
	
	private Integer pacijentID;
	
	private LocalDate datum_rodjenja;
	
	private float visina_pacijenta;
	
	private float tezine_pacijenta;
	
	private String krvna_grupa;
	
	private String dioptrija;
	
	public ZdravstveniKarton() {
		
	}

	public Integer getKartonID() {
		return kartonID;
	}

	public void setKartonID(Integer kartonID) {
		this.kartonID = kartonID;
	}

	public Integer getPacijentID() {
		return pacijentID;
	}

	public void setPacijentID(Integer pacijentID) {
		this.pacijentID = pacijentID;
	}

	public LocalDate getDatum_rodjenja() {
		return datum_rodjenja;
	}

	public void setDatum_rodjenja(LocalDate datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public float getVisina_pacijenta() {
		return visina_pacijenta;
	}

	public void setVisina_pacijenta(float visina_pacijenta) {
		this.visina_pacijenta = visina_pacijenta;
	}

	public float getTezine_pacijenta() {
		return tezine_pacijenta;
	}

	public void setTezine_pacijenta(float tezine_pacijenta) {
		this.tezine_pacijenta = tezine_pacijenta;
	}

	public String getKrvna_grupa() {
		return krvna_grupa;
	}

	public void setKrvna_grupa(String krvna_grupa) {
		this.krvna_grupa = krvna_grupa;
	}

	public String getDioptrija() {
		return dioptrija;
	}

	public void setDioptrija(String dioptrija) {
		this.dioptrija = dioptrija;
	}
}
