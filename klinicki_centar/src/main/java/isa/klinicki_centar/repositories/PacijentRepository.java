package isa.klinicki_centar.repositories;

import org.springframework.data.repository.CrudRepository;

import isa.klinicki_centar.model.Pacijent;

public interface PacijentRepository extends CrudRepository<Pacijent, Integer> {

	Pacijent findByEmail(String email);
}
