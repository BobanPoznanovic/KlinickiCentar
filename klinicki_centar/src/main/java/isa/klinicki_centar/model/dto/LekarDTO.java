package isa.klinicki_centar.model.dto;

import java.time.LocalTime;

import isa.klinicki_centar.model.Lekar;

public class LekarDTO {

	private Integer lekarID;
	
//	private Integer specijalizacijaID;
	
	private Integer klinikaID;
	
	private String ime;
	
	private String prezime;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String kontakt_telefon;
	
	private String adresa;
	
	private LocalTime pocetak_radnog_vremena;
	
	private LocalTime kraj_radnog_vremena;
		
	private float prosecna_ocena;
	
	private Integer broj_ocena;
	
	private Boolean izmenjena_sifra_nakon_prvog_logovanja;
	
	public LekarDTO() {
		
	}
	
	public LekarDTO(Lekar lekar) {
		this(
				lekar.getLekarID(),  
				lekar.getKlinikaID(), lekar.getIme(), lekar.getPrezime(),
				lekar.getUsername(), lekar.getPassword(), lekar.getEmail(), lekar.getKontakt_telefon(), lekar.getAdresa(),
				lekar.getPocetak_radnog_vremena(), lekar.getKraj_radnog_vremena(), 
				lekar.getProsecna_ocena(), lekar.getBroj_ocena(), lekar.getIzmenjena_sifra_nakon_prvog_logovanja()
				);
	}
	
	public LekarDTO(
			Integer lekarID,  Integer klinikaID, String ime, String prezime, String username, String password,
			String email, String kontakt_telefon, String adresa, LocalTime pocetak_radnog_vremena, LocalTime kraj_radnog_vremena, 
			float prosecnaOcena, Integer brojOcena, Boolean izmenjena_sifra_nakon_prvog_logovanja
			) {
		super();
		this.setLekarID(lekarID);
//		this.setSpecijalizacijaID(specijalizacijaID);
		this.setKlinikaID(klinikaID);
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setKontakt_telefon(kontakt_telefon);
		this.setAdresa(adresa);
		this.setPocetak_radnog_vremena(pocetak_radnog_vremena);
		this.setKraj_radnog_vremena(kraj_radnog_vremena);
		this.setProsecna_ocena(prosecnaOcena);
		this.setBroj_ocena(brojOcena);
		this.setIzmenjena_sifra_nakon_prvog_logovanja(izmenjena_sifra_nakon_prvog_logovanja);
	}

	public Integer getLekarID() {
		return lekarID;
	}

	public void setLekarID(Integer lekarID) {
		this.lekarID = lekarID;
	}

//	public Integer getSpecijalizacijaID() {
//		return specijalizacijaID;
//	}
//
//	public void setSpecijalizacijaID(Integer specijalizacijaID) {
//		this.specijalizacijaID = specijalizacijaID;
//	}

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

	public LocalTime getPocetak_radnog_vremena() {
		return pocetak_radnog_vremena;
	}

	public void setPocetak_radnog_vremena(LocalTime pocetak_radnog_vremena) {
		this.pocetak_radnog_vremena = pocetak_radnog_vremena;
	}

	public LocalTime getKraj_radnog_vremena() {
		return kraj_radnog_vremena;
	}

	public void setKraj_radnog_vremena(LocalTime kraj_radnog_vremena) {
		this.kraj_radnog_vremena = kraj_radnog_vremena;
	}

	public float getProsecna_ocena() {
		return prosecna_ocena;
	}

	public void setProsecna_ocena(float prosecna_ocena) {
		this.prosecna_ocena = prosecna_ocena;
	}

	public Integer getBroj_ocena() {
		return broj_ocena;
	}

	public void setBroj_ocena(Integer broj_ocena) {
		this.broj_ocena = broj_ocena;
	}

	public Boolean getIzmenjena_sifra_nakon_prvog_logovanja() {
		return izmenjena_sifra_nakon_prvog_logovanja;
	}

	public void setIzmenjena_sifra_nakon_prvog_logovanja(Boolean izmenjena_sifra_nakon_prvog_logovanja) {
		this.izmenjena_sifra_nakon_prvog_logovanja = izmenjena_sifra_nakon_prvog_logovanja;
	}
}
