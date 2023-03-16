package ro.mycode.PantofiSport.comparatori;

import ro.mycode.PantofiSport.model.PantofiSport;

import java.util.Comparator;

public class PantofiSportComparatorByGenF implements Comparator<PantofiSport> {
    @Override
    public int compare(PantofiSport t, PantofiSport t1) {
        return Integer.compare(t.getGen().compareTo(t1.getGen()), 0);
    }
}
