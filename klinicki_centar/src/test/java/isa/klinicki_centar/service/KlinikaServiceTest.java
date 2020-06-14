package isa.klinicki_centar.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

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
import isa.klinicki_centar.repositories.KlinikaRepository;
import isa.klinicki_centar.services.KlinikaService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class KlinikaServiceTest {

	@MockBean
    private KlinikaRepository klinikaRepository;

    @Autowired
    private KlinikaService klinikaService;

    @Test
    public void testGetSveKlinike() {
        Klinika klinika1 = new Klinika(1,"KCV", "Futoska", "Novi Sad", "Ovo je lepa klinika", (float) 0.0, 0);
        Klinika klinika2 = new Klinika(2,"Bel Medic", "Viktora Igoa", "Beograd", "Ovo je klinika u Beogradu", (float) 0.0, 0);
        Klinika klinika3 = new Klinika(3,"Nata", "Gospodar Jovanova", "Beograd", "Klinika za sve i svasta", (float) 0.0, 0);
        Klinika klinika4 = new Klinika(4,"Poliklinika Panajotovic", "Dragise Cvetkovica", "Nis", "Poliklinika", (float) 0.0, 0);
        ArrayList<Klinika> klinike = new ArrayList<>();
        klinike.add(klinika1);
        klinike.add(klinika2);
        klinike.add(klinika3);
        klinike.add(klinika4);

        Mockito.when(klinikaRepository.findAll()).thenReturn(klinike);

        ArrayList<Klinika> sveKlinike = (ArrayList<Klinika>) klinikaService.findAll();
        assertEquals(4, sveKlinike.size());

        verify(klinikaRepository,times(1)).findAll();

    }

    @Test
    public void testNadjiKlinikePoTipuPregleda() {
    	Klinika klinika1 = new Klinika(1,"KCV", "Futoska", "Novi Sad", "Ovo je lepa klinika", (float) 0.0, 0);
        Klinika klinika2 = new Klinika(2,"Bel Medic", "Viktora Igoa", "Beograd", "Ovo je klinika u Beogradu", (float) 0.0, 0);
        ArrayList<Klinika> klinike = new ArrayList<Klinika>();
        klinike.add(klinika1);
        klinike.add(klinika2);

        Mockito.when(klinikaRepository.nadjiKlinikePoTipuPregleda(1)).thenReturn(klinike);

        ArrayList<Klinika> pronadjeneKlinike = klinikaService.nadjiKlinikePoTipuPregleda(1);
        assertEquals(2, pronadjeneKlinike.size());

        verify(klinikaRepository,times(1)).nadjiKlinikePoTipuPregleda(1);

    }

    @Test
    public void testNadjiKlinikePoTipuPregledaIOceni() {
    	Klinika klinika1 = new Klinika(1,"KCV", "Futoska", "Novi Sad", "Ovo je lepa klinika", (float) 0.0, 0);
    	ArrayList<Klinika> klinike = new ArrayList<Klinika>();
        klinike.add(klinika1);

        Mockito.when(klinikaRepository.nadjiKlinikePoTipuPregledaIOceni(1, (float) 0.0)).thenReturn(klinike);

        ArrayList<Klinika> pronadjeneKlinike = klinikaService.nadjiKlinikePoTipuPregledaIOceni(1, (float) 0.0);
        assertEquals(1, pronadjeneKlinike.size());

        verify(klinikaRepository,times(1)).nadjiKlinikePoTipuPregledaIOceni(1, (float) 0.0);

    }

    @Test
    public void testNadjiKlinikePoTipuPregledaINazivu() {
    	Klinika klinika1 = new Klinika(2,"Bel Medic", "Viktora Igoa", "Beograd", "Ovo je klinika u Beogradu", (float) 0.0, 0);
    	ArrayList<Klinika> klinike = new ArrayList<Klinika>();
        klinike.add(klinika1);

        Mockito.when(klinikaRepository.nadjiKlinikePoTipuPregledaINazivu(1, "Bel")).thenReturn(klinike);

        ArrayList<Klinika> pronadjeneKlinike = klinikaService.nadjiKlinikePoTipuPregledaINazivu(1, "Bel");
        assertEquals(1, pronadjeneKlinike.size());

        verify(klinikaRepository,times(1)).nadjiKlinikePoTipuPregledaINazivu(1, "Bel");

    }

    @Test
    public void testNadjiKlinikePoTipuPregledaNazivuIOceni() {
    	Klinika klinika1 = new Klinika(2,"Bel Medic", "Viktora Igoa", "Beograd", "Ovo je klinika u Beogradu", (float) 0.0, 0);
    	ArrayList<Klinika> klinike = new ArrayList<Klinika>();
        klinike.add(klinika1);

        Mockito.when(klinikaRepository.nadjiKlinikePoTipuPregledaNazivuIOceni(1, (float) 0.0, "Bel")).thenReturn(klinike);

        ArrayList<Klinika> pronadjeneKlinike = klinikaService.nadjiKlinikePoTipuPregledaNazivuIOceni(1, (float) 0.0, "Bel");
        assertEquals(1, pronadjeneKlinike.size());

        verify(klinikaRepository,times(1)).nadjiKlinikePoTipuPregledaNazivuIOceni(1, (float) 0.0, "Bel");

    }	
	
}
