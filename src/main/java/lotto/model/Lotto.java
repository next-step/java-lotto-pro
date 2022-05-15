package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MAX_NUMBER = 45;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 6;
    private static final String PRINT_FORM = "%s";
    private static final String PRINT_DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto() {
        numbers = prepareNumbers();
    }

    public Lotto(Integer... customNumbers) {
        numbers = Arrays.asList(customNumbers);
    }

    public List<Integer> seeNumbers() {
        return this.numbers;
    }

    public String printText() {
        return String.format(PRINT_FORM, String.join(PRINT_DELIMITER, this.numbers.toString()));
    }

    private List<Integer> prepareNumbers() {
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            results.add(i);
        }
        Collections.shuffle(results);
        results = results.subList(START_INDEX, END_INDEX);
        Collections.sort(results);
        return results;
    }
}
