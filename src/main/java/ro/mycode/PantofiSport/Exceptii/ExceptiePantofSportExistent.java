package ro.mycode.PantofiSport.Exceptii;

public class ExceptiePantofSportExistent extends RuntimeException{

    public ExceptiePantofSportExistent() {
        super("Acest produs exista deja in baza de date!!");
    }
}
