package isa.klinicki_centar.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import isa.klinicki_centar.KlinickiCentarApplication;
import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.repositories.KlinikaRepository;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class KlinikaRepositoryTest {

	@Autowired
    private KlinikaRepository klinikaRepository;

    @Test
    public void testGetSveKlinike() {
        List<Klinika> klinike = klinikaRepository.findAll();
        assertEquals(4, klinike.size());
    }

    @Test
    public void testNadjiKlinikePoTipuPregleda() {
    	ArrayList<Klinika> klinike = klinikaRepository.nadjiKlinikePoTipuPregleda(11);
        assertEquals(4, klinike.size());
    }

    @Test
    public void testNadjiKlinikePoTipuPregledaIOceni() {
    	ArrayList<Klinika> klinike = klinikaRepository.nadjiKlinikePoTipuPregledaIOceni(1, 0);
        assertEquals(0, klinike.size());
    }

    @Test
    public void testNadjiKlinikePoTipuPregledaINazivu() {
    	ArrayList<Klinika> klinike = klinikaRepository.nadjiKlinikePoTipuPregledaINazivu(1, "Klinika1");
        assertEquals(1, klinike.size());
    }

    @Test
    public void testNadjiKlinikePoTipuPregledaNazivuIOceni() {
    	ArrayList<Klinika> klinike = klinikaRepository.nadjiKlinikePoTipuPregledaNazivuIOceni(1,0, "Klinika1");
        assertEquals(0, klinike.size());
    }
	
}
