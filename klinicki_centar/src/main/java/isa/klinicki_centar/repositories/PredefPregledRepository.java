package isa.klinicki_centar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.PredefPregled;

@Repository
public interface PredefPregledRepository extends JpaRepository<PredefPregled, Integer> {
	
}
