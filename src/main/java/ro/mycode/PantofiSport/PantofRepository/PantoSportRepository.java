package ro.mycode.PantofiSport.PantofRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.PantofiSport.Model.PantofSport;

import javax.transaction.Transactional;
import java.util.Optional;

public interface PantoSportRepository extends JpaRepository<PantofSport, Long> {

    @Transactional
    Optional<PantofSport> findBySku(String sku);
    
}
