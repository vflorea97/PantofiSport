package ro.mycode.PantofiSport.Exceptii;

public class ExceptiePantofSportNeexistent extends RuntimeException{

    public ExceptiePantofSportNeexistent() {
        super("Acest produs nu exista in baza de date!!");
    }
}
