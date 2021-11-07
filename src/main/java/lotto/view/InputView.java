package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import lotto.model.LottoNumbers;
import lotto.model.Payment;

public class InputView {
    private static final String NUMBER_DELIMITER = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern LOTTO_NUMBER_PATTERN = Pattern.compile("\\d+(" + NUMBER_DELIMITER + "\\d+){5}");

    private static final String QUERY_FOR_PAYMENT = "구입금액을 입력해주세요.";
    private static final String QUERY_FOR_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INVALID_PAYMENT_INPUT_ERR_MSG = "구입 금액은 숫자만 입력해야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_INPUT_ERR_MSG = "잘못된 형식의 로또 번호입니다.";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    private InputView() {
    }

    public static Payment readPaymentHandlingException() {
        return handleException(InputView::readPayment);
    }

    private static Payment readPayment() {
        System.out.println(QUERY_FOR_PAYMENT);
        String payment = readLine();
        if (!NUMBER_PATTERN.matcher(payment).matches()) {
            throw new IllegalArgumentException(INVALID_PAYMENT_INPUT_ERR_MSG);
        }
        return new Payment(Integer.parseInt(payment));
    }

    public static LottoNumbers readWinningNumbersHandlingException() {
        return handleException(InputView::readWinningNumbers);
    }

    private static LottoNumbers readWinningNumbers() {
        System.out.println(QUERY_FOR_WINNING_NUMBERS);
        String winningNumbers = readLine().replace(" ", "");
        if (!LOTTO_NUMBER_PATTERN.matcher(winningNumbers).matches()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_INPUT_ERR_MSG);
        }
        return new LottoNumbers(
            Arrays.stream(winningNumbers.split(NUMBER_DELIMITER)).mapToInt(Integer::parseInt).toArray()
        );
    }

    private static <T> T handleException(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            return handleException(supplier);
        }
    }

    private static String readLine() {
        try {
            return BUFFERED_READER.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
