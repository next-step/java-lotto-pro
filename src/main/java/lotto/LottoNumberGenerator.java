package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private final List<Integer> numbers = new ArrayList<>();

    LottoNumberGenerator() {
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> generateSixNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
