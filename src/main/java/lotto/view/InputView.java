package lotto.view;

import java.util.*;
import java.util.stream.*;

public class InputView {
    private static final String INPUT_PAYMENT_STATEMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_TICKET_COUNT_STATEMENT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBERS_TO_PURCHASE_MANUALLY_STATEMENT = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_STATEMENT = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNING_NUMBERS_STATEMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private static String inputString() {
        return SCANNER.nextLine().trim();
    }

    private static List<Integer> inputLottoNumbers() {
        return Arrays.stream(inputString()
                .trim()
                .split(","))
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_LAST_WEEK_WINNING_NUMBERS_STATEMENT);
        return inputLottoNumbers();
    }

    public int inputPayment() {
        System.out.println(INPUT_PAYMENT_STATEMENT);
        return Integer.parseInt(inputString());
    }

    public int inputManualTicketCount() {
        System.out.print(System.lineSeparator());
        System.out.println(INPUT_MANUAL_TICKET_COUNT_STATEMENT);
        return Integer.parseInt(inputString());
    }

    public List<List<Integer>> inputLottoNumbersAsManyTimesOf(int times) {
        System.out.print(System.lineSeparator());
        System.out.println(INPUT_LOTTO_NUMBERS_TO_PURCHASE_MANUALLY_STATEMENT);
        return Stream.generate(InputView::inputLottoNumbers)
            .limit(times)
            .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_STATEMENT);
        return Integer.parseInt(inputString());
    }
}
