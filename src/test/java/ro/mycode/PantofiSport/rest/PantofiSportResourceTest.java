package ro.mycode.PantofiSport.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ro.mycode.PantofiSport.dto.PantofiSportDTO;
import ro.mycode.PantofiSport.model.PantofiSport;
import ro.mycode.PantofiSport.pantofServices.PantofiSportService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class PantofiSportResourceTest {

    @Mock
    private PantofiSportService pantofiSportService;

    @InjectMocks
    private PantofiSportResource pantofiSportResource;

    private ObjectMapper mapper = new ObjectMapper();

    private MockMvc restMockMvc;

    @BeforeEach
    void initialConfig() {
        restMockMvc = MockMvcBuilders.standaloneSetup(pantofiSportResource).build();
    }

    @Captor
    ArgumentCaptor<PantofiSport> pantofiSportArgumentCaptor;

    @Captor
    ArgumentCaptor<PantofiSportDTO> pantofiSportDTOArgumentCaptor;

    @Test
    void getAllPantofiSport() throws Exception{
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();
        PantofiSport pantofiSport2 = PantofiSport.builder().culoare("Blue").descriere("Wood").gen("F").marime(45).numeProdus("Thymeleaf Bluet").price(916.92).sku("21695-692").stoc(28).build();
        PantofiSport pantofiSport3 = PantofiSport.builder().culoare("Maroon").descriere("Aluminium").gen("F").marime(39).numeProdus("Raffia Palm").price(946.3).sku("24470-900").stoc(46).build();
        PantofiSport pantofiSport4 = PantofiSport.builder().culoare("Blue").descriere("Aluminium").gen("F").marime(38).numeProdus("Western Umbrella-sedge").price(136.33).sku("64525-0545").stoc(44).build();
        PantofiSport pantofiSport5 = PantofiSport.builder().culoare("Crimson").descriere("Aluminium").gen("M").marime(38).numeProdus("Mexican Xanthoparmelia Lichen").price(921.51).sku("61252-3006").stoc(49).build();
        PantofiSport pantofiSport6 = PantofiSport.builder().culoare("Orange").descriere("Aluminium").gen("M").marime(40).numeProdus("Cliff Fern").price(843.25).sku("98132-713").stoc(38).build();
        PantofiSport pantofiSport7 = PantofiSport.builder().culoare("Indigo").descriere("Granite").gen("F").marime(44).numeProdus("Smith''s Melicgrass").price(191.95).sku("0409-7972").stoc(4).build();
        PantofiSport pantofiSport8 = PantofiSport.builder().culoare("Blue").descriere("Granite").gen("F").marime(35).numeProdus("Obtuseleaf Aspen Moss").price(615.89).sku("0944-2948").stoc(30).build();
        PantofiSport pantofiSport9 = PantofiSport.builder().culoare("Puce").descriere("Wood").gen("M").marime(44).numeProdus("Horseweed").price(713.28).sku("0591-2282").stoc(8).build();
        PantofiSport pantofiSport10 = PantofiSport.builder().culoare("Teal").descriere("Wood").gen("M").marime(42).numeProdus("Island Pea").price(951.19).sku("0113-0154").stoc(14).build();

        List<PantofiSport> pantofiSports = new ArrayList<>();
        pantofiSports.add(pantofiSport);
        pantofiSports.add(pantofiSport2);
        pantofiSports.add(pantofiSport3);
        pantofiSports.add(pantofiSport4);
        pantofiSports.add(pantofiSport5);
        pantofiSports.add(pantofiSport6);
        pantofiSports.add(pantofiSport7);
        pantofiSports.add(pantofiSport8);
        pantofiSports.add(pantofiSport9);
        pantofiSports.add(pantofiSport10);

        doReturn(pantofiSports).when(pantofiSportService).gelAllPantofiSport();

        restMockMvc.perform(get("http://localhost:3002/api/v1/pantofiSport/getAllPantofiSport")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(pantofiSports)));

    }

    @Test
    void getPantofiSportByNumeProdus() throws Exception {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();
        PantofiSport pantofiSport2 = PantofiSport.builder().culoare("Blue").descriere("Wood").gen("F").marime(45).numeProdus("Thymeleaf Bluet").price(916.92).sku("21695-692").stoc(28).build();
        PantofiSport pantofiSport3 = PantofiSport.builder().culoare("Maroon").descriere("Aluminium").gen("F").marime(39).numeProdus("Raffia Palm").price(946.3).sku("24470-900").stoc(46).build();
        PantofiSport pantofiSport4 = PantofiSport.builder().culoare("Blue").descriere("Aluminium").gen("F").marime(38).numeProdus("Western Umbrella-sedge").price(136.33).sku("64525-0545").stoc(44).build();
        PantofiSport pantofiSport5 = PantofiSport.builder().culoare("Crimson").descriere("Aluminium").gen("M").marime(38).numeProdus("Mexican Xanthoparmelia Lichen").price(921.51).sku("61252-3006").stoc(49).build();
        PantofiSport pantofiSport6 = PantofiSport.builder().culoare("Orange").descriere("Aluminium").gen("M").marime(40).numeProdus("Cliff Fern").price(843.25).sku("98132-713").stoc(38).build();
        PantofiSport pantofiSport7 = PantofiSport.builder().culoare("Indigo").descriere("Granite").gen("F").marime(44).numeProdus("Smith''s Melicgrass").price(191.95).sku("0409-7972").stoc(4).build();
        PantofiSport pantofiSport8 = PantofiSport.builder().culoare("Blue").descriere("Granite").gen("F").marime(35).numeProdus("Obtuseleaf Aspen Moss").price(615.89).sku("0944-2948").stoc(30).build();
        PantofiSport pantofiSport9 = PantofiSport.builder().culoare("Puce").descriere("Wood").gen("M").marime(44).numeProdus("Horseweed").price(713.28).sku("0591-2282").stoc(8).build();
        PantofiSport pantofiSport10 = PantofiSport.builder().culoare("Teal").descriere("Wood").gen("M").marime(42).numeProdus("Island Pea").price(951.19).sku("0113-0154").stoc(14).build();

        List<PantofiSport> pantofiSports = new ArrayList<>();
        pantofiSports.add(pantofiSport);
        pantofiSports.add(pantofiSport2);
        pantofiSports.add(pantofiSport3);
        pantofiSports.add(pantofiSport4);
        pantofiSports.add(pantofiSport5);
        pantofiSports.add(pantofiSport6);
        pantofiSports.add(pantofiSport7);
        pantofiSports.add(pantofiSport8);
        pantofiSports.add(pantofiSport9);
        pantofiSports.add(pantofiSport10);

        doReturn(pantofiSports).when(pantofiSportService).getPantofiSportByNumeProdus();

        restMockMvc.perform(get("http://localhost:3002/api/v1/pantofiSport/getPantofiSportByNumeProdus")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(pantofiSports)));
    }

    @Test
    void getPantofiSportByPriceA() throws Exception {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();
        PantofiSport pantofiSport2 = PantofiSport.builder().culoare("Blue").descriere("Wood").gen("F").marime(45).numeProdus("Thymeleaf Bluet").price(916.92).sku("21695-692").stoc(28).build();
        PantofiSport pantofiSport3 = PantofiSport.builder().culoare("Maroon").descriere("Aluminium").gen("F").marime(39).numeProdus("Raffia Palm").price(946.3).sku("24470-900").stoc(46).build();
        PantofiSport pantofiSport4 = PantofiSport.builder().culoare("Blue").descriere("Aluminium").gen("F").marime(38).numeProdus("Western Umbrella-sedge").price(136.33).sku("64525-0545").stoc(44).build();
        PantofiSport pantofiSport5 = PantofiSport.builder().culoare("Crimson").descriere("Aluminium").gen("M").marime(38).numeProdus("Mexican Xanthoparmelia Lichen").price(921.51).sku("61252-3006").stoc(49).build();
        PantofiSport pantofiSport6 = PantofiSport.builder().culoare("Orange").descriere("Aluminium").gen("M").marime(40).numeProdus("Cliff Fern").price(843.25).sku("98132-713").stoc(38).build();
        PantofiSport pantofiSport7 = PantofiSport.builder().culoare("Indigo").descriere("Granite").gen("F").marime(44).numeProdus("Smith''s Melicgrass").price(191.95).sku("0409-7972").stoc(4).build();
        PantofiSport pantofiSport8 = PantofiSport.builder().culoare("Blue").descriere("Granite").gen("F").marime(35).numeProdus("Obtuseleaf Aspen Moss").price(615.89).sku("0944-2948").stoc(30).build();
        PantofiSport pantofiSport9 = PantofiSport.builder().culoare("Puce").descriere("Wood").gen("M").marime(44).numeProdus("Horseweed").price(713.28).sku("0591-2282").stoc(8).build();
        PantofiSport pantofiSport10 = PantofiSport.builder().culoare("Teal").descriere("Wood").gen("M").marime(42).numeProdus("Island Pea").price(951.19).sku("0113-0154").stoc(14).build();

        List<PantofiSport> pantofiSports = new ArrayList<>();
        pantofiSports.add(pantofiSport);
        pantofiSports.add(pantofiSport2);
        pantofiSports.add(pantofiSport3);
        pantofiSports.add(pantofiSport4);
        pantofiSports.add(pantofiSport5);
        pantofiSports.add(pantofiSport6);
        pantofiSports.add(pantofiSport7);
        pantofiSports.add(pantofiSport8);
        pantofiSports.add(pantofiSport9);
        pantofiSports.add(pantofiSport10);

        doReturn(pantofiSports).when(pantofiSportService).getPantofiSportByPriceA();

        restMockMvc.perform(get("http://localhost:3002/api/v1/pantofiSport/getPantofiSportByPriceA")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(pantofiSports)));
    }

    @Test
    void getPantofSportByPriceD() throws Exception{
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();
        PantofiSport pantofiSport2 = PantofiSport.builder().culoare("Blue").descriere("Wood").gen("F").marime(45).numeProdus("Thymeleaf Bluet").price(916.92).sku("21695-692").stoc(28).build();
        PantofiSport pantofiSport3 = PantofiSport.builder().culoare("Maroon").descriere("Aluminium").gen("F").marime(39).numeProdus("Raffia Palm").price(946.3).sku("24470-900").stoc(46).build();
        PantofiSport pantofiSport4 = PantofiSport.builder().culoare("Blue").descriere("Aluminium").gen("F").marime(38).numeProdus("Western Umbrella-sedge").price(136.33).sku("64525-0545").stoc(44).build();
        PantofiSport pantofiSport5 = PantofiSport.builder().culoare("Crimson").descriere("Aluminium").gen("M").marime(38).numeProdus("Mexican Xanthoparmelia Lichen").price(921.51).sku("61252-3006").stoc(49).build();
        PantofiSport pantofiSport6 = PantofiSport.builder().culoare("Orange").descriere("Aluminium").gen("M").marime(40).numeProdus("Cliff Fern").price(843.25).sku("98132-713").stoc(38).build();
        PantofiSport pantofiSport7 = PantofiSport.builder().culoare("Indigo").descriere("Granite").gen("F").marime(44).numeProdus("Smith''s Melicgrass").price(191.95).sku("0409-7972").stoc(4).build();
        PantofiSport pantofiSport8 = PantofiSport.builder().culoare("Blue").descriere("Granite").gen("F").marime(35).numeProdus("Obtuseleaf Aspen Moss").price(615.89).sku("0944-2948").stoc(30).build();
        PantofiSport pantofiSport9 = PantofiSport.builder().culoare("Puce").descriere("Wood").gen("M").marime(44).numeProdus("Horseweed").price(713.28).sku("0591-2282").stoc(8).build();
        PantofiSport pantofiSport10 = PantofiSport.builder().culoare("Teal").descriere("Wood").gen("M").marime(42).numeProdus("Island Pea").price(951.19).sku("0113-0154").stoc(14).build();

        List<PantofiSport> pantofiSports = new ArrayList<>();
        pantofiSports.add(pantofiSport);
        pantofiSports.add(pantofiSport2);
        pantofiSports.add(pantofiSport3);
        pantofiSports.add(pantofiSport4);
        pantofiSports.add(pantofiSport5);
        pantofiSports.add(pantofiSport6);
        pantofiSports.add(pantofiSport7);
        pantofiSports.add(pantofiSport8);
        pantofiSports.add(pantofiSport9);
        pantofiSports.add(pantofiSport10);

        doReturn(pantofiSports).when(pantofiSportService).getPantofiSportByPriceD();

        restMockMvc.perform(get("http://localhost:3002/api/v1/pantofiSport/getPantofSportByPriceD")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(pantofiSports)));
    }

    @Test
    void getPantofSportByGenM() throws Exception{
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();
        PantofiSport pantofiSport2 = PantofiSport.builder().culoare("Blue").descriere("Wood").gen("F").marime(45).numeProdus("Thymeleaf Bluet").price(916.92).sku("21695-692").stoc(28).build();
        PantofiSport pantofiSport3 = PantofiSport.builder().culoare("Maroon").descriere("Aluminium").gen("F").marime(39).numeProdus("Raffia Palm").price(946.3).sku("24470-900").stoc(46).build();
        PantofiSport pantofiSport4 = PantofiSport.builder().culoare("Blue").descriere("Aluminium").gen("F").marime(38).numeProdus("Western Umbrella-sedge").price(136.33).sku("64525-0545").stoc(44).build();
        PantofiSport pantofiSport5 = PantofiSport.builder().culoare("Crimson").descriere("Aluminium").gen("M").marime(38).numeProdus("Mexican Xanthoparmelia Lichen").price(921.51).sku("61252-3006").stoc(49).build();
        PantofiSport pantofiSport6 = PantofiSport.builder().culoare("Orange").descriere("Aluminium").gen("M").marime(40).numeProdus("Cliff Fern").price(843.25).sku("98132-713").stoc(38).build();
        PantofiSport pantofiSport7 = PantofiSport.builder().culoare("Indigo").descriere("Granite").gen("F").marime(44).numeProdus("Smith''s Melicgrass").price(191.95).sku("0409-7972").stoc(4).build();
        PantofiSport pantofiSport8 = PantofiSport.builder().culoare("Blue").descriere("Granite").gen("F").marime(35).numeProdus("Obtuseleaf Aspen Moss").price(615.89).sku("0944-2948").stoc(30).build();
        PantofiSport pantofiSport9 = PantofiSport.builder().culoare("Puce").descriere("Wood").gen("M").marime(44).numeProdus("Horseweed").price(713.28).sku("0591-2282").stoc(8).build();
        PantofiSport pantofiSport10 = PantofiSport.builder().culoare("Teal").descriere("Wood").gen("M").marime(42).numeProdus("Island Pea").price(951.19).sku("0113-0154").stoc(14).build();

        List<PantofiSport> pantofiSports = new ArrayList<>();
        pantofiSports.add(pantofiSport);
        pantofiSports.add(pantofiSport2);
        pantofiSports.add(pantofiSport3);
        pantofiSports.add(pantofiSport4);
        pantofiSports.add(pantofiSport5);
        pantofiSports.add(pantofiSport6);
        pantofiSports.add(pantofiSport7);
        pantofiSports.add(pantofiSport8);
        pantofiSports.add(pantofiSport9);
        pantofiSports.add(pantofiSport10);

        doReturn(pantofiSports).when(pantofiSportService).getPantofiSportByGenM();

        restMockMvc.perform(get("http://localhost:3002/api/v1/pantofiSport/getPantofSportByGenM")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(pantofiSports)));

    }

    @Test
    void getPantofSportByGenF() throws Exception{
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();
        PantofiSport pantofiSport2 = PantofiSport.builder().culoare("Blue").descriere("Wood").gen("F").marime(45).numeProdus("Thymeleaf Bluet").price(916.92).sku("21695-692").stoc(28).build();
        PantofiSport pantofiSport3 = PantofiSport.builder().culoare("Maroon").descriere("Aluminium").gen("F").marime(39).numeProdus("Raffia Palm").price(946.3).sku("24470-900").stoc(46).build();
        PantofiSport pantofiSport4 = PantofiSport.builder().culoare("Blue").descriere("Aluminium").gen("F").marime(38).numeProdus("Western Umbrella-sedge").price(136.33).sku("64525-0545").stoc(44).build();
        PantofiSport pantofiSport5 = PantofiSport.builder().culoare("Crimson").descriere("Aluminium").gen("M").marime(38).numeProdus("Mexican Xanthoparmelia Lichen").price(921.51).sku("61252-3006").stoc(49).build();
        PantofiSport pantofiSport6 = PantofiSport.builder().culoare("Orange").descriere("Aluminium").gen("M").marime(40).numeProdus("Cliff Fern").price(843.25).sku("98132-713").stoc(38).build();
        PantofiSport pantofiSport7 = PantofiSport.builder().culoare("Indigo").descriere("Granite").gen("F").marime(44).numeProdus("Smith''s Melicgrass").price(191.95).sku("0409-7972").stoc(4).build();
        PantofiSport pantofiSport8 = PantofiSport.builder().culoare("Blue").descriere("Granite").gen("F").marime(35).numeProdus("Obtuseleaf Aspen Moss").price(615.89).sku("0944-2948").stoc(30).build();
        PantofiSport pantofiSport9 = PantofiSport.builder().culoare("Puce").descriere("Wood").gen("M").marime(44).numeProdus("Horseweed").price(713.28).sku("0591-2282").stoc(8).build();
        PantofiSport pantofiSport10 = PantofiSport.builder().culoare("Teal").descriere("Wood").gen("M").marime(42).numeProdus("Island Pea").price(951.19).sku("0113-0154").stoc(14).build();

        List<PantofiSport> pantofiSports = new ArrayList<>();
        pantofiSports.add(pantofiSport);
        pantofiSports.add(pantofiSport2);
        pantofiSports.add(pantofiSport3);
        pantofiSports.add(pantofiSport4);
        pantofiSports.add(pantofiSport5);
        pantofiSports.add(pantofiSport6);
        pantofiSports.add(pantofiSport7);
        pantofiSports.add(pantofiSport8);
        pantofiSports.add(pantofiSport9);
        pantofiSports.add(pantofiSport10);

        doReturn(pantofiSports).when(pantofiSportService).getPantofiSportByGenF();

        restMockMvc.perform(get("http://localhost:3002/api/v1/pantofiSport/getPantofSportByGenF")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(pantofiSports)));
    }

    @Test
    public void add() throws Exception {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        restMockMvc.perform(post("http://localhost:3002/api/v1/pantofiSport/add")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(mapper.writeValueAsBytes(pantofiSport)))
                .andExpect(status().isCreated())
                .andExpect(content().string(mapper.writeValueAsString(pantofiSport)));

        verify(pantofiSportService, times(1)).addPantofiSport(pantofiSportArgumentCaptor.capture());

        assertEquals(pantofiSport, pantofiSportArgumentCaptor.getValue());

    }

    @Test
    public void remove() throws Exception {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        restMockMvc.perform(delete("http://localhost:3002/api/v1/pantofiSport/remove?sku=49288-0402")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(mapper.writeValueAsBytes(pantofiSport)))
                .andExpect(status().isOk())
                .andExpect(content().string("Ai sters cu succes un produs"));

        verify(pantofiSportService, times(1)).removePantofiSport("49288-0402");

        assertEquals(Optional.empty(), pantofiSportService.findPantofiSport("49288-0402"));
    }

    @Test
    public void update() throws Exception {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();
        PantofiSportDTO pantofiSportDTO = new PantofiSportDTO(1L,"maro",43.5,600,12);

        restMockMvc.perform(put("http://localhost:3002/api/v1/pantofiSport/update")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(mapper.writeValueAsBytes(pantofiSportDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("Ai updata atributul cu succes"));

        verify(pantofiSportService, times(1)).updatePantofiSport(pantofiSportDTOArgumentCaptor.capture());

        assertEquals(pantofiSportDTOArgumentCaptor.getValue(), pantofiSportDTO);


    }
}