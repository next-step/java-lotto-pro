package lotto.view;

import java.util.Arrays;
import java.util.regex.Pattern;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.Payment;
import lotto.util.Console;

public class InputView {
    private static final String NUMBER_DELIMITER = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern LOTTO_NUMBER_PATTERN = Pattern.compile("\\d+(" + NUMBER_DELIMITER + "\\d+){5}");

    private static final String QUERY_FOR_PAYMENT = "구입금액을 입력해주세요.";
    private static final String QUERY_FOR_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String QUERY_FOR_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUERY_FOR_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INVALID_NUMBER_INPUT_ERR_MSG = "숫자만 입력 가능합니다.";
    private static final String INVALID_LOTTO_NUMBER_INPUT_ERR_MSG = "잘못된 형식의 로또 번호입니다.";

    private InputView() {
    }

    public static Payment readPayment() {
        System.out.println(QUERY_FOR_PAYMENT);
        String payment = Console.readLine();
        validateNumberPattern(payment);
        return new Payment(Integer.parseInt(payment));
    }

    public static int readManualLottoCount() {
        System.out.println(QUERY_FOR_MANUAL_LOTTO_COUNT);
        String manualLottoCount = Console.readLine();
        validateNumberPattern(manualLottoCount);
        return Integer.parseInt(manualLottoCount);
    }

    public static Lotto readWinningLotto() {
        System.out.println(QUERY_FOR_WINNING_NUMBERS);
        String winningNumbers = Console.readLine().replace(" ", "");
        if (!LOTTO_NUMBER_PATTERN.matcher(winningNumbers).matches()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_INPUT_ERR_MSG);
        }
        int[] parsedWinningNumbers = Arrays.stream(winningNumbers.split(NUMBER_DELIMITER))
            .mapToInt(Integer::parseInt)
            .toArray();
        return new Lotto(parsedWinningNumbers);
    }

    public static Number readBonusNumber() {
        System.out.println(QUERY_FOR_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        validateNumberPattern(bonusNumber);
        return Number.of(Integer.parseInt(bonusNumber));
    }

    private static void validateNumberPattern(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT_ERR_MSG);
        }
    }
}
