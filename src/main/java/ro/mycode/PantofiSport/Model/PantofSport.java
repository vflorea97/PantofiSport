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
public class PantofSport implements Comparable<PantofSport> {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    private Long id;
    private String numeProdus;
    private String descriere;
    private String sku;
    private String culoare;
    private double marime;
    private double price;
    private int stoc;

    @Override
    public int compareTo(PantofSport pantofSport) {
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
        PantofSport p = (PantofSport) o;
        return this.sku.equals(p.sku);
    }
}
