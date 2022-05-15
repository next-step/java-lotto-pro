package lotto.view;

import java.util.Scanner;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;

public class LottoPresenter {
    private final String PAYMENT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INVALID_PAYMENT_ERROR_MESSAGE = "구입금액은 1000원 단위로 입력이 가능합니다. 숫자만 입력해주세요.";
    private final String WINNING_NUMBERS_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final String INVALID_WINNING_NUMBERS_ERROR_MESSAGE = "1에서 45까지의 숫자 6개를 입력주세요. 각 숫자는 컴마(,)로 구분됩니다.";

    public void present() {
        final Scanner scanner = new Scanner(System.in);
        final LottoPayment payment = requestPayment(scanner);
        final LottoTickets tickets = new LottoTickets(payment);
        tickets.print();
        final LottoNumbers winningNumbers = requestWinningNumbers(scanner);
        new LottoResult(payment, tickets, winningNumbers).printResult();
    }

    private LottoPayment requestPayment(final Scanner scanner) {
        System.out.println(PAYMENT_REQUEST_MESSAGE);
        try {
            final LottoPayment payment = new LottoPayment(scanner.nextLine());
            printPaymentResult(payment);
            return payment;
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_PAYMENT_ERROR_MESSAGE);
            return requestPayment(scanner);
        }
    }

    private void printPaymentResult(final LottoPayment payment) {
        System.out.println(String.format("%d개를 구매했습니다.", payment.getPurchasableAmount()));
    }

    private LottoNumbers requestWinningNumbers(final Scanner scanner) {
        System.out.println(WINNING_NUMBERS_REQUEST_MESSAGE);
        try {
            return new LottoNumbers(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_WINNING_NUMBERS_ERROR_MESSAGE);
            return requestWinningNumbers(scanner);
        }
    }
}
