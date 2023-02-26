package org.tms.bets_web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class Horse {

    @Min(value = 1) @Max(value = 20)
    private String name;

    public int getRandomSpeed() {
        return (int) (Math.random() * 10) + 1;
    }
}