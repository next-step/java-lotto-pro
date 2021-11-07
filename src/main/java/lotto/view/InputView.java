package lotto.view;

import java.util.*;
import java.util.stream.*;

public class InputView {
    private static final String INPUT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNING_NUMBERS_STATEMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private String inputString() {
        return SCANNER.nextLine().trim();
    }

    public int inputPayment() {
        System.out.println(INPUT_PAYMENT);
        return Integer.parseInt(inputString());
    }

    public List<Integer> inputLottoNumbers() {
        System.out.println(INPUT_LAST_WEEK_WINNING_NUMBERS_STATEMENT);
        return Arrays.stream(inputString()
                .trim()
                .split(","))
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(inputString());
    }
}
