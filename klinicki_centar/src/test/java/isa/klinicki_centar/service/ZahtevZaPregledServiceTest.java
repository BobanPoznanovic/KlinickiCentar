package isa.klinicki_centar.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import isa.klinicki_centar.KlinickiCentarApplication;
import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.model.ZahtevZaPregled;
import isa.klinicki_centar.repositories.ZahtevZaPregledRepository;
import isa.klinicki_centar.services.ZahtevZaPregledService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class ZahtevZaPregledServiceTest {
	
	public static final String NOVI_TIP = "Pregled nosa";
    public static final float NOVA_CENA = 1000.0f;
    public static final String DATUM = "2020-06-22";
    public static final String SATNICA_POCETAK = "13:00";
    public static final String SATNICA_KRAJ = "13:29";
    public static final Integer KLINIKA_ID = 9;
    public static final String NOVA_KLINIKA = "Klinka Bulevar";
    public static final String NOVA_KLINIKA_ADRESA = "Bulevar Oslobodjenja 22";
    public static final String NOVA_KLINIKA_GRAD = "Novi Sad";
    public static final String NOVA_KLINIKA_OPIS = "Opis";
    public static final float NOVA_KLINIKA_PROSECNA_OCENA = 4.0f;
    public static final Integer NOVA_KLINIKA_BROJ_OCENA = 1;
	

	@MockBean
    private ZahtevZaPregledRepository zahtevZaPregledRepository;

    @Autowired
    private ZahtevZaPregledService zahtevZaPregledService;

    @Test
    public void testSaveExaminationRequest() throws ParseException {
    	ArrayList<ZahtevZaPregled> zahtevi = new ArrayList<>();
    	zahtevi.add(new ZahtevZaPregled());
    	zahtevi.add(new ZahtevZaPregled());

        Mockito.when(zahtevZaPregledRepository.findAll()).thenReturn(zahtevi);

        assertEquals(2, zahtevi.size());

        TipPregleda tipPregleda = new TipPregleda(NOVI_TIP, NOVA_CENA);
        tipPregleda.setTip_pregledaID(1);

        Date datum = new SimpleDateFormat("yyyy-MM-dd").parse(DATUM);

        Klinika klinika = new Klinika(KLINIKA_ID, NOVA_KLINIKA, NOVA_KLINIKA_ADRESA, NOVA_KLINIKA_GRAD, NOVA_KLINIKA_OPIS, NOVA_KLINIKA_PROSECNA_OCENA, NOVA_KLINIKA_BROJ_OCENA);
        Lekar lekar = new Lekar();
        lekar.setLekarID(8);

        Pacijent pacijent = new Pacijent();
        pacijent.setPacijentID(4);
        
        LocalTime pocetak = LocalTime.parse(SATNICA_POCETAK);
        LocalTime kraj = LocalTime.parse(SATNICA_KRAJ);

        ZahtevZaPregled noviZahtev = new ZahtevZaPregled(klinika.getKlinikaID(), pacijent.getPacijentID(), datum, pocetak, kraj, lekar.getLekarID(), tipPregleda.getTip_pregledaID());
        noviZahtev.setZahtevID(6);

        this.zahtevZaPregledService.posaljiZahtev(tipPregleda.getTip_pregledaID(), datum, klinika.getKlinikaID(), lekar.getLekarID(), pacijent.getPacijentID());

        ArrayList<ZahtevZaPregled> zahtevi2 = new ArrayList<>();
        zahtevi2.add(new ZahtevZaPregled());
        zahtevi2.add(new ZahtevZaPregled());
        zahtevi2.add(new ZahtevZaPregled());

        Mockito.when(zahtevZaPregledRepository.findAll()).thenReturn(zahtevi2);
        ArrayList<ZahtevZaPregled> mes = (ArrayList<ZahtevZaPregled>) zahtevZaPregledService.findAll();
        assertEquals(3, mes.size());

        verify(zahtevZaPregledRepository, times(1)).findAll();

    }
	
}
