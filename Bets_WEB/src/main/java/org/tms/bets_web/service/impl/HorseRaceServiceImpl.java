package org.tms.bets_web.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.tms.bets_web.dto.Pair;
import org.tms.bets_web.service.HorseRaceService;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class HorseRaceServiceImpl implements HorseRaceService {

    private List<Pair> pairs;

    @Override
    public List<Pair> addPair(Pair pair) {
        pairs.add(pair);
        return pairs;
    }

    @Override
    public int getRaceLeader() {
        int leadNumber = 0;
        int maxSpeed = 0;
        List<Integer> speedParameters = new ArrayList<>();

        for (Pair pair : pairs) {
            int pairSpeed = pair.getTotalSpeed();
            speedParameters.add(pairSpeed);

            if (pairSpeed > maxSpeed) {
                maxSpeed = pairSpeed;
                leadNumber = pair.getNumber();
            }
        }
        int counterMaxNumbers = 0;
        int max = speedParameters.stream().max(Integer::compare).get();
        for (Integer speed : speedParameters) {
            if (speed == max) {
                counterMaxNumbers++;
            }
        }
        if (counterMaxNumbers > 1) {
            return 0;
        } else {
            return leadNumber;
        }
    }
}