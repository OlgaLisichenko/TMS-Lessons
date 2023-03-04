package org.tms.bets_web.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tms.bets_web.dto.Pair;
import org.tms.bets_web.service.BetsService;
import org.tms.bets_web.service.HorseRaceService;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class BetsServiceImpl implements BetsService {

    private int totalSum = 100;
    private int pairForBet;
    private final HorseRaceService service;

    @Override
    public int getPairForBet(int pairBet) {
        if (service.getPairs() != null) {
            List<Pair> listOfPairs = service.getPairs();
            for (Pair pair : listOfPairs) {
                if (pairBet == pair.getNumber()) {
                    pairForBet = pairBet;
                    return pairForBet;
                }
            }
        }
        return 0;
    }

    @Override
    public int getTotalSum(int bet, int sumOfBet, int winningPair) {
        if (winningPair == 0) {
            return totalSum;
        } else if (bet == winningPair) {
            totalSum = totalSum + sumOfBet;
            return totalSum;
        } else {
            totalSum = totalSum - sumOfBet;
            return totalSum;
        }
    }
}