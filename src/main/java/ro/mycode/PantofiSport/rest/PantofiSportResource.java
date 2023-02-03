package ro.mycode.PantofiSport.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.PantofiSport.model.PantofiSport;
import ro.mycode.PantofiSport.pantofServices.PantofiSportService;

import java.util.List;

@Slf4j
@RestController
public class PantofiSportResource {

    private PantofiSportService pantofiSportService;

    public PantofiSportResource(PantofiSportService pantofiSportService){
        this.pantofiSportService = pantofiSportService;
    }

    @GetMapping("api/v1/panfotiSport/getAllPantofiSport")
    public ResponseEntity<List<PantofiSport>> getAllPantofiSport(){
        log.info("REST request to get all PantofiSport");
        List<PantofiSport> pantofiSports = pantofiSportService.gelAllPantofiSport();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @GetMapping("api/v1/pantofiSport/getPantofiSportByNumeProdus")
    public ResponseEntity<List<PantofiSport>> getPantofiSportByNumeProdus(){
        log.info("REST request to get PantofiSport order by name A-Z");
        List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByNumeProdus();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @GetMapping("api/v1/pantofiSport/getPantofiSportByPriceA")
    public ResponseEntity<List<PantofiSport>> getPantofiSportByPriceA(){
        log.info("REST request to get PantofiSport order by price ASC");
        List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByPriceA();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @GetMapping("api/v1/pantofiSport/getPantofSportByPriceD")
    public ResponseEntity<List<PantofiSport>> getPantofSportByPriceD(){
        log.info("REST request to get PantofiSport order by price DESC");
        List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByPriceD();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @GetMapping("api/v1/pantofiSport/getPantofSportByGenM")
    public ResponseEntity<List<PantofiSport>> getPantofSportByGenM(){
        log.info("REST request to get PantofiSport only for men");
        List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByGenM();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @GetMapping("api/v1/pantofiSport/getPantofSportByGenF")
    public ResponseEntity<List<PantofiSport>> getPantofSportByGenF(){
        log.info("REST request to get PantofiSport only for woman");
        List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByGenF();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }
}
