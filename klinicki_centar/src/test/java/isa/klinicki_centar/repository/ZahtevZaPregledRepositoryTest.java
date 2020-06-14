package isa.klinicki_centar.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

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
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.model.ZahtevZaPregled;
import isa.klinicki_centar.repositories.ZahtevZaPregledRepository;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class ZahtevZaPregledRepositoryTest {

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
	
	@Autowired
    private ZahtevZaPregledRepository zahtevZaPregledRepository;

    @Test
    @Transactional
    @Rollback(true)
    public void testSaveZahtev() throws ParseException {
        TipPregleda tip = new TipPregleda(NOVI_TIP, NOVA_CENA);

        Date datum = new SimpleDateFormat("yyyy-MM-dd").parse(DATUM);

        Klinika klinika = new Klinika(KLINIKA_ID, NOVA_KLINIKA, NOVA_KLINIKA_ADRESA, NOVA_KLINIKA_GRAD, NOVA_KLINIKA_OPIS, NOVA_KLINIKA_PROSECNA_OCENA, NOVA_KLINIKA_BROJ_OCENA);
        Lekar lekar = new Lekar("Milos", "Ivanovic");
        lekar.setLekarID(10);

        Pacijent pacijent = new Pacijent("Ivana", "Stojkovic");
        pacijent.setPacijentID(5);
        
        LocalTime pocetak = LocalTime.parse(SATNICA_POCETAK);
        LocalTime kraj = LocalTime.parse(SATNICA_KRAJ);

        ZahtevZaPregled zahtev = new ZahtevZaPregled(klinika.getKlinikaID(), pacijent.getPacijentID(), datum, pocetak, kraj, lekar.getLekarID(), tip.getTip_pregledaID());
        //zahtev.setZahtevID(6);

        ZahtevZaPregled sacuvanZahtev = this.zahtevZaPregledRepository.save(zahtev);

        ZahtevZaPregled testZahtev = zahtevZaPregledRepository.getOne(sacuvanZahtev.getZahtevID());

        assertNotNull(testZahtev);
        Integer lekarID = 5;
        assertEquals(lekarID, testZahtev.getLekarID());
    }
	
}
