package ro.mycode.PantofiSport.comparatori;

import ro.mycode.PantofiSport.model.PantofiSport;

import java.util.Comparator;

public class PantofiSportComparatorByPriceDesc implements Comparator<PantofiSport> {
    @Override
    public int compare(PantofiSport t, PantofiSport t1) {
        return Double.compare(t1.getPrice(), t.getPrice());
    }
}
