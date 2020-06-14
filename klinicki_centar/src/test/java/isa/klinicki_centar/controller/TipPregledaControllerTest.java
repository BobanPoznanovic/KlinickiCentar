package isa.klinicki_centar.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
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
import isa.klinicki_centar.controllers.TipPregledaController;
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.services.TipPregledaService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TipPregledaControllerTest {

	private static final String SVI_TIPOVI = "/tipPregleda/all";


    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Mock
    private TipPregledaService tipPregledaService;

    @InjectMocks
    private TipPregledaController tipPregledaController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tipPregledaController).build();
    }

    @Test
    public void testGetAll() throws Exception {
    	ArrayList<TipPregleda> tipovi = new ArrayList<>();
    	tipovi.add(new TipPregleda());
    	tipovi.add(new TipPregleda());
    	tipovi.add(new TipPregleda());

        when(tipPregledaService.findAll()).thenReturn(tipovi);

        mockMvc.perform(get(SVI_TIPOVI))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));

        verify(tipPregledaService, times(1)).findAll();
    }
	
}
