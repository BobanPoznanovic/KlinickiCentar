package isa.klinicki_centar.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import isa.klinicki_centar.KlinickiCentarApplication;
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.repositories.TipPregledaRepository;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class TipPregledaRepositoryTest {

	public static final int BROJ_TIPOVA = 11;
    public static final String FIRST_TYPE_NAME = "Opsti pregled";
	
	@Autowired
    private TipPregledaRepository tipPregledaRepository;

    @Test
    public void testGetAll(){
        ArrayList<TipPregleda> tipovi = (ArrayList<TipPregleda>) tipPregledaRepository.findAll();
        assertEquals(BROJ_TIPOVA, tipovi.size());

        for (TipPregleda tp : tipovi) {
            if (tp.getTip_pregledaID() == 1) {
                assertEquals(FIRST_TYPE_NAME, tp.getNaziv());
            }
        }
    }
	
}
