package ro.mycode.PantofiSport.exceptii;

public class ExceptiePantofiSportStoc extends RuntimeException{

    public ExceptiePantofiSportStoc() {
        super("Acest produs nu se mai afla in stoc!!");
    }
}
