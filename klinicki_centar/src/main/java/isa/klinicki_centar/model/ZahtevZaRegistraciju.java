package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "ZAHTEV_ZA_REGISTRACIJU")
public class ZahtevZaRegistraciju {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@Enumerated(EnumType.STRING)
	private StatusZahtevZaRegistraciju status_zahteva;
	
	private String razlog_odbijanja;
	
	public ZahtevZaRegistraciju() {
		
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

	public StatusZahtevZaRegistraciju getStatus_zahteva() {
		return status_zahteva;
	}

	public void setStatus_zahteva(StatusZahtevZaRegistraciju status_zahteva) {
		this.status_zahteva = status_zahteva;
	}

	public String getRazlog_odbijanja() {
		return razlog_odbijanja;
	}

	public void setRazlog_odbijanja(String razlog_odbijanja) {
		this.razlog_odbijanja = razlog_odbijanja;
	}
}
