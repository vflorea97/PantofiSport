package ro.mycode.PantofiSport.PantofRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ro.mycode.PantofiSport.Model.PantofSport;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PantofSportRepository extends JpaRepository<PantofSport, Long> {

    @Transactional
    Optional<PantofSport> findBySku(String sku);

    @Transactional
    Optional<PantofSport> removePantofSportBySku(String sku);

    @Query("select p from PantofSport p order by p.numeProdus asc")
    Optional<List<PantofSport>> getPantofSportByNumeProdus();

    @Query("select p from PantofSport p order by p.price asc")
    Optional<List<PantofSport>> getPantofSportByPriceA();

    @Query("select p from PantofSport p order by p.price desc")
    Optional<List<PantofSport>> getPantofSportByPriceD();

    @Query("select p from PantofSport p where p.gen = 'M'")
    Optional<List<PantofSport>> getPantofSportByGenM();

    @Query("select p from PantofSport p where p.gen = 'F'")
    Optional<List<PantofSport>> getPantofSportByGenF();

    @Transactional
    @Modifying
    @Query("update PantofSport p set p.price = ?1 where p.sku = ?2")
    void updatePantofSportPrice(double price, String sku);

    @Transactional
    @Modifying
    @Query("update PantofSport p set p.stoc = ?1 where p.sku = ?2")
    void updatePantofSportStoc(int stoc, String sku);

    @Transactional
    @Modifying
    @Query("update PantofSport p set p.marime = ?1 where p.sku = ?2")
    void updatePantofSportMarime(double marime, String sku);




}
