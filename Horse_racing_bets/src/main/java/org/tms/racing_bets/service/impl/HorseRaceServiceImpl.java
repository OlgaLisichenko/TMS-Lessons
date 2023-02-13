package org.tms.racing_bets.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.tms.racing_bets.domain.Pair;
import org.tms.racing_bets.service.HorseRaceService;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class HorseRaceServiceImpl implements HorseRaceService {
    Pair pair1;
    Pair pair2;
    Pair pair3;

    @Override
    public List<Pair> getListOfPairs() {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        return pairs;
    }

    @Override
    public int getRaceLeader() {
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int lapCounter = 1;

        for (int i = 1; i <= 5; i++) {
            counter1 += pair1.calculatePairSpeed();
            counter2 += pair2.calculatePairSpeed();
            counter3 += pair3.calculatePairSpeed();

            try {
                lapCounter = getLapCounter(lapCounter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Сумма:  пара 1: " + counter1 + ", пара 2: " + counter2 + ", пара 3: " + counter3);
            getLeaderAfterLap(counter1, counter2, counter3);
        }
        System.out.println("\nРезультат гонки: ");
        return getLeaderAfterLap(counter1, counter2, counter3);
    }

    @Override
    public int getLeaderAfterLap(int counter1, int counter2, int counter3) {
        if (counter1 > counter2 && counter1 > counter3) {
            System.out.println("Лидирует " + pair1);
            return 1;
        } else if (counter2 > counter1 && counter2 > counter3) {
            System.out.println("Лидирует " + pair2);
            return 2;
        } else if (counter3 > counter1 && counter3 > counter2) {
            System.out.println("Лидирует " + pair3);
            return 3;
        } else {
            System.out.println("В гонке несколько лидеров");
            return 0;
        }
    }

    @Override
    public int getLapCounter(int lapCounter) throws InterruptedException {
        System.out.print("\nКруг номер " + (lapCounter++) + " .");
        Thread.sleep(1000);
        System.out.print(" .");
        Thread.sleep(1000);
        System.out.println(" .");
        Thread.sleep(1000);
        return lapCounter;
    }
}