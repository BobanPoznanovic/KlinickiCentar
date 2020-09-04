package isa.klinicki_centar.service;

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
import isa.klinicki_centar.model.IzvestajPregleda;
import isa.klinicki_centar.repositories.IzvestajPregledaRepository;
import isa.klinicki_centar.services.IzvestajPregledaService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest
public class IzvestajPregledaServiceTest {
	
	@MockBean
	private IzvestajPregledaRepository izvestajRepository;
	
	@Autowired
	private IzvestajPregledaService izvestajService;
	
	@Test
	public void testPronalazakIzvestajaPrekoPregledID() {
		IzvestajPregleda izvestaj = new IzvestajPregleda();
		
		Mockito.when(izvestajRepository.findByPregledID(1)).thenReturn(izvestaj);
	}

}
