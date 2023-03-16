package ro.mycode.PantofiSport.pantofRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.mycode.PantofiSport.PantofiSportApplication;
import ro.mycode.PantofiSport.model.PantofiSport;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PantofiSportApplication.class)
@Transactional
class PantofiSportRepositoryTest {

    @Autowired
    PantofiSportRepository pantofiSportRepository;

    @BeforeEach
    public void clear(){
        pantofiSportRepository.deleteAll();
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

        pantofiSportRepository.saveAndFlush(pantofiSport);
        pantofiSportRepository.saveAndFlush(pantofiSport2);
        pantofiSportRepository.saveAndFlush(pantofiSport3);
        pantofiSportRepository.saveAndFlush(pantofiSport4);
        pantofiSportRepository.saveAndFlush(pantofiSport5);
        pantofiSportRepository.saveAndFlush(pantofiSport6);
        pantofiSportRepository.saveAndFlush(pantofiSport7);
        pantofiSportRepository.saveAndFlush(pantofiSport8);
        pantofiSportRepository.saveAndFlush(pantofiSport9);
        pantofiSportRepository.saveAndFlush(pantofiSport10);

        List<PantofiSport> pantofiSports = pantofiSportRepository.getPantofiSportByNumeProdus().get();

        assertEquals(pantofiSport6, pantofiSports.get(0));


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

        pantofiSportRepository.saveAndFlush(pantofiSport);
        pantofiSportRepository.saveAndFlush(pantofiSport2);
        pantofiSportRepository.saveAndFlush(pantofiSport3);
        pantofiSportRepository.saveAndFlush(pantofiSport4);
        pantofiSportRepository.saveAndFlush(pantofiSport5);
        pantofiSportRepository.saveAndFlush(pantofiSport6);
        pantofiSportRepository.saveAndFlush(pantofiSport7);
        pantofiSportRepository.saveAndFlush(pantofiSport8);
        pantofiSportRepository.saveAndFlush(pantofiSport9);
        pantofiSportRepository.saveAndFlush(pantofiSport10);

        List<PantofiSport> pantofiSports = pantofiSportRepository.getPantofiSportByPriceA().get();

        assertEquals(pantofiSport4, pantofiSports.get(0));
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

        pantofiSportRepository.saveAndFlush(pantofiSport);
        pantofiSportRepository.saveAndFlush(pantofiSport2);
        pantofiSportRepository.saveAndFlush(pantofiSport3);
        pantofiSportRepository.saveAndFlush(pantofiSport4);
        pantofiSportRepository.saveAndFlush(pantofiSport5);
        pantofiSportRepository.saveAndFlush(pantofiSport6);
        pantofiSportRepository.saveAndFlush(pantofiSport7);
        pantofiSportRepository.saveAndFlush(pantofiSport8);
        pantofiSportRepository.saveAndFlush(pantofiSport9);
        pantofiSportRepository.saveAndFlush(pantofiSport10);

        List<PantofiSport> pantofiSports = pantofiSportRepository.getPantofiSportByPriceD().get();

        assertEquals(pantofiSport10, pantofiSports.get(0));
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

        pantofiSportRepository.saveAndFlush(pantofiSport);
        pantofiSportRepository.saveAndFlush(pantofiSport2);
        pantofiSportRepository.saveAndFlush(pantofiSport3);
        pantofiSportRepository.saveAndFlush(pantofiSport4);
        pantofiSportRepository.saveAndFlush(pantofiSport5);
        pantofiSportRepository.saveAndFlush(pantofiSport6);
        pantofiSportRepository.saveAndFlush(pantofiSport7);
        pantofiSportRepository.saveAndFlush(pantofiSport8);
        pantofiSportRepository.saveAndFlush(pantofiSport9);
        pantofiSportRepository.saveAndFlush(pantofiSport10);

        List<PantofiSport> pantofiSports = pantofiSportRepository.getPantofiSportByGenM().get();

        assertEquals(5, pantofiSports.size());
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

        pantofiSportRepository.saveAndFlush(pantofiSport);
        pantofiSportRepository.saveAndFlush(pantofiSport2);
        pantofiSportRepository.saveAndFlush(pantofiSport3);
        pantofiSportRepository.saveAndFlush(pantofiSport4);
        pantofiSportRepository.saveAndFlush(pantofiSport5);
        pantofiSportRepository.saveAndFlush(pantofiSport6);
        pantofiSportRepository.saveAndFlush(pantofiSport7);
        pantofiSportRepository.saveAndFlush(pantofiSport8);
        pantofiSportRepository.saveAndFlush(pantofiSport9);
        pantofiSportRepository.saveAndFlush(pantofiSport10);

        List<PantofiSport> pantofiSports = pantofiSportRepository.getPantofiSportByGenF().get();

        assertEquals(5, pantofiSports.size());
    }

    @Test
    void updatePantofiSportPrice() {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        pantofiSportRepository.saveAndFlush(pantofiSport);

        pantofiSportRepository.updatePantofiSportPrice(200.99,"49288-0402");

        assertNotEquals(Optional.empty(), pantofiSportRepository.findBySkuAndPrice("49288-0402", 200.99));
    }

    @Test
    void updatePantofiSportStoc() {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        pantofiSportRepository.saveAndFlush(pantofiSport);

        pantofiSportRepository.updatePantofiSportStoc(7,"49288-0402");

        assertNotEquals(Optional.empty(), pantofiSportRepository.findBySkuAndStoc("49288-0402", 7));
    }

    @Test
    void updatePantofiSportMarime() {
        PantofiSport pantofiSport = PantofiSport.builder().culoare("Fuscia").descriere("Vinyl").gen("M").marime(41).numeProdus("Stalked Popcornflower").price(632.24).sku("49288-0402").stoc(13).build();

        pantofiSportRepository.saveAndFlush(pantofiSport);

        pantofiSportRepository.updatePantofiSportMarime(37,"49288-0402");

        assertNotEquals(Optional.empty(), pantofiSportRepository.findBySkuAndMarime("49288-0402", 37));
    }
}