package ro.mycode.PantofiSport.Exceptii;

public class ExceptiePantofiSportDBEmpty extends RuntimeException{

    public ExceptiePantofiSportDBEmpty() {
        super("Baza de date este goala!!");
    }
}
