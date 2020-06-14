package isa.klinicki_centar.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collection;

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
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.repositories.LekarRepository;
import isa.klinicki_centar.services.LekarService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class LekarServiceTest {

	@MockBean
    private LekarRepository lekarRepository;

    @Autowired
    private LekarService lekarService;

    @Test
    public void testDoctorsThatCanDoExam() {

        ArrayList<Lekar> lekari = new ArrayList<>();
        lekari.add(new Lekar());

        Mockito.when(lekarRepository.nadjiLekareZaTipPregledaIDatum(1, 4, "2020-06-19")).thenReturn(lekari);

        ArrayList<Lekar> lekari2 = lekarService.nadjiLekareZaTipPregledaIDatum(1, 4, "2020-06-19");
        assertEquals(1, lekari2.size());

        verify(lekarRepository,times(1)).nadjiLekareZaTipPregledaIDatum(1, 4, "2020-06-19");

    }
	
}
