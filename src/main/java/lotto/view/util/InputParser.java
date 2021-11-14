package lotto.view.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.Payment;

public class InputParser {
    private static final String NUMBER_DELIMITER = ",";

    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern LOTTO_NUMBER_PATTERN = Pattern.compile("\\d+(" + NUMBER_DELIMITER + "\\d+){5}");

    private static final String INVALID_NUMBER_INPUT_ERR_MSG = "숫자만 입력 가능합니다.";
    private static final String INVALID_LOTTO_NUMBER_INPUT_ERR_MSG = "잘못된 형식의 로또 번호입니다.";

    private InputParser() {
    }

    public static Payment toPayment(String payment) {
        return new Payment(toInteger(payment));
    }

    public static Number toNumber(String number) {
        return Number.of(toInteger(number));
    }

    public static int toInteger(String input) {
        validateNumberPattern(input);
        return Integer.parseInt(input);
    }

    public static Lotto toLotto(String inputNumbers) {
        String inputWithoutBlanks = inputNumbers.replace(" ", "");
        validateLottoPattern(inputWithoutBlanks);
        List<Number> numbers = Arrays.stream(inputWithoutBlanks.split(NUMBER_DELIMITER))
            .map(number -> Number.of(Integer.parseInt(number)))
            .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    private static void validateNumberPattern(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT_ERR_MSG);
        }
    }

    private static void validateLottoPattern(String lottoNumbers) {
        if (!LOTTO_NUMBER_PATTERN.matcher(lottoNumbers).matches()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_INPUT_ERR_MSG);
        }
    }
}
