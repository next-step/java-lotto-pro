package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }

    public static Set<Number> generate() {
        List<Number> numbers = new ArrayList<>();
        for (int i = Number.MIN_NUMBER; i <= Number.MAX_NUMBER; i++) {
            numbers.add(Number.of(i));
        }
        Collections.shuffle(numbers);
        Set<Number> chosenNumbers = new HashSet<>(numbers.subList(0, Lotto.NUMBER_SIZE));
        return Collections.unmodifiableSet(chosenNumbers);
    }
}
