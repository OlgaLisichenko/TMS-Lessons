package org.tms.bets_web.service;

public interface BetsService {

    int getTotalSum();

    int getPairForBet(int pairForBet);

    int getPairForBet();

    int getTotalSum(int bet, int sumOfBet, int winningPair);
}