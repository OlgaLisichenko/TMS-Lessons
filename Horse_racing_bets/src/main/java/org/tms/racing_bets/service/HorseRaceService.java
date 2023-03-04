package org.tms.racing_bets.service;

import org.springframework.stereotype.Service;
import org.tms.racing_bets.domain.Pair;

import java.util.List;

@Service
public interface HorseRaceService {

    List<Pair> getListOfPairs();

    int getLeaderAfterLap(int counter1, int counter2, int counter3);

    int getRaceLeader();

    int getLapCounter(int lapCounter) throws InterruptedException;
}