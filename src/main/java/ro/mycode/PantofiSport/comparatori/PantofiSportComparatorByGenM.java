package ro.mycode.PantofiSport.comparatori;

import ro.mycode.PantofiSport.model.PantofiSport;

import java.util.Comparator;

public class PantofiSportComparatorByGenM implements Comparator<PantofiSport> {
    @Override
    public int compare(PantofiSport t, PantofiSport t1) {
        return Integer.compare(0, t.getGen().compareTo(t1.getGen()));
    }
}
