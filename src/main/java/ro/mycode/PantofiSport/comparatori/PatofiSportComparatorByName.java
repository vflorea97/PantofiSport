package ro.mycode.PantofiSport.comparatori;

import ro.mycode.PantofiSport.model.PantofiSport;

import java.util.Comparator;

public class PatofiSportComparatorByName implements Comparator<PantofiSport> {
    @Override
    public int compare(PantofiSport t, PantofiSport t1) {
        return Integer.compare(t.getNumeProdus().compareTo(t1.getNumeProdus()), 0);
    }
}
