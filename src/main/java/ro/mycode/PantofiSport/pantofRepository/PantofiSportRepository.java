package ro.mycode.PantofiSport.pantofRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ro.mycode.PantofiSport.model.PantofiSport;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PantofiSportRepository extends JpaRepository<PantofiSport, Long> {


    @Transactional
    Optional<PantofiSport> findBySku(String sku);

    @Transactional
    Optional<PantofiSport> removePantofSportBySku(String sku);

    @Query("select p from PantofSport p order by p.numeProdus asc")
    Optional<List<PantofiSport>> getPantofiSportByNumeProdus();

    @Query("select p from PantofSport p order by p.price asc")
    Optional<List<PantofiSport>> getPantofiSportByPriceA();

    @Query("select p from PantofSport p order by p.price desc")
    Optional<List<PantofiSport>> getPantofiSportByPriceD();

    @Query("select p from PantofSport p where p.gen = 'M'")
    Optional<List<PantofiSport>> getPantofiSportByGenM();

    @Query("select p from PantofSport p where p.gen = 'F'")
    Optional<List<PantofiSport>> getPantofiSportByGenF();

    @Transactional
    @Modifying
    @Query("update PantofSport p set p.price = ?1 where p.sku = ?2")
    void updatePantofiSportPrice(double price, String sku);

    @Transactional
    @Modifying
    @Query("update PantofSport p set p.stoc = ?1 where p.sku = ?2")
    void updatePantofiSportStoc(int stoc, String sku);

    @Transactional
    @Modifying
    @Query("update PantofSport p set p.marime = ?1 where p.sku = ?2")
    void updatePantofiSportMarime(double marime, String sku);





}
