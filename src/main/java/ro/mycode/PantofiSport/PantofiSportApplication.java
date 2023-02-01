package ro.mycode.PantofiSport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.PantofiSport.PantofRepository.PantofiSportRepository;
import ro.mycode.PantofiSport.View.View;

@SpringBootApplication
public class PantofiSportApplication {

	public static void main(String[] args) {
		SpringApplication.run(PantofiSportApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(PantofiSportRepository pantofSportRepository, View view){

        return args -> {
            view.play();
//            Optional<PantofSport> pantofSport = pantofSportRepository.findBySku("49288-0402");
//            System.out.println(pantofSport);

//            pantofSportRepository.removePantofSportBySku("52584-213");
//            System.out.println(pantofSportRepository.findAll());

//            List<PantofSport> pantofiSport = pantofSportRepository.getPantofSportByNumeProdus().get();
//            List<PantofSport> pantofiSport = pantofSportRepository.getPantofSportByPriceA().get();
//            List<PantofSport> pantofiSport = pantofSportRepository.getPantofSportByPriceD().get();
//            List<PantofSport> pantofiSport = pantofSportRepository.getPantofSportByGenF().get();
//            List<PantofSport> pantofiSport = pantofSportRepository.getPantofSportByGenM().get();
//            for (PantofSport p:pantofiSport){
//                System.out.println(p);
//            }

//            pantofSportRepository.updatePantofSportMarime(40, "49288-0402");
//            pantofSportRepository.updatePantofSportStoc(10, "49288-0402");
//            pantofSportRepository.updatePantofSportPrice(300, "49288-0402");
//            System.out.println(pantofSportRepository.findBySku("49288-0402"));
        };
    }

}
