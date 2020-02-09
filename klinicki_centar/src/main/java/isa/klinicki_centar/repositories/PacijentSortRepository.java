package isa.klinicki_centar.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import isa.klinicki_centar.model.Pacijent;

public interface PacijentSortRepository extends PagingAndSortingRepository<Pacijent, Integer> {

}
