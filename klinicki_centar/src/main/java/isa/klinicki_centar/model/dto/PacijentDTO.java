package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.Pacijent;

public class PacijentDTO {

	private Integer pacijentID;
	
	private Integer broj_osiguranika;
	
	private String email;
	
	private String password;
	
	private String ime;
	
	private String prezime;
	
	private String adresa;
	
	private String grad;
	
	private String drzava;
	
	private String kontakt_telefon;
	
	private Integer zdravstveni_kartonID;
	
	private boolean aktivan;
	
	public PacijentDTO() {
		
	}
	
	public PacijentDTO(Pacijent pacijent) {
		this(
				pacijent.getPacijentID(), pacijent.getBroj_osiguranika(), pacijent.getEmail(), pacijent.getPassword(), pacijent.getIme(), pacijent.getPrezime(),
				pacijent.getAdresa(), pacijent.getGrad(), pacijent.getDrzava(),
				pacijent.getKontakt_telefon(), pacijent.getZdravstveni_kartonID(), pacijent.isAktivan()
				);
	}
	
	public PacijentDTO(
			Integer pacijentID, Integer broj_osiguranika, String email, String password, String ime, String prezime, String adresa, String grad,
			String drzava, String kontakt_telefon, Integer zdravstveni_kartonID, boolean aktivan
			) {
		super();
		this.setAdresa(adresa);
		this.setBroj_osiguranika(broj_osiguranika);
		this.setDrzava(drzava);
		this.setEmail(email);
		this.setGrad(grad);
		this.setIme(ime);
		this.setKontakt_telefon(kontakt_telefon);
		this.setPacijentID(pacijentID);
		this.setPassword(password);
		this.setPrezime(prezime);
		this.setZdravstveni_kartonID(zdravstveni_kartonID);
		this.aktivan = aktivan;
	}

	public Integer getPacijentID() {
		return pacijentID;
	}

	public void setPacijentID(Integer pacijentID) {
		this.pacijentID = pacijentID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
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

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getKontakt_telefon() {
		return kontakt_telefon;
	}

	public void setKontakt_telefon(String kontakt_telefon) {
		this.kontakt_telefon = kontakt_telefon;
	}

	public Integer getZdravstveni_kartonID() {
		return zdravstveni_kartonID;
	}

	public void setZdravstveni_kartonID(Integer zdravstveni_kartonID) {
		this.zdravstveni_kartonID = zdravstveni_kartonID;
	}

	public Integer getBroj_osiguranika() {
		return broj_osiguranika;
	}

	public void setBroj_osiguranika(Integer broj_osiguranika) {
		this.broj_osiguranika = broj_osiguranika;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
}
