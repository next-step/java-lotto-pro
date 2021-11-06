package lotto.view;

import lotto.domain.number.Payment;
import lotto.domain.ticket.LottoNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNING_NUMBERS_STATEMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private String inputString() {
        return SCANNER.nextLine().trim();
    }

    public Payment inputPayment() {
        System.out.println(INPUT_PAYMENT);
        return Payment.from(Integer.parseInt(inputString()));
    }

    public LottoNumbers inputLottoNumbers() {
        System.out.println(INPUT_LAST_WEEK_WINNING_NUMBERS_STATEMENT);
        return LottoNumbers.from(
            Arrays.stream(
                    inputString().trim()
                        .split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList())
        );
    }
}
