package isa.klinicki_centar.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import isa.klinicki_centar.KlinickiCentarApplication;
import isa.klinicki_centar.model.KategorijaPregleda;
import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.Sala;
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.repositories.PregledRepository;
import isa.klinicki_centar.services.PregledService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class PregledServiceTest {

	public static final String TEST_DATE = "2020-06-22";
	public static final String SATNICA_POCETAK = "13:00";
    public static final String SATNICA_KRAJ = "13:29";
	
	@MockBean
    private PregledRepository pregledRepository;

    @Autowired
    private PregledService pregledService;

    @Test
    public void testNadjiSvePredefinisanePreglede() {
    	ArrayList<Pregled> predefinisani = new ArrayList<>();
    	predefinisani.add(new Pregled());

        Mockito.when(pregledRepository.nadjiSvePredefinisanePreglede()).thenReturn(predefinisani);

        ArrayList<Pregled> sviPredefinisani = pregledService.nadjiSvePredefinisanePreglede();
        assertEquals(1, sviPredefinisani.size());

        verify(pregledRepository, times(1)).nadjiSvePredefinisanePreglede();

    }

    @Test
    public void testNadjiPredefinisanePregledeKlinike() {
        Integer klinikaID = 1; 

        ArrayList<Pregled> predefinisani = new ArrayList<>();
    	predefinisani.add(new Pregled());

        Mockito.when(pregledRepository.nadjiPredefinisanePregledeKlinike(klinikaID)).thenReturn(predefinisani);

        ArrayList<Pregled> predefinisaniNaKlinici = pregledService.nadjiPredefinisanePregledeKlinike(klinikaID);
        assertEquals(1, predefinisaniNaKlinici.size());

        verify(pregledRepository, times(1)).nadjiPredefinisanePregledeKlinike(klinikaID);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testZakaziPredefinisanPregled() throws ParseException {

    	ArrayList<Pregled> predefinisani = new ArrayList<>();

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(TEST_DATE);
        Klinika klinika = new Klinika();
        klinika.setKlinikaID(1);

        Sala sala = new Sala();
        sala.setSalaID(1);

        Lekar lekar = new Lekar();
        lekar.setLekarID(1);

        TipPregleda tipPregleda = new TipPregleda();
        tipPregleda.setTip_pregledaID(1);

        Pacijent pacijent = new Pacijent();
        pacijent.setPacijentID(1);
        
        LocalTime pocetak = LocalTime.parse(SATNICA_POCETAK);
        LocalTime kraj = LocalTime.parse(SATNICA_KRAJ);

        Pregled noviPregled = new Pregled(KategorijaPregleda.Predefinisan, lekar.getLekarID(), pacijent.getPacijentID(), sala.getSalaID(), date, pocetak, kraj, tipPregleda.getTip_pregledaID(), (float) 200.0);
        noviPregled.setPregledID(12);

        predefinisani.add(noviPregled);

        pregledRepository.zakaziPredefinisanPregled(noviPregled.getPregledID(), pacijent.getPacijentID());

        Mockito.when(pregledRepository.nadjiSvePredefinisanePreglede()).thenReturn(predefinisani);

        ArrayList<Pregled> pregledi = pregledRepository.nadjiSvePredefinisanePreglede();
        assertEquals(1, pregledi.size());

        verify(pregledRepository, times(1)).nadjiSvePredefinisanePreglede();
    }
	
}
