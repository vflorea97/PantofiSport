package ro.mycode.PantofiSport.exceptii;

public class ExceptiePantofiSportNeexistent extends RuntimeException{

    public ExceptiePantofiSportNeexistent() {
        super("Acest produs nu exista in baza de date!!");
    }
}
