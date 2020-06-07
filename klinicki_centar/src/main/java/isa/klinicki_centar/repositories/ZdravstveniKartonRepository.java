package isa.klinicki_centar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.ZdravstveniKarton;

@Repository
public interface ZdravstveniKartonRepository extends JpaRepository<ZdravstveniKarton, Integer> {

	@Query(value = "SELECT * FROM zdravstveni_karton zk WHERE zk.pacijentID = ?1", nativeQuery = true)
	ZdravstveniKarton nadjiPacijentovKarton(Integer pacijentID);
	
}
