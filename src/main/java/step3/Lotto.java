package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int MAX_SELECT_NUMBER = 6;

    private final LottoNumbers numbers;

    private Lotto() {
        List<Integer> numbers = generateAutoNumbers();
        this.numbers = LottoNumbers.generate(numbers);
    }

    private List<Integer> generateAutoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int number = START_NUMBER; number <= END_NUMBER; number++) {
            numbers.add(number);
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, MAX_SELECT_NUMBER);
        Collections.sort(numbers);
        return numbers;
    }

    public static Lotto generate() {
        return new Lotto();
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }
}
