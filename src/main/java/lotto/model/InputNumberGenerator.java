package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class InputNumberGenerator implements NumberGenerator {

    private final List<Number> numberList = new ArrayList<>();
    private static final int SIZE = 6;
    private static final String DEFAULT_DELIMITER = ",";
    private static final String WHITE_SPACE = "\\s";
    private static final String EMPTY_STRING = "";

    public InputNumberGenerator(String input) {
        String[] inputList = input.replaceAll(WHITE_SPACE, EMPTY_STRING).split(DEFAULT_DELIMITER);
        for (String number : inputList) {
            numberList.add(new Number(number));
        }
        invalidInputCheck();
    }

    public List<Number> pickNumbers() {
        return numberList;
    }

    private void invalidInputCheck() {
        if (numberList.stream().distinct().count() != SIZE) {
            throw new IllegalArgumentException("당첨 번호는 중복이 없는 " + SIZE + "개의 숫자입니다.");
        }
    }
}
