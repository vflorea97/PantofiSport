package ro.mycode.PantofiSport.Exceptii;

public class ExceptiePantofSportStoc extends RuntimeException{

    public ExceptiePantofSportStoc() {
        super("Acest produs nu se mai afla in stoc!!");
    }
}
