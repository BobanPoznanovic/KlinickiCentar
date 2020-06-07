package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.Pregled;

public class PregledDTO {
	
	private Integer pregledID;
	
	private String kategorija_pregleda;
	
	private Integer lekarID;
	
	private Integer pacijentID;
	
	private Integer salaID;
	
	private String datum_pregleda;
	
	private String satnica_pocetak;
	
	private String satnica_kraj;
	
	private Integer tip_pregledaID;
	
	private float popust;
	
	private Boolean zakazan_dodatan_pregled;
	
	private Boolean zakazana_operacija;
	
	private Boolean potvrdjen;
	
	private Boolean zavrsen;
	
	private Boolean doktor_ocenjen;
	
	private Boolean klinika_ocenjena;
	
	public PregledDTO() {
		
	}
	
	public PregledDTO(Pregled pregled) {
		this(
				pregled.getPregledID(), pregled.getKategorija_pregleda().name(), pregled.getLekarID(), pregled.getPacijentID(),
				pregled.getSalaID(), pregled.getDatum_pregleda().toString(), pregled.getSatnica_pocetak().toString(),
				pregled.getSatnica_kraj().toString(), pregled.getTip_pregledaID(), pregled.getPopust(),
				pregled.getZakazan_dodatan_pregled(), pregled.getZakazana_operacija(),
				pregled.getPotvrdjen(), pregled.getZavrsen(), pregled.getDoktor_ocenjen(), pregled.getKlinika_ocenjena()
				);
	}
	
	public PregledDTO(
			Integer pregledID, String kategorija_pregleda, Integer lekarID, Integer pacijentID, Integer salaID,
			String datum_pregleda, String satnica_pocetak, String satnica_kraj, 
			Integer tip_pregledaID, float popust, 
			Boolean zakazan_dodatan_pregled, Boolean zakazana_operacija,
			Boolean potvrdjen, Boolean zavrsen, Boolean doktor_ocenjen, Boolean klinika_ocenjena
			) {
		super();
		this.setPregledID(pregledID);
		this.setKategorija_pregleda(kategorija_pregleda);
		this.setLekarID(lekarID);
		this.setPacijentID(pacijentID);
		this.setSalaID(salaID);
		this.setDatum_pregleda(datum_pregleda);
		this.setSatnica_pocetak(satnica_pocetak);
		this.setSatnica_kraj(satnica_kraj);
		this.setTip_pregledaID(tip_pregledaID);
		this.setPopust(popust);
		this.setZakazan_dodatan_pregled(zakazan_dodatan_pregled);
		this.setZakazana_operacija(zakazana_operacija);
		this.setDoktor_ocenjen(doktor_ocenjen);
		this.setKlinika_ocenjena(klinika_ocenjena);
	}

	public Integer getPregledID() {
		return pregledID;
	}

	public void setPregledID(Integer pregledID) {
		this.pregledID = pregledID;
	}

	public String getKategorija_pregleda() {
		return kategorija_pregleda;
	}

	public void setKategorija_pregleda(String kategorija_pregleda) {
		this.kategorija_pregleda = kategorija_pregleda;
	}

	public Integer getLekarID() {
		return lekarID;
	}

	public void setLekarID(Integer lekarID) {
		this.lekarID = lekarID;
	}

	public Integer getPacijentID() {
		return pacijentID;
	}

	public void setPacijentID(Integer pacijentID) {
		this.pacijentID = pacijentID;
	}

	public Integer getSalaID() {
		return salaID;
	}

	public void setSalaID(Integer salaID) {
		this.salaID = salaID;
	}

	public String getDatum_pregleda() {
		return datum_pregleda;
	}

	public void setDatum_pregleda(String datum_pregleda) {
		this.datum_pregleda = datum_pregleda;
	}

	public String getSatnica_pocetak() {
		return satnica_pocetak;
	}

	public void setSatnica_pocetak(String satnica_pocetak) {
		this.satnica_pocetak = satnica_pocetak;
	}

	public String getSatnica_kraj() {
		return satnica_kraj;
	}

	public void setSatnica_kraj(String satnica_kraj) {
		this.satnica_kraj = satnica_kraj;
	}

	public Integer getTip_pregledaID() {
		return tip_pregledaID;
	}

	public void setTip_pregledaID(Integer tip_pregledaID) {
		this.tip_pregledaID = tip_pregledaID;
	}

	public float getPopust() {
		return popust;
	}

	public void setPopust(float popust) {
		this.popust = popust;
	}

	public Boolean getZakazan_dodatan_pregled() {
		return zakazan_dodatan_pregled;
	}

	public void setZakazan_dodatan_pregled(Boolean zakazan_dodatan_pregled) {
		this.zakazan_dodatan_pregled = zakazan_dodatan_pregled;
	}

	public Boolean getZakazana_operacija() {
		return zakazana_operacija;
	}

	public void setZakazana_operacija(Boolean zakazana_operacija) {
		this.zakazana_operacija = zakazana_operacija;
	}

	public Boolean getPotvrdjen() {
		return potvrdjen;
	}

	public void setPotvrdjen(Boolean potvrdjen) {
		this.potvrdjen = potvrdjen;
	}

	public Boolean getZavrsen() {
		return zavrsen;
	}

	public void setZavrsen(Boolean zavrsen) {
		this.zavrsen = zavrsen;
	}

	public Boolean getDoktor_ocenjen() {
		return doktor_ocenjen;
	}

	public void setDoktor_ocenjen(Boolean doktor_ocenjen) {
		this.doktor_ocenjen = doktor_ocenjen;
	}

	public Boolean getKlinika_ocenjena() {
		return klinika_ocenjena;
	}

	public void setKlinika_ocenjena(Boolean klinika_ocenjena) {
		this.klinika_ocenjena = klinika_ocenjena;
	}
}
