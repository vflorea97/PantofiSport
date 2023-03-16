package ro.mycode.PantofiSport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PantofiSportDTO {

    @NotNull
    private Long id;
    private String culoare;
    private double marime;
    private double price;
    private int stoc;
}
