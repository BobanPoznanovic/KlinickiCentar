package isa.klinicki_centar.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import isa.klinicki_centar.KlinickiCentarApplication;
import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.repositories.KlinikaRepository;
import isa.klinicki_centar.repositories.PregledRepository;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class PregledRepositoryTest {
	
	public static final int PREDEFINISANIH = 6;
    public static final int LEKAR_ID = 2;
    public static final int PREDEFINISANI_ID = 7;

	@Autowired
    private PregledRepository pregledRepository;
	
	@Autowired
	private KlinikaRepository klinikaRepository;

    @Test
    public void testNadjiSvePredefinisanePreglede() {
        ArrayList<Pregled> predefinisani = pregledRepository.nadjiSvePredefinisanePreglede();
        assertEquals(PREDEFINISANIH, predefinisani.size());

        /*for (Pregled p : predefinisani) {
            if (p.getPregledID().equals(PREDEFINISANI_ID)) {
                assertEquals(LEKAR_ID, p.getLekarID());		// assetEquals ambiguous ?
            }
        }*/
    }

    @Test
    public void testNadjiPredefinisanePregledeKlinike() {
        int klinikaID = 1;

        ArrayList<Pregled> predefinisaniSaKlinike = pregledRepository.nadjiPredefinisanePregledeKlinike(klinikaID);
        assertEquals(2, predefinisaniSaKlinike.size());

        /*for (Pregled p : predefinisaniSaKlinike) {
            if (p.getPregledID().equals(PREDEFINISANI_ID)) {
            	Klinika k = klinikaRepository.getOne(klinikaID);
                assertEquals(klinikaID, k.getKlinikaID());		// assetEquals ambiguous ?
            }
        }*/
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testZakaziPredefinisanPregled() {
        int pregledID = 8;
        Pregled predefinisan = pregledRepository.getOne(pregledID);

        assertEquals(false, predefinisan.getPotvrdjen());

        assertNull(null, predefinisan.getPacijentID());

        predefinisan.setPotvrdjen(true);

        Pacijent pacijent = new Pacijent("Rade", "Jokic");
        pacijent.setPacijentID(5);

        predefinisan.setPacijentID(pacijent.getPacijentID());

        pregledRepository.zakaziPredefinisanPregled(pregledID, pacijent.getPacijentID());

        assertEquals(pacijent.getPacijentID(), predefinisan.getPacijentID());
    }
	
}
