package lotto.model;

import java.util.Arrays;

public class LottoNumbersInput {
    private static final String DELIMITER = ",";

    private final String input;


    public LottoNumbersInput(String numbersText) {
        this.input = checkInput(numbersText);
    }

    public String value() {
        return this.input;
    }

    public String[] toArray() {
        return Arrays.stream(this.input.split(DELIMITER)).map(String::trim).toArray(String[]::new);
    }

    private String checkInput(String numbersText) {
        String[] numbers = numbersText.split(DELIMITER);
        if (numbers.length != 6) {
            throw new IllegalArgumentException("6개 입력해야합니다.");
        }

        if (Arrays.stream(numbers).anyMatch(number -> number.matches("[^0-9]+"))) {
            throw new IllegalArgumentException("슷자만 입력가능합니다.");
        }

        if (Arrays.stream(numbers).distinct().count() != numbers.length) {
            throw new IllegalArgumentException("중복된 숫자는 입력이 불가합니다.");
        }
        return numbersText;
    }
}
