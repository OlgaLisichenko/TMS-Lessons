package org.tms.racing_bets.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tms.racing_bets.domain.Pair;
import org.tms.racing_bets.service.BetsService;

import java.util.List;
import java.util.Scanner;

@Service
@Data
@RequiredArgsConstructor
public class BetsServiceImpl implements BetsService {

    private int totalSum = 100;
    private final HorseRaceServiceImpl service;

    @Override
    public void makeBet() {
        try (Scanner scanner = new Scanner(System.in)) {

            int bet = getPairForBet(scanner);
            int sumOfBet = getSumOfBet(scanner);
            int winningPair = service.getRaceLeader();
            getTotalSum(bet, sumOfBet, winningPair);
            playAgain(scanner);
        }
    }

    @Override
    public int getPairForBet(Scanner scanner) {
        String message = "\nВыберите пару для ставки: 1, 2 или 3";
        System.out.println(message);
        List<Pair> listOfPairs = service.getListOfPairs();
        for (Pair pair : listOfPairs) {
            System.out.println(pair);
        }
        isScannerHaveInt(scanner, message);
        int pairForBet = scanner.nextInt();
        if (pairForBet >= 1 && pairForBet <= 3) {
            service.getListOfPairs();
            for (Pair pair : listOfPairs) {
                if (pair.getNumber() == pairForBet) {
                    System.out.println("Выбрана " + pair);
                }
            }
        } else {
            System.out.println("Выбранной пары не существует");
            makeBet();
        }
        return pairForBet;
    }

    @Override
    public int getSumOfBet(Scanner scanner) {
        String message = "Выберите сумму для ставки";
        System.out.println(message + ". Ваша начальная сумма равна " + totalSum);
        isScannerHaveInt(scanner, message);
        int sumOfBet = scanner.nextInt();
        if (sumOfBet <= totalSum && sumOfBet > 0) {
            System.out.println("Ваша ставка " + sumOfBet + ". При выигрыше сумма ставки будет удвоена");
            return sumOfBet;
        } else {
            System.out.println("Ваша ставка " + sumOfBet + ". Данная ставка невозможна");
            return getSumOfBet(scanner);
        }
    }

    @Override
    public void getTotalSum(int bet, int sumOfBet, int winningPair) {
        if (bet == winningPair) {
            totalSum = totalSum + sumOfBet;
            System.out.println("\nВы выиграли! Ваша ставка удвоена. Общая сумма равна " + totalSum);
        } else if (winningPair == 0) {
            System.out.println("\nОбщая сумма не изменилась и равна " + totalSum);
        } else {
            totalSum = totalSum - sumOfBet;
            System.out.println("\nВы проиграли. Оставшаяся сумма равна " + totalSum);
        }
    }

    @Override
    public void playAgain(Scanner scanner) {
        System.out.println("Желаете сыграть ещё раз? (Если Да, нажмите 1)");
        if (scanner.hasNextInt()) {
            if (scanner.nextInt() == 1) {
                makeBet();
            }
        }
    }

    public void isScannerHaveInt(Scanner scanner, String message) {
        while (!scanner.hasNextInt()) {
            System.out.println(message);
            scanner.next();
        }
    }
}