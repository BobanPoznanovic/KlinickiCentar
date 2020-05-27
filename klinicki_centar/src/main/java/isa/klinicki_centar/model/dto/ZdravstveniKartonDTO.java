package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.ZdravstveniKarton;

public class ZdravstveniKartonDTO {

	private Integer kartonID;
	
	private Integer pacijentID;
	
	private String datum_rodjenja;
	
	private float visina_pacijenta;
	
	private float tezina_pacijenta;
	
	private String krvna_grupa;
	
	private String dioptrija;
	
	public ZdravstveniKartonDTO() {
		
	}
	
	public ZdravstveniKartonDTO(ZdravstveniKarton karton) {
		this(
				karton.getKartonID(), karton.getPacijentID(), karton.getDatum_rodjenja().toString(), karton.getVisina_pacijenta(),
				karton.getTezina_pacijenta(), karton.getKrvna_grupa(), karton.getDioptrija()
				);
	}
	
	public ZdravstveniKartonDTO(
			Integer kartonID, Integer pacijentID, String datum_rodjenja, float visina_pacijenta, float tezina_pacijenta,
			String krvna_grupa, String dioptrija
			) {
		super();
		this.setDatum_rodjenja(datum_rodjenja);
		this.setDioptrija(dioptrija);
		this.setKartonID(kartonID);
		this.setKrvna_grupa(krvna_grupa);
		this.setPacijentID(pacijentID);
		this.setTezina_pacijenta(tezina_pacijenta);
		this.setVisina_pacijenta(visina_pacijenta);
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

	public String getDatum_rodjenja() {
		return datum_rodjenja;
	}

	public void setDatum_rodjenja(String datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public float getVisina_pacijenta() {
		return visina_pacijenta;
	}

	public void setVisina_pacijenta(float visina_pacijenta) {
		this.visina_pacijenta = visina_pacijenta;
	}

	public float getTezina_pacijenta() {
		return tezina_pacijenta;
	}

	public void setTezina_pacijenta(float tezina_pacijenta) {
		this.tezina_pacijenta = tezina_pacijenta;
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
