package lotto.view;

import static lotto.domain.message.RequestMessage.PAYMENT;
import static lotto.domain.message.RequestMessage.WINNING_NUMBERS;

import java.util.Scanner;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;

public class LottoPresenter {
    public void present() {
        final Scanner scanner = new Scanner(System.in);
        final LottoPayment payment = requestPayment(scanner);
        final LottoTickets tickets = new LottoTickets(payment);
        tickets.print();
        final LottoNumbers winningNumbers = requestWinningNumbers(scanner);
        new LottoResult(payment, tickets, winningNumbers).printResult();
    }

    private LottoPayment requestPayment(final Scanner scanner) {
        System.out.println(PAYMENT.getMessage());
        try {
            final LottoPayment payment = new LottoPayment(scanner.nextLine());
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

    private LottoNumbers requestWinningNumbers(final Scanner scanner) {
        System.out.println(WINNING_NUMBERS.getMessage());
        try {
            return new LottoNumbers(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestWinningNumbers(scanner);
        }
    }
}
