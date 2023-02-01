package ro.mycode.PantofiSport.Exceptii;

public class ExceptiePantofiSportStoc extends RuntimeException{

    public ExceptiePantofiSportStoc() {
        super("Acest produs nu se mai afla in stoc!!");
    }
}
