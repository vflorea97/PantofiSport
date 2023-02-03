package ro.mycode.PantofiSport.pantofServices;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ro.mycode.PantofiSport.exceptii.ExceptiePantofiSportDBEmpty;
import ro.mycode.PantofiSport.exceptii.ExceptiePantofiSportExistent;
import ro.mycode.PantofiSport.exceptii.ExceptiePantofiSportNeexistent;
import ro.mycode.PantofiSport.model.PantofiSport;
import ro.mycode.PantofiSport.pantofRepository.PantofiSportRepository;

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

    public List<PantofiSport> gelAllPantofiSport(){
        List<PantofiSport> pantofiSports = pantofSportRepository.findAll();
        return pantofiSports;
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
    public void updatePantofiSportPrice(double price, String sku) throws ExceptiePantofiSportNeexistent{
        Optional<PantofiSport> pantofiSport = pantofSportRepository.findBySku(sku);
        if (pantofiSport.isPresent()){
            pantofSportRepository.updatePantofiSportPrice(price, sku);
        }else {
            throw new ExceptiePantofiSportNeexistent();
        }
    }
    @Transactional
    @Modifying
    public void updatePantofiSportStoc(int stoc, String sku) throws ExceptiePantofiSportNeexistent{
        Optional<PantofiSport> pantofiSport = pantofSportRepository.findBySku(sku);
        if (pantofiSport.isPresent()){
            pantofSportRepository.updatePantofiSportStoc(stoc, sku);
        }else {
            throw new ExceptiePantofiSportNeexistent();
        }
    }
    @Transactional
    @Modifying
    public void updatePantofiSportMarime(double marime, String sku) throws ExceptiePantofiSportNeexistent{
        Optional<PantofiSport> pantofiSport = pantofSportRepository.findBySku(sku);
        if (pantofiSport.isPresent()){
            pantofSportRepository.updatePantofiSportMarime(marime, sku);
        }else {
            throw new ExceptiePantofiSportNeexistent();
        }
    }
    public List<PantofiSport> getPantofiSportByNumeProdus() throws ExceptiePantofiSportDBEmpty{
        List<PantofiSport> pantofiSport = pantofSportRepository.getPantofiSportByNumeProdus().get();
        if (pantofiSport.size() > 0){
            return pantofiSport;
        }else {
            throw new ExceptiePantofiSportDBEmpty();
        }
    }
    public List<PantofiSport> getPantofiSportByPriceA() throws ExceptiePantofiSportDBEmpty{
        List<PantofiSport> pantofiSports = pantofSportRepository.getPantofiSportByPriceA().get();
        if (pantofiSports.size() > 0){
            return pantofiSports;
        }else {
            throw new ExceptiePantofiSportDBEmpty();
        }
    }
    public List<PantofiSport> getPantofiSportByPriceD() throws ExceptiePantofiSportDBEmpty{
        List<PantofiSport> pantofiSports = pantofSportRepository.getPantofiSportByPriceD().get();
        if (pantofiSports.size() > 0){
            return pantofiSports;
        }else {
            throw new ExceptiePantofiSportDBEmpty();
        }
    }
    public List<PantofiSport> getPantofiSportByGenM() throws ExceptiePantofiSportDBEmpty{
        List<PantofiSport> pantofiSports = pantofSportRepository.getPantofiSportByGenM().get();
        if (pantofiSports.size() > 0){
            return pantofiSports;
        }else {
            throw new ExceptiePantofiSportDBEmpty();
        }
    }
    public List<PantofiSport> getPantofiSportByGenF() throws ExceptiePantofiSportDBEmpty{
        List<PantofiSport> pantofiSports = pantofSportRepository.getPantofiSportByGenF().get();
        if (pantofiSports.size() > 0){
            return pantofiSports;
        }else {
            throw new ExceptiePantofiSportDBEmpty();
        }
    }

}
