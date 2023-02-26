package org.tms.bets_web.service;

import org.tms.bets_web.dto.Pair;

import java.util.List;

public interface HorseRaceService {

    List<Pair> getPairs();

    List<Pair> addPair(Pair pair);

    int getRaceLeader();
}