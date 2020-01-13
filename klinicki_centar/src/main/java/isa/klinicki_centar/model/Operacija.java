package isa.klinicki_centar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "OPERACIJA")
public class Operacija {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer operacijaID;
	
	private Integer lekarID;
	
	
}
