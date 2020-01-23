package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.StatusZahtevZaRegistraciju;
import isa.klinicki_centar.model.ZahtevZaRegistraciju;

public class ZahtevZaRegistracijuDTO {

	private Integer zahtevID;
	
	private Integer broj_osiguranika;
	
	private String email;
	
	private String password;
	
	private String ime;
	
	private String prezime;
	
	private String adresa;
	
	private String grad;
	
	private String drzava;
	
	private String broj_telefona;
	
	private String status_zahteva;
	
	private String razlog_odbijanja;
	
	public ZahtevZaRegistracijuDTO() {
		
	}
	
	public ZahtevZaRegistracijuDTO(ZahtevZaRegistraciju zahtev) {
		this(
				zahtev.getZahtevID(),
				zahtev.getBroj_osiguranika(),
				zahtev.getEmail(),
				zahtev.getPassword(),
				zahtev.getIme(),
				zahtev.getPrezime(),
				zahtev.getAdresa(),
				zahtev.getGrad(),
				zahtev.getDrzava(),
				zahtev.getBroj_telefona(),
				zahtev.getStatus_zahteva().name(),
				zahtev.getRazlog_odbijanja());
	}
	
	public ZahtevZaRegistracijuDTO(
			Integer zahtevID,
			Integer broj_osiguranika,
			String email,
			String password,
			String ime,
			String prezime,
			String adresa,
			String grad,
			String drzava,
			String broj_telefona,
			String status_zahteva,
			String razlog_odbijanja
			) {
		super();
		this.setAdresa(adresa);
		this.setBroj_osiguranika(broj_osiguranika);
		this.setBroj_telefona(broj_telefona);
		this.setDrzava(drzava);
		this.setEmail(email);
		this.setGrad(grad);
		this.setIme(ime);
		this.setPassword(password);
		this.setPrezime(prezime);
		this.setRazlog_odbijanja(razlog_odbijanja);
		this.setStatus_zahteva(status_zahteva);
		this.setZahtevID(zahtevID);
	}

	public Integer getZahtevID() {
		return zahtevID;
	}

	public void setZahtevID(Integer zahtevID) {
		this.zahtevID = zahtevID;
	}

	public Integer getBroj_osiguranika() {
		return broj_osiguranika;
	}

	public void setBroj_osiguranika(Integer broj_osiguranika) {
		this.broj_osiguranika = broj_osiguranika;
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

	public String getBroj_telefona() {
		return broj_telefona;
	}

	public void setBroj_telefona(String broj_telefona) {
		this.broj_telefona = broj_telefona;
	}

	public String getStatus_zahteva() {
		return status_zahteva;
	}

	public void setStatus_zahteva(String status_zahteva) {
		this.status_zahteva = status_zahteva;
	}

	public String getRazlog_odbijanja() {
		return razlog_odbijanja;
	}

	public void setRazlog_odbijanja(String razlog_odbijanja) {
		this.razlog_odbijanja = razlog_odbijanja;
	}
}
