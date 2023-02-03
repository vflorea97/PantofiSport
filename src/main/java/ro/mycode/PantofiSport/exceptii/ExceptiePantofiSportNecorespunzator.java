package ro.mycode.PantofiSport.exceptii;

public class ExceptiePantofiSportNecorespunzator extends RuntimeException{

    public ExceptiePantofiSportNecorespunzator() {
        super("Niciun produs nu corespunde cu criteriile date");
    }
}
