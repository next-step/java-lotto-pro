package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 6;
    private static final String PRINT_FORM = "%s";
    private static final String PRINT_DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto() {
        numbers = createNumbers();
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

    private List<Integer> createNumbers() {
        List<Integer> preparedNumbers = LottoNumbers.PREPARED_NUMBERS;
        Collections.shuffle(preparedNumbers);
        List<Integer> resultNumbers = new ArrayList<>(preparedNumbers.subList(START_INDEX, END_INDEX));
        Collections.sort(resultNumbers);
        return resultNumbers;
    }
}
