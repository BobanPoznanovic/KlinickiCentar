package isa.klinicki_centar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

}
