package ro.mycode.PantofiSport.PantofServices;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ro.mycode.PantofiSport.Exceptii.ExceptiePantofiSportDBEmpty;
import ro.mycode.PantofiSport.Exceptii.ExceptiePantofiSportExistent;
import ro.mycode.PantofiSport.Exceptii.ExceptiePantofiSportNeexistent;
import ro.mycode.PantofiSport.Model.PantofiSport;
import ro.mycode.PantofiSport.PantofRepository.PantofiSportRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PantofiSportService {

    private PantofiSportRepository pantofSportRepository;

    public PantofiSportService(PantofiSportRepository pantofSportRepository){
        this.pantofSportRepository = pantofSportRepository;
    }

    public Optional<PantofiSport> findPantofiSport(String sku) throws ExceptiePantofiSportNeexistent{
        Optional<PantofiSport> pantofiSport = pantofSportRepository.findBySku(sku);
        if (pantofiSport.isPresent()){
            return pantofiSport;
        }else {
            throw new ExceptiePantofiSportNeexistent();
        }
    }

    public void afisarePantofISport(){
        List<PantofiSport> pantofiSports = pantofSportRepository.findAll();
        pantofiSports.forEach(p-> System.out.println(p));
    }

    @Transactional
    public void addPantofiSport(PantofiSport pantofiSport) throws ExceptiePantofiSportExistent{
        Optional<PantofiSport> pantofiSport1 = pantofSportRepository.findBySku(pantofiSport.getSku());
        if (pantofiSport1.isEmpty()){
            pantofSportRepository.saveAndFlush(pantofiSport);
        }else {
            throw new ExceptiePantofiSportExistent();
        }
    }
    @Transactional
    public void removePantofiSport(String sku) throws ExceptiePantofiSportNeexistent{
        Optional<PantofiSport> pantofSport = pantofSportRepository.findBySku(sku);
        if (pantofSport.isPresent()){
            pantofSportRepository.removePantofSportBySku(sku);
        }else {
            throw new ExceptiePantofiSportNeexistent();
        }
    }
    @Transactional
    @Modifying
    public void updatePantofSportPrice(double price, String sku) throws ExceptiePantofiSportNeexistent{
        Optional<PantofiSport> pantofiSport = pantofSportRepository.findBySku(sku);
        if (pantofiSport.isPresent()){
            pantofSportRepository.updatePantofSportPrice(price, sku);
        }else {
            throw new ExceptiePantofiSportNeexistent();
        }
    }
    @Transactional
    @Modifying
    public void updatePantofSportStoc(int stoc, String sku) throws ExceptiePantofiSportNeexistent{
        Optional<PantofiSport> pantofiSport = pantofSportRepository.findBySku(sku);
        if (pantofiSport.isPresent()){
            pantofSportRepository.updatePantofSportStoc(stoc, sku);
        }else {
            throw new ExceptiePantofiSportNeexistent();
        }
    }
    @Transactional
    @Modifying
    public void updatePantofSportMarime(double marime, String sku) throws ExceptiePantofiSportNeexistent{
        Optional<PantofiSport> pantofiSport = pantofSportRepository.findBySku(sku);
        if (pantofiSport.isPresent()){
            pantofSportRepository.updatePantofSportMarime(marime, sku);
        }else {
            throw new ExceptiePantofiSportNeexistent();
        }
    }
    public List<PantofiSport> getPantofSportByNumeProdus() throws ExceptiePantofiSportDBEmpty{
        List<PantofiSport> pantofiSport = pantofSportRepository.getPantofSportByNumeProdus().get();
        if (pantofiSport.size() > 0){
            return pantofiSport;
        }else {
            throw new ExceptiePantofiSportDBEmpty();
        }
    }
    public List<PantofiSport> getPantofSportByPriceA() throws ExceptiePantofiSportDBEmpty{
        List<PantofiSport> pantofiSports = pantofSportRepository.getPantofSportByPriceA().get();
        if (pantofiSports.size() > 0){
            return pantofiSports;
        }else {
            throw new ExceptiePantofiSportDBEmpty();
        }
    }
    public List<PantofiSport> getPantofSportByPriceD() throws ExceptiePantofiSportDBEmpty{
        List<PantofiSport> pantofiSports = pantofSportRepository.getPantofSportByPriceD().get();
        if (pantofiSports.size() > 0){
            return pantofiSports;
        }else {
            throw new ExceptiePantofiSportDBEmpty();
        }
    }
    public List<PantofiSport> getPantofSportByGenM() throws ExceptiePantofiSportDBEmpty{
        List<PantofiSport> pantofiSports = pantofSportRepository.getPantofSportByGenM().get();
        if (pantofiSports.size() > 0){
            return pantofiSports;
        }else {
            throw new ExceptiePantofiSportDBEmpty();
        }
    }
    public List<PantofiSport> getPantofSportByGenF() throws ExceptiePantofiSportDBEmpty{
        List<PantofiSport> pantofiSports = pantofSportRepository.getPantofSportByGenF().get();
        if (pantofiSports.size() > 0){
            return pantofiSports;
        }else {
            throw new ExceptiePantofiSportDBEmpty();


        }
    }
}
