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
    private String culoare = "";
    private double marime = 0;
    private double price = 0;
    private int stoc = 0;
}
