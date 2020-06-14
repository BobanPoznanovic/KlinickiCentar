package isa.klinicki_centar.controller;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import isa.klinicki_centar.KlinickiCentarApplication;
import isa.klinicki_centar.controllers.LekarController;
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.services.LekarService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LekarControllerTest {
	
	private static final String URL_LEKARI = "/lekar/search/lekariZaPregled/1/1/2020_06_14";
	private static final String URL_LEKARI2 = "/lekar/search/lekariZaPregled/1/4/2020_06_14";
	
	private MockMvc mockMvc;
	
	@Mock
	private LekarService lekarService;
	
	@InjectMocks
	private LekarController lekarController;
	
	@Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(lekarController)
                .build();
    }
	
	
	@Test
    public void testNadjiLekareZaTipPregledaIDatum() throws Exception {

        ArrayList<Lekar> lekari = new ArrayList<>();
        Lekar lekar = new Lekar();
        lekar.setLekarID(8);
        lekar.setIme("Milos");
        lekar.setPrezime("Ivanovic");
        lekar.setAdresa("Ulica 1, Novi Sad, Srbija");
        lekari.add(lekar);

        when(lekarService.nadjiLekareZaTipPregledaIDatum(1, 1, "2020_06_14")).thenReturn(lekari);

        mockMvc.perform(get(URL_LEKARI))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[*].ime").value(hasItem("Milos")))
                .andExpect(jsonPath("$.[*].prezime").value(hasItem("Ivanovic")))
                .andExpect(jsonPath("$.[*].adresa").value(hasItem("Ulica 1, Novi Sad, Srbija")));

        verify(lekarService, times(1)).nadjiLekareZaTipPregledaIDatum(1, 1, "2020_06_14");

    }
	
	@Test
    public void testNadjiLekareZaTipPregledaIDatum_2() throws Exception {

		ArrayList<Lekar> lekari = new ArrayList<>();

		Lekar lekar = new Lekar();
        lekar.setLekarID(9);
        lekar.setIme("Milos");
        lekar.setPrezime("Ivanovic");
        lekar.setAdresa("Ulica 1, Novi Sad, Srbija");

        Lekar lekar2 = new Lekar();
        lekar.setLekarID(10);
        lekar.setIme("Dejan");
        lekar.setPrezime("Lukic");
        lekar.setAdresa("Ulica 2, Novi Sad, Srbija");

        Lekar lekar3 = new Lekar();
        lekar.setLekarID(11);
        lekar.setIme("Konstantin");
        lekar.setPrezime("Bajic");
        lekar.setAdresa("Ulica 3, Novi Sad, Srbija");

        lekari.add(lekar);
        lekari.add(lekar2);
        lekari.add(lekar3);

        when(lekarService.nadjiLekareZaTipPregledaIDatum(1, 4, "2020_06_14")).thenReturn(lekari);

        mockMvc.perform(get(URL_LEKARI2))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));

        verify(lekarService, times(1)).nadjiLekareZaTipPregledaIDatum(1, 4, "2020_06_14");

    }
	
	
	
	
	
	

}
