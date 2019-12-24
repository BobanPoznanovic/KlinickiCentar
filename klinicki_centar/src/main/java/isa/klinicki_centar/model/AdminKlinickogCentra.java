package isa.klinicki_centar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "ADMIN_KLINICKOG_CENTRA")
public class AdminKlinickogCentra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name = "adminID")
	private Integer adminID;
	
	//@Column(name = "ime")
	private String ime;
	
	//@Column(name = "prezime")
	private String prezime;
	
	//@Column(name = "username")
	private String username;
	
	//@Column(name = "password")
	private String password;
	
	//@Column(name = "email")
	private String email;
	
	//@Column(name = "kontakt_telefon")
	private String kontakt_telefon;
	
	//@Column(name = "adresa")
	private String adresa;
	
	//@Column(name = "izmenjana_sifra_nakon_prvog_logovanja")
	private Boolean izmenjana_sifra_nakon_prvog_logovanja;

	public Integer getAdminID() {
		return adminID;
	}

	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
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

	public Boolean getIzmenjana_sifra_nakon_prvog_logovanja() {
		return izmenjana_sifra_nakon_prvog_logovanja;
	}

	public void setIzmenjana_sifra_nakon_prvog_logovanja(Boolean izmenjana_sifra_nakon_prvog_logovanja) {
		this.izmenjana_sifra_nakon_prvog_logovanja = izmenjana_sifra_nakon_prvog_logovanja;
	}
	
}
