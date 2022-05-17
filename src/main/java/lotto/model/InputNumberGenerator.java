package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputNumberGenerator implements NumberGenerator {

    private final Set<Number> numberList = new HashSet<>();
    private static final int LOTTO_SIZE = 6;
    private static final String DEFAULT_DELIMITER = ",";
    private static final String WHITE_SPACE = "\\s";
    private static final String EMPTY_STRING = "";

    public InputNumberGenerator(String inputs) {
        String[] inputList = inputs.replaceAll(WHITE_SPACE, EMPTY_STRING).split(DEFAULT_DELIMITER);
        for (String input : inputList) {
            numberList.add(new Number(input));
        }
        invalidInputCheck();
    }

    public List<Number> pickNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(numberList));
    }

    private void invalidInputCheck() {
        if (numberList.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 중복이 없는 " + LOTTO_SIZE + "개의 숫자입니다.");
        }
    }
}
