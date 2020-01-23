package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.MedicinskaSestra;

public class MedicinskaSestraDTO {

	private Integer medicinska_sestraID;
	
	private Integer klinikaID;
	
	private String ime;
	
	private String prezime;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String kontakt_telefon;
	
	private String adresa;
	
	private Boolean izmenjana_sifra_nakon_prvog_logovanja;
	
	public MedicinskaSestraDTO( ) {
		
	}
	
	public MedicinskaSestraDTO(MedicinskaSestra medicinskaSestra) {
		this(
				medicinskaSestra.getMedicinska_sestraID(),
				medicinskaSestra.getKlinikaID(),
				medicinskaSestra.getIme(),
				medicinskaSestra.getPrezime(),
				medicinskaSestra.getUsername(),
				medicinskaSestra.getPassword(),
				medicinskaSestra.getEmail(),
				medicinskaSestra.getKontakt_telefon(),
				medicinskaSestra.getAdresa(),
				medicinskaSestra.getIzmenjana_sifra_nakon_prvog_logovanja()
				);
	}
	
	public MedicinskaSestraDTO(
			Integer medicinska_sestraID,
			Integer klinikaID,
			String ime,
			String prezime,
			String username,
			String password,
			String email,
			String kontakt_telefon,
			String adresa,
			Boolean izmenjana_sifra_nakon_prvog_logovanja
			) {
		super();
		this.setAdresa(adresa);
		this.setEmail(email);
		this.setIme(ime);
		this.setIzmenjana_sifra_nakon_prvog_logovanja(izmenjana_sifra_nakon_prvog_logovanja);
		this.setKlinikaID(klinikaID);
		this.setKontakt_telefon(kontakt_telefon);
		this.setMedicinska_sestraID(medicinska_sestraID);
		this.setPassword(password);
		this.setPrezime(prezime);
		this.setUsername(username);
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

	public Boolean getIzmenjana_sifra_nakon_prvog_logovanja() {
		return izmenjana_sifra_nakon_prvog_logovanja;
	}

	public void setIzmenjana_sifra_nakon_prvog_logovanja(Boolean izmenjana_sifra_nakon_prvog_logovanja) {
		this.izmenjana_sifra_nakon_prvog_logovanja = izmenjana_sifra_nakon_prvog_logovanja;
	}
}
