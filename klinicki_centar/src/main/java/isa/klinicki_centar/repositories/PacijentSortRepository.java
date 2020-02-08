package isa.klinicki_centar.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.dto.PacijentDTO;

public interface PacijentSortRepository extends PagingAndSortingRepository<Pacijent, Integer> {

}
