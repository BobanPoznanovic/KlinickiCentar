package isa.klinicki_centar.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import isa.klinicki_centar.controllers.KlinikaController;
import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.services.KlinikaService;


@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = KlinickiCentarApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KlinikaControllerTest {
	
	private static final String URL_SEARCH_KLINIKE = "/klinika/all";
    private static final String URL_SEARCH_KLINIKE2 = "/klinika/pretragaKlinika/1/Klinika1/0";

    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    
    @Mock
    private KlinikaService klinikaService;
    
    @InjectMocks
    private KlinikaController klinikaController;
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(klinikaController)
                .build();
    }
    
    @Test
    public void testGetSveKlinike() throws Exception {
        List<Klinika> klinike = new ArrayList<>();
        klinike.add(new Klinika());
        klinike.add(new Klinika());
        klinike.add(new Klinika());
        klinike.add(new Klinika());

        when(klinikaService.findAll()).thenReturn(klinike);


        mockMvc.perform(get(URL_SEARCH_KLINIKE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4)));

        verify(klinikaService, times(1)).findAll();

    }

    @Test
    public void testPretragaKlinika() throws Exception {
        ArrayList<Klinika> klinike = new ArrayList<>();
        klinike.add(new Klinika());

        when(klinikaService.nadjiKlinikePoTipuPregledaNazivuIOceni(1, (float) 0.0, "Klinika1")).thenReturn(klinike);


        mockMvc.perform(get(URL_SEARCH_KLINIKE2))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(klinikaService, times(1)).nadjiKlinikePoTipuPregledaNazivuIOceni(1, (float) 0.0, "Klinika1" );

    }
    
}
