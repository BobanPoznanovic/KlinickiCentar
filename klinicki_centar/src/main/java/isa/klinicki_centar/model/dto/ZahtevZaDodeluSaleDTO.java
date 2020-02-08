package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.ZahtevZaDodeluSale;

public class ZahtevZaDodeluSaleDTO {

	private Integer zahtevID;
	
	private Integer operacijaID;
	
	private Integer salaID;
	
	private String datum_kreiranja_zahteva;
	
	private String vreme_kreiranja_zahteva;
	
	private String status_zahteva;
	
	public ZahtevZaDodeluSaleDTO() {
		
	}
	
	public ZahtevZaDodeluSaleDTO(ZahtevZaDodeluSale zahtev) {
		this(
				zahtev.getZahtevID(), zahtev.getOperacijaID(), zahtev.getSalaID(), zahtev.getDatum_kreiranja_zahteva().toString(),
				zahtev.getVreme_kreiranja_zahteva().toString(), zahtev.getStatus_zahteva().name()
				);
	}
	
	public ZahtevZaDodeluSaleDTO(
			Integer zahtevID, Integer operacijaID, Integer salaID, String datum_kreiranja_zahteva, 
			String vreme_kreiranja_zahteva, String status_zahteva
			) {
		super();
		this.setDatum_kreiranja_zahteva(datum_kreiranja_zahteva);
		this.setSalaID(salaID);
		this.setStatus_zahteva(status_zahteva);
		this.setVreme_kreiranja_zahteva(vreme_kreiranja_zahteva);
		this.setOperacijaID(operacijaID);
		this.setZahtevID(zahtevID);
	}

	public Integer getZahtevID() {
		return zahtevID;
	}

	public void setZahtevID(Integer zahtevID) {
		this.zahtevID = zahtevID;
	}

	public Integer getSalaID() {
		return salaID;
	}

	public void setSalaID(Integer salaID) {
		this.salaID = salaID;
	}

	public String getDatum_kreiranja_zahteva() {
		return datum_kreiranja_zahteva;
	}

	public void setDatum_kreiranja_zahteva(String datum_kreiranja_zahteva) {
		this.datum_kreiranja_zahteva = datum_kreiranja_zahteva;
	}

	public String getVreme_kreiranja_zahteva() {
		return vreme_kreiranja_zahteva;
	}

	public void setVreme_kreiranja_zahteva(String vreme_kreiranja_zahteva) {
		this.vreme_kreiranja_zahteva = vreme_kreiranja_zahteva;
	}

	public String getStatus_zahteva() {
		return status_zahteva;
	}

	public void setStatus_zahteva(String status_zahteva) {
		this.status_zahteva = status_zahteva;
	}

	public Integer getOperacijaID() {
		return operacijaID;
	}

	public void setOperacijaID(Integer operacijaID) {
		this.operacijaID = operacijaID;
	}

	
}
