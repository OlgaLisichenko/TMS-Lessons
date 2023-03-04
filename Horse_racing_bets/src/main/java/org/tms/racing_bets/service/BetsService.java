package org.tms.racing_bets.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public interface BetsService {

    int getPairForBet(Scanner scanner);

    int getSumOfBet(Scanner scanner);

    void makeBet();

    void getTotalSum(int bet, int sumOfBet, int winningPair);

    void playAgain(Scanner scanner);
}