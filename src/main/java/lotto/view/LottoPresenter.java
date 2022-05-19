package lotto.view;

import static lotto.domain.message.InformationMessage.LOSE;
import static lotto.domain.message.InformationMessage.RESULT;
import static lotto.domain.message.InformationMessage.WIN;
import static lotto.domain.message.RequestMessage.BONUS_BALL;
import static lotto.domain.message.RequestMessage.MANUAL_AMOUNT;
import static lotto.domain.message.RequestMessage.MANUAL_NUMBERS_LIST;
import static lotto.domain.message.RequestMessage.PAYMENT;
import static lotto.domain.message.RequestMessage.WINNING_NUMBERS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import lotto.domain.BonusBall;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPayment;
import lotto.domain.LottoTickets;
import lotto.domain.Prize;
import lotto.service.PrizeCalculator;

public class LottoPresenter {
    public void present() {
        final Scanner scanner = new Scanner(System.in);
        final LottoPayment payment = requestPayment(scanner);
        requestManualAmount(scanner, payment);
        final LottoTickets tickets = LottoTickets.createManually(requestManualNumbersList(scanner, payment));
        printLineSeparator();
        printPaymentResult(payment);
        tickets.merge(LottoTickets.createAutomatically(payment.getPurchasableAmount() - payment.getManualAmount()));
        tickets.print();
        printLineSeparator();
        final LottoNumbers winningNumbers = requestWinningNumbers(scanner);
        final BonusBall bonusBall = requestBonusBall(scanner, winningNumbers);
        printResult(payment.getMoney(), tickets.prizeMap(winningNumbers, bonusBall));
    }

    private LottoPayment requestPayment(final Scanner scanner) {
        System.out.println(PAYMENT.getMessage());
        try {
            final LottoPayment payment = LottoPayment.convertAndCreate(scanner.nextLine());
            return payment;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestPayment(scanner);
        }
    }

    private void requestManualAmount(final Scanner scanner, final LottoPayment lottoPayment) {
        System.out.println(MANUAL_AMOUNT.getMessage());
        try {
            lottoPayment.setManualAmount(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            requestManualAmount(scanner, lottoPayment);
        }
    }

    private List<LottoNumbers> requestManualNumbersList(final Scanner scanner, final LottoPayment lottoPayment) {
        System.out.println(MANUAL_NUMBERS_LIST.getMessage());
        final List<LottoNumbers> manualNumbersList = new ArrayList<>();
        for (int i = 0; i < lottoPayment.getManualAmount(); i++) {
            addManualNumbers(scanner, manualNumbersList);
        }
        return manualNumbersList;
    }

    private void addManualNumbers(final Scanner scanner, List<LottoNumbers> manualNumbersList) {
        try {
            manualNumbersList.add(LottoNumbers.convertAndCreate(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            addManualNumbers(scanner, manualNumbersList);
        }
    }

    private void printPaymentResult(final LottoPayment payment) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                payment.getManualAmount(),
                payment.getPurchasableAmount() - payment.getManualAmount()));
    }

    private void printLineSeparator() {
        System.out.println();
    }

    private LottoNumbers requestWinningNumbers(final Scanner scanner) {
        System.out.println(WINNING_NUMBERS.getMessage());
        try {
            return LottoNumbers.convertAndCreate(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestWinningNumbers(scanner);
        }
    }

    private BonusBall requestBonusBall(final Scanner scanner, final LottoNumbers winningNumbers) {
        System.out.println(BONUS_BALL.getMessage());
        try {
            return BonusBall.convertAndCreate(scanner.nextLine(), winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestBonusBall(scanner, winningNumbers);
        }
    }

    public void printResult(final int payment, final Map<Prize, Integer> prizeMap) {
        System.out.println(RESULT.getMessage());
        printPrizes(prizeMap);
        printReturnOfRatio(PrizeCalculator.returnOfRatio(payment, prizeMap));
    }

    private void printPrizes(final Map<Prize, Integer> prizeMap) {
        for (final Prize prize : Prize.printablePrizes()) {
            System.out.println(prize.resultMessage(prizeMap.get(prize)));
        }
    }

    private void printReturnOfRatio(final double returnOfRatio) {
        final String message = "총 수익률은 " + String.format("%.2f", returnOfRatio) + "입니다.";
        System.out.println(message + (returnOfRatio > 1 ? WIN.getMessage() : LOSE.getMessage()));
    }
}
