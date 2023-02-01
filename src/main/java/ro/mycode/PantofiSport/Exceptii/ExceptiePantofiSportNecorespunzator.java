package ro.mycode.PantofiSport.Exceptii;

public class ExceptiePantofiSportNecorespunzator extends RuntimeException{

    public ExceptiePantofiSportNecorespunzator() {
        super("Niciun produs nu corespunde cu criteriile date");
    }
}
