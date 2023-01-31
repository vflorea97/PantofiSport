package ro.mycode.PantofiSport.Exceptii;

public class ExceptiePantoSportNecorespunzator extends RuntimeException{

    public ExceptiePantoSportNecorespunzator() {
        super("Niciun produs nu corespunde cu criteriile date");
    }
}
