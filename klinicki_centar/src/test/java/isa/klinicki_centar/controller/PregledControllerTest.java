package isa.klinicki_centar.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import isa.klinicki_centar.controllers.PregledController;
import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.Sala;
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.services.PregledService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PregledControllerTest {

	private static final String PREDEFINISANI = "/pregled/predefinisaniPregledi";
    private static final String PREDEFINISANI_SA_KLINIKE = "/pregled/predefinisanNaKlinici/1";
    private static final String ZAKAZI_PREDEFINISANI = "/pregled/zakazivanjePredefinisanogPregleda/7/1";

    private MockMvc mockMvc;

    @Mock
    private PregledService pregledService;

    @InjectMocks
    private PregledController pregledController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pregledController).build();
    }

    @Test
    public void testGetSvePredefinisane() throws Exception {
    	ArrayList<Pregled> predefinisaniPregledi = new ArrayList<>();
        Pregled pregled = new Pregled();
        pregled.setPregledID(14);

        Lekar lekar = new Lekar();
        lekar.setLekarID(8);

        Sala sala = new Sala();
        sala.setSalaID(23);

        Pacijent pacijent = new Pacijent();
        pacijent.setPacijentID(4);

        TipPregleda tipPregleda = new TipPregleda();
        tipPregleda.setTip_pregledaID(14);

        pregled.setLekarID(lekar.getLekarID());
        pregled.setSalaID(sala.getSalaID());
        pregled.setPacijentID(pacijent.getPacijentID());
        pregled.setTip_pregledaID(tipPregleda.getTip_pregledaID());

        predefinisaniPregledi.add(pregled);

        when(pregledService.nadjiSvePredefinisanePreglede()).thenReturn(predefinisaniPregledi);

        mockMvc.perform(get(PREDEFINISANI))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(pregledService, times(1)).nadjiSvePredefinisanePreglede();
    }

    @Test
    public void testGetPredefinisaneSaKlinike() throws Exception {
    	ArrayList<Pregled> predefinisaniPreglediSaKlinike = new ArrayList<>();
    	predefinisaniPreglediSaKlinike.add(new Pregled());

        when(pregledService.nadjiPredefinisanePregledeKlinike(1)).thenReturn(predefinisaniPreglediSaKlinike);

        mockMvc.perform(get(PREDEFINISANI_SA_KLINIKE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(pregledService, times(1)).nadjiPredefinisanePregledeKlinike(1);
    }
	
}
