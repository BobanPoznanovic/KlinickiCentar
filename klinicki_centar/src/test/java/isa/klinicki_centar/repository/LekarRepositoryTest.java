package isa.klinicki_centar.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import isa.klinicki_centar.KlinickiCentarApplication;
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.repositories.LekarRepository;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class LekarRepositoryTest {

	@Autowired
    private LekarRepository lekarRepository;

    @Test
    public void testNadjiLekareZaTipPregledaIDatum(){
        ArrayList<Lekar> lekari = lekarRepository.nadjiLekareZaTipPregledaIDatum(1, 1, "2020-06-19");
        assertEquals(1, lekari.size());
    }

    @Test
    public void testDoctorsThatCanDoExam1(){
    	ArrayList<Lekar> lekari = lekarRepository.nadjiLekareZaTipPregledaIDatum(1, 3, "2020-06-19");
        assertEquals(3, lekari.size());
    }

    @Test
    public void testGetSveLekare(){
        ArrayList<Lekar> lekari = (ArrayList<Lekar>) lekarRepository.findAll();
        assertEquals(7, lekari.size());
    }
	
}
