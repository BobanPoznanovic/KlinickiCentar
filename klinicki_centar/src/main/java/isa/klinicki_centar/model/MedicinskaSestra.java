package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "MEDICINSKA_SESTRA")
public class MedicinskaSestra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer medicinska_sestraID;
	
	private Integer klinikaID;
	
	private String ime;
	
	private String prezime;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String kontakt_telefon;
	
	private String adresa;
	
	private Boolean izmenjena_sifra_nakon_prvog_logovanja;
	
	public MedicinskaSestra() {
		
	}

	public Integer getMedicinska_sestraID() {
		return medicinska_sestraID;
	}

	public void setMedicinska_sestraID(Integer medicinska_sestraID) {
		this.medicinska_sestraID = medicinska_sestraID;
	}

	public Integer getKlinikaID() {
		return klinikaID;
	}

	public void setKlinikaID(Integer klinikaID) {
		this.klinikaID = klinikaID;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKontakt_telefon() {
		return kontakt_telefon;
	}

	public void setKontakt_telefon(String kontakt_telefon) {
		this.kontakt_telefon = kontakt_telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Boolean getIzmenjena_sifra_nakon_prvog_logovanja() {
		return izmenjena_sifra_nakon_prvog_logovanja;
	}

	public void setIzmenjena_sifra_nakon_prvog_logovanja(Boolean izmenjena_sifra_nakon_prvog_logovanja) {
		this.izmenjena_sifra_nakon_prvog_logovanja = izmenjena_sifra_nakon_prvog_logovanja;
	}

}
