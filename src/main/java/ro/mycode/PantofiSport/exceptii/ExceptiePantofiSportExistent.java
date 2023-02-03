package ro.mycode.PantofiSport.exceptii;

public class ExceptiePantofiSportExistent extends RuntimeException{

    public ExceptiePantofiSportExistent() {
        super("Acest produs exista deja in baza de date!!");
    }
}
