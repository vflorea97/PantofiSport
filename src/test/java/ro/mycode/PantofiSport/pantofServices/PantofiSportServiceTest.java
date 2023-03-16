package ro.mycode.PantofiSport.pantofServices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.PantofiSport.comparatori.*;
import ro.mycode.PantofiSport.exceptii.ExceptiePantofiSportDBEmpty;
import ro.mycode.PantofiSport.exceptii.ExceptiePantofiSportExistent;
import ro.mycode.PantofiSport.exceptii.ExceptiePantofiSportNeexistent;
import ro.mycode.PantofiSport.model.PantofiSport;
import ro.mycode.PantofiSport.pantofRepository.PantofiSportRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PantofiSportServiceTest {

    @Mock
    private PantofiSportRepository pantofiSportRepository;

    @InjectMocks
    private PantofiSportService pantofiSportService;

    @Captor
    ArgumentCaptor<PantofiSport> pantofiSportArgumentCaptor;
    @Captor
    ArgumentCaptor<Double> pantofiSportField;
    @Captor
    ArgumentCaptor<Integer> pantofiSportField2;
    @Captor
    ArgumentCaptor<String> pantofiSportField3;

    @Test
    void gelAllPantofiSport() {

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

        doReturn(pantofiSports).when(pantofiSportRepository).findAll();

        assertEquals(10, pantofiSportService.gelAllPantofiSport().size());
    }
    @Test
    public  void getAllPantofiSportEmpty(){
        List<PantofiSport> pantofiSports = new ArrayList<>();
        doReturn(pantofiSports).when(pantofiSportRepository).findAll();
        assertThrows(ExceptiePantofiSportDBEmpty.class, () -> {
            pantofiSportService.gelAllPantofiSport();
        });
    }

    @Test
    void addPantofiSport() {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        doReturn(Optional.empty()).when(pantofiSportRepository).findBySku("49288-0402");

        pantofiSportService.addPantofiSport(pantofiSport);

        verify(pantofiSportRepository, times(1)).saveAndFlush(pantofiSportArgumentCaptor.capture());

        assertEquals(pantofiSportArgumentCaptor.getValue(), pantofiSport);
    }
    @Test
    void addPantofiSportExceptie() {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        doReturn(Optional.of(pantofiSport)).when(pantofiSportRepository).findBySku("49288-0402");

        assertThrows(ExceptiePantofiSportExistent.class, () ->{
            pantofiSportService.addPantofiSport(pantofiSport);
        });
    }

    @Test
    void removePantofiSport() {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        doReturn(Optional.of(pantofiSport)).when(pantofiSportRepository).findBySku("49288-0402");

        pantofiSportService.removePantofiSport("49288-0402");

        verify(pantofiSportRepository, times(1)).removePantofSportBySku(pantofiSportField3.capture());

        assertEquals("49288-0402", pantofiSportField3.getValue());
    }
    @Test
    public void removePantofiSportExceptie() {
        doReturn(Optional.empty()).when(pantofiSportRepository).findBySku("49288-0402");

        assertThrows(ExceptiePantofiSportNeexistent.class, () ->{
            pantofiSportService.removePantofiSport("49288-0402");
        });
    }

    @Test
    void updatePantofiSportPrice() {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        doReturn(Optional.of(pantofiSport)).when(pantofiSportRepository).findBySku("49288-0402");

        pantofiSportService.updatePantofiSportPrice(20.99,"49288-0402");

        verify(pantofiSportRepository, times(1)).updatePantofiSportPrice(pantofiSportField.capture(), pantofiSportField3.capture());

        assertEquals(20.99, pantofiSportField.getValue());
        assertEquals("49288-0402", pantofiSportField3.getValue());
    }
    @Test
    void updatePantofiSportPriceExceptie() {
        doReturn(Optional.empty()).when(pantofiSportRepository).findBySku("49288-0402");

        assertThrows(ExceptiePantofiSportNeexistent.class, () ->{
            pantofiSportService.updatePantofiSportPrice(100,"49288-0402");
        });
    }

    @Test
    void updatePantofiSportStoc() {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        doReturn(Optional.of(pantofiSport)).when(pantofiSportRepository).findBySku("49288-0402");

        pantofiSportService.updatePantofiSportStoc(20,"49288-0402");

        verify(pantofiSportRepository, times(1)).updatePantofiSportStoc(pantofiSportField2.capture(), pantofiSportField3.capture());

        assertEquals(20, pantofiSportField2.getValue());
        assertEquals("49288-0402", pantofiSportField3.getValue());
    }
    @Test
    void updatePantofiSportStocExcepite() {
        doReturn(Optional.empty()).when(pantofiSportRepository).findBySku("49288-0402");

        assertThrows(ExceptiePantofiSportNeexistent.class, () ->{
            pantofiSportService.updatePantofiSportStoc(20,"49288-0402");
        });
    }

    @Test
    void updatePantofiSportMarime() {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        doReturn(Optional.of(pantofiSport)).when(pantofiSportRepository).findBySku("49288-0402");

        pantofiSportService.updatePantofiSportMarime(40.5,"49288-0402");

        verify(pantofiSportRepository, times(1)).updatePantofiSportMarime(pantofiSportField.capture(), pantofiSportField3.capture());

        assertEquals(40.5, pantofiSportField.getValue());
        assertEquals("49288-0402", pantofiSportField3.getValue());
    }
    @Test
    void updatePantofiSportMarimeExceptie() {
        doReturn(Optional.empty()).when(pantofiSportRepository).findBySku("49288-0402");

        assertThrows(ExceptiePantofiSportNeexistent.class, () ->{
            pantofiSportService.updatePantofiSportMarime(40.5,"49288-0402");
        });
    }

    @Test
    void getPantofiSportByNumeProdus() {
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

        Collections.sort(pantofiSports, new PatofiSportComparatorByName());

        doReturn(Optional.of(pantofiSports)).when(pantofiSportRepository).getPantofiSportByNumeProdus();
        pantofiSportService.getPantofiSportByNumeProdus();

        assertEquals(pantofiSport6, pantofiSports.get(0));
    }
    @Test
    public void ordineNumeDescExceptie(){
        List<PantofiSport> pantofiSports = new ArrayList<>();

        doReturn(Optional.of(pantofiSports)).when(pantofiSportRepository).getPantofiSportByNumeProdus();

        assertThrows(ExceptiePantofiSportDBEmpty.class, () ->{
            pantofiSportService.getPantofiSportByNumeProdus();
        });
    }

    @Test
    void getPantofiSportByPriceA() {
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

        Collections.sort(pantofiSports, new PantofiSportComparatorByPriceAsc());

        doReturn(Optional.of(pantofiSports)).when(pantofiSportRepository).getPantofiSportByPriceA();
        pantofiSportService.getPantofiSportByPriceA();

        assertEquals(pantofiSport4, pantofiSports.get(0));
    }

    @Test
    public void ordinePriceAscExceptie(){
        List<PantofiSport> pantofiSports = new ArrayList<>();

        doReturn(Optional.of(pantofiSports)).when(pantofiSportRepository).getPantofiSportByPriceA();

        assertThrows(ExceptiePantofiSportDBEmpty.class, () ->{
            pantofiSportService.getPantofiSportByPriceA();
        });
    }

    @Test
    void getPantofiSportByPriceD() {
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

        Collections.sort(pantofiSports, new PantofiSportComparatorByPriceDesc());

        doReturn(Optional.of(pantofiSports)).when(pantofiSportRepository).getPantofiSportByPriceD();
        pantofiSportService.getPantofiSportByPriceD();

        assertEquals(pantofiSport10, pantofiSports.get(0));
    }
    @Test
    public void ordinePriceDescExceptie(){
        List<PantofiSport> pantofiSports = new ArrayList<>();

        doReturn(Optional.of(pantofiSports)).when(pantofiSportRepository).getPantofiSportByPriceD();

        assertThrows(ExceptiePantofiSportDBEmpty.class, () ->{
            pantofiSportService.getPantofiSportByPriceD();
        });
    }

    @Test
    void getPantofiSportByGenM() {
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

        Collections.sort(pantofiSports, new PantofiSportComparatorByGenM());

        doReturn(Optional.of(pantofiSports)).when(pantofiSportRepository).getPantofiSportByGenM();
        pantofiSportService.getPantofiSportByGenM();

        assertEquals(pantofiSports.get(4), pantofiSport10);
        assertEquals(pantofiSports.get(5),pantofiSport2);
    }
    @Test
    public void sortByGenMExceptie(){
        List<PantofiSport> pantofiSports = new ArrayList<>();

        doReturn(Optional.of(pantofiSports)).when(pantofiSportRepository).getPantofiSportByGenM();

        assertThrows(ExceptiePantofiSportDBEmpty.class, () ->{
            pantofiSportService.getPantofiSportByGenM();
        });
    }

    @Test
    void getPantofiSportByGenF() {
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

        Collections.sort(pantofiSports, new PantofiSportComparatorByGenF());

        doReturn(Optional.of(pantofiSports)).when(pantofiSportRepository).getPantofiSportByGenF();
        pantofiSportService.getPantofiSportByGenF();

        assertEquals(pantofiSports.get(4), pantofiSport8);
        assertEquals(pantofiSports.get(5),pantofiSport);
    }
    @Test
    public void sortByGenFExceptie(){
        List<PantofiSport> pantofiSports = new ArrayList<>();

        doReturn(Optional.of(pantofiSports)).when(pantofiSportRepository).getPantofiSportByGenF();

        assertThrows(ExceptiePantofiSportDBEmpty.class, () ->{
            pantofiSportService.getPantofiSportByGenF();
        });
    }
}