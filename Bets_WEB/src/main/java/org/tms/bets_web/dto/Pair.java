package org.tms.bets_web.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@RequiredArgsConstructor
public class Pair {

    @Valid
    private final Horse horse;
    @Valid
    private final Rider rider;
    @Min(value = 1) @Max(value = 20)
    private final int number;
    private int totalSpeed;

    public int getTotalSpeed() {
        totalSpeed = calculatePairSpeed();
        return totalSpeed;
    }

    public int calculatePairSpeed() {
        return rider.getRandomSkillLevel() + horse.getRandomSpeed();
    }

    @Override
    public String toString() {
        return " pair number: " + number + ", rider: " + rider.getName() +
               ", horse: " + horse.getName();
    }
}