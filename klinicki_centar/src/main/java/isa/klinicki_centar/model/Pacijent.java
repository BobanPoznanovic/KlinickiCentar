package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table( name = "PACIJENT")
public class Pacijent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Version
    private Integer version;
	
	public Pacijent() {
		
	}

	public Pacijent(Integer broj_osiguranika, String email, String password, String ime, String prezime, String adresa,
			String grad, String drzava, String kontakt_telefon) {
		this.broj_osiguranika = broj_osiguranika;
		this.email = email;
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.grad = grad;
		this.drzava = drzava;
		this.kontakt_telefon = kontakt_telefon;
		this.aktivan = false;
	}

	public Integer getPacijentID() {
		return pacijentID;
	}

	public void setPacijentID(Integer pacijentID) {
		this.pacijentID = pacijentID;
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

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
