package isa.klinicki_centar.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import isa.klinicki_centar.KlinickiCentarApplication;
import isa.klinicki_centar.controllers.IzvestajPregledaController;
import isa.klinicki_centar.model.IzvestajPregleda;
import isa.klinicki_centar.services.IzvestajPregledaService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IzvestajPregledaControllerTest {
	
	private static final String URL_SEARCH = "/pregled/izvestaj/pregledID/1";
	
	private MockMvc mockMvc;
	
	@Mock
	private IzvestajPregledaService izvestajService;
	
	@InjectMocks
	private IzvestajPregledaController izvestajController;
	
	@Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(izvestajController)
                .build();
    }
	
	@Test
	public void testNadjiIzvestajZaPregledID() throws Exception {
		
		IzvestajPregleda izvestaj = new IzvestajPregleda();
		
		izvestaj.setDijagnozaID(0);
		izvestaj.setIzvestaj_pregledaID(567);
		izvestaj.setOpis_pregleda("Sve okej");
		izvestaj.setPregledID(1);
		
		when(izvestajService.getIzvestajByPregledID(1)).thenReturn(izvestaj);
		
		mockMvc.perform(get(URL_SEARCH))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.izvestaj_pregledaID", Matchers.is(567)))
			.andExpect(jsonPath("$.pregledID", Matchers.is(1)));
		
		verify(izvestajService, times(1)).getIzvestajByPregledID(1);
		
	}

}
