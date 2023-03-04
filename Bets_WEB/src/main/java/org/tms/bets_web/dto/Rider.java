package org.tms.bets_web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class Rider {

    @Min(value = 1) @Max(value = 20)
    private String name;

    public int getRandomSkillLevel() {
        return (int) (Math.random() * 10) + 1;
    }
}