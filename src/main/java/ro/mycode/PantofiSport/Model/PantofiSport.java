package ro.mycode.PantofiSport.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity(name = "PantofSport")
@Table(name = "pantofsport")
public class PantofiSport implements Comparable<PantofiSport> {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id

    private Long id;
    private String numeProdus;
    private String descriere;
    private String sku;
    private String culoare;
    private String gen;
    private double marime;
    private double price;
    private int stoc;

    @Override
    public int compareTo(PantofiSport pantofSport) {
        if (this.sku.compareTo(pantofSport.sku) > 0){
            return 1;
        }
        if (this.sku.compareTo(pantofSport.sku) < 0){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public boolean equals(Object o){
        PantofiSport p = (PantofiSport) o;
        return this.sku.equals(p.sku);
    }
}
