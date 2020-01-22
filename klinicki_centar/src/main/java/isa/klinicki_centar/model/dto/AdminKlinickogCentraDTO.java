package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.AdminKlinickogCentra;

public class AdminKlinickogCentraDTO {
	
	private Integer adminID;
	
	private String ime;
	
	private String prezime;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String kontakt_telefon;
	
	private String adresa;
	
	private Boolean izmenjana_sifra_nakon_prvog_logovanja;
	
	public AdminKlinickogCentraDTO() {
		
	}
	
	public AdminKlinickogCentraDTO(AdminKlinickogCentra admin) {
		this(
				admin.getAdminID(),
				admin.getIme(),
				admin.getPrezime(),
				admin.getUsername(),
				admin.getPassword(),
				admin.getEmail(),
				admin.getKontakt_telefon(),
				admin.getAdresa(),
				admin.getIzmenjana_sifra_nakon_prvog_logovanja()
				);
	}
	
	public AdminKlinickogCentraDTO(
			Integer adminID,
			String ime,
			String prezime,
			String username,
			String password,
			String email,
			String kontakt_telefon,
			String adresa,
			Boolean izmenjena_sifra_nakon_prvog_logovanja
			) {
		super();
		this.setAdminID(adminID);
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setKontakt_telefon(kontakt_telefon);
		this.setAdresa(adresa);
		this.setIzmenjana_sifra_nakon_prvog_logovanja(izmenjena_sifra_nakon_prvog_logovanja);
	}

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
