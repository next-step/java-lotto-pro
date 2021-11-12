package lotto.util;

import static lotto.util.Validator.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.Payment;

public class InputParser {
    static final String NUMBER_DELIMITER = ",";

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
}
