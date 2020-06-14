package isa.klinicki_centar.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.util.ArrayList;
import java.util.List;

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
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.repositories.TipPregledaRepository;
import isa.klinicki_centar.services.TipPregledaService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class TipPregledaServiceTest {

	@MockBean
    private TipPregledaRepository tipPregledaRepository;

    @Autowired
    private TipPregledaService tipPregledaService;

    @Test
    public void testGetAll() {
    	ArrayList<TipPregleda> tipovi = new ArrayList<>();
    	tipovi.add(new TipPregleda());
    	tipovi.add(new TipPregleda());
    	tipovi.add(new TipPregleda());

        Mockito.when(tipPregledaRepository.findAll()).thenReturn(tipovi);

        ArrayList<TipPregleda> medicalExaminationTypes = (ArrayList<TipPregleda>) tipPregledaService.findAll();
        assertEquals(3, medicalExaminationTypes.size());

        verify(tipPregledaRepository, times(1)).findAll();
    }
	
}
