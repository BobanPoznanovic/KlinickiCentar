package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "CENOVNIK_KLINIKE")
public class CenovnikKlinike {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cenovnik_klinikeID;
	
	private Integer klinikaID;
	
	private Integer tip_pregledaID;
	
	public CenovnikKlinike() {
		
	}

	public Integer getCenovnik_klinikeID() {
		return cenovnik_klinikeID;
	}

	public void setCenovnik_klinikeID(Integer cenovnik_klinikeID) {
		this.cenovnik_klinikeID = cenovnik_klinikeID;
	}

	public Integer getKlinikaID() {
		return klinikaID;
	}

	public void setKlinikaID(Integer klinikaID) {
		this.klinikaID = klinikaID;
	}

	public Integer getTip_pregledaID() {
		return tip_pregledaID;
	}

	public void setTip_pregledaID(Integer tip_pregledaID) {
		this.tip_pregledaID = tip_pregledaID;
	}

}
