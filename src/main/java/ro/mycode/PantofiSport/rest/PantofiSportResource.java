package ro.mycode.PantofiSport.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.PantofiSport.dto.PantofiSportDTO;
import ro.mycode.PantofiSport.model.PantofiSport;
import ro.mycode.PantofiSport.pantofServices.PantofiSportService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/pantofiSport")
public class PantofiSportResource {

    private PantofiSportService pantofiSportService;

    public PantofiSportResource(PantofiSportService pantofiSportService){
        this.pantofiSportService = pantofiSportService;
    }

    @GetMapping("/getAllPantofiSport")
    public ResponseEntity<List<PantofiSport>> getAllPantofiSport(){
        log.info("REST request to get all PantofiSport");
        List<PantofiSport> pantofiSports = pantofiSportService.gelAllPantofiSport();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @GetMapping("/getPantofiSportByNumeProdus")
    public ResponseEntity<List<PantofiSport>> getPantofiSportByNumeProdus(){
        log.info("REST request to get PantofiSport order by name A-Z");
        List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByNumeProdus();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @GetMapping("/getPantofiSportByPriceA")
    public ResponseEntity<List<PantofiSport>> getPantofiSportByPriceA(){
        log.info("REST request to get PantofiSport order by price ASC");
        List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByPriceA();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @GetMapping("/getPantofSportByPriceD")
    public ResponseEntity<List<PantofiSport>> getPantofSportByPriceD(){
        log.info("REST request to get PantofiSport order by price DESC");
        List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByPriceD();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @GetMapping("/getPantofSportByGenM")
    public ResponseEntity<List<PantofiSport>> getPantofSportByGenM(){
        log.info("REST request to get PantofiSport only for men");
        List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByGenM();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @GetMapping("/getPantofSportByGenF")
    public ResponseEntity<List<PantofiSport>> getPantofSportByGenF(){
        log.info("REST request to get PantofiSport only for woman");
        List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByGenF();
        return new ResponseEntity<>(pantofiSports, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PantofiSport> addPantofiSport(@Valid @RequestBody PantofiSport pantofiSport) {

        log.info("Rest api to add a new pantofi Sport {}", pantofiSport);
        this.pantofiSportService.addPantofiSport(pantofiSport);
        return new ResponseEntity<>(pantofiSport, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removePantofiSport( @RequestParam String sku){
        log.info("REST request to remove one pantofi Sport");
        pantofiSportService.removePantofiSport(sku);
        return new ResponseEntity<>("Ai sters cu succes un produs", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@Valid @RequestBody PantofiSportDTO pantofiSportDTO){
        log.info("REST request to update student{}", pantofiSportDTO);
        pantofiSportService.updatePantofiSport(pantofiSportDTO);
        return new ResponseEntity<>("Ai updata atributul cu succes", HttpStatus.OK);
    }
}
