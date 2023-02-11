package org.tms.racing_bets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pair {

    private Horse horse;
    private Rider rider;
    private int number;

    public int calculatePairSpeed() {
        return rider.getRandomSkillLevel() + horse.getRandomSpeed();
    }

    @Override
    public String toString() {
        return "Пара номер " + number + ": наездник - " + rider.getName() +
               ", лошадь - " + horse.getName();
    }
}