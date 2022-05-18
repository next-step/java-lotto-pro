package lotto.view;

import static lotto.domain.message.InformationMessage.LOSE;
import static lotto.domain.message.InformationMessage.RESULT;
import static lotto.domain.message.InformationMessage.WIN;
import static lotto.domain.message.RequestMessage.PAYMENT;
import static lotto.domain.message.RequestMessage.WINNING_NUMBERS;

import java.util.Map;
import java.util.Scanner;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPayment;
import lotto.domain.LottoTickets;
import lotto.domain.Prize;
import lotto.service.PrizeCalculator;

public class LottoPresenter {
    private static final int[] PRINTABLE_MATCH_COUNTS = {3, 4, 5, 6};

    public void present() {
        final Scanner scanner = new Scanner(System.in);
        final LottoPayment payment = requestPayment(scanner);
        final LottoTickets tickets = LottoTickets.createAutomatically(payment.getPurchasableAmount());
        tickets.print();
        printLineSeparator();
        final LottoNumbers winningNumbers = requestWinningNumbers(scanner);
        printResult(payment.getMoney(), tickets.prizeMap(winningNumbers, null));
    }

    private LottoPayment requestPayment(final Scanner scanner) {
        System.out.println(PAYMENT.getMessage());
        try {
            final LottoPayment payment = LottoPayment.convertAndCreate(scanner.nextLine());
            printPaymentResult(payment);
            return payment;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestPayment(scanner);
        }
    }

    private void printPaymentResult(final LottoPayment payment) {
        System.out.println(String.format("%d개를 구매했습니다.", payment.getPurchasableAmount()));
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

    public void printResult(final int payment, final Map<Prize, Integer> prizeMap) {
        System.out.println(RESULT.getMessage());
        printPrizes(prizeMap);
        printReturnOfRatio(PrizeCalculator.returnOfRatio(payment, prizeMap));
    }

    private void printPrizes(final Map<Prize, Integer> prizeMap) {
        for (final int matchCount : PRINTABLE_MATCH_COUNTS) {
            final Prize prize = Prize.checkPrize(matchCount, false);
            System.out.println(prize.resultMessage(prizeMap.get(prize)));
        }
    }

    private void printReturnOfRatio(final double returnOfRatio) {
        String message = "총 수익률은 " + String.format("%.2f", returnOfRatio) + "입니다.";
        System.out.println(message + (returnOfRatio > 1 ? WIN.getMessage() : LOSE.getMessage()));
    }
}
