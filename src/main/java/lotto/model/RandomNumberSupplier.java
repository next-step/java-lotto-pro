package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberSupplier {
    private RandomNumberSupplier() {
    }

    public static Set<Number> generateNumbers() {
        List<Number> numbers = new ArrayList<>();
        for (int i = Number.MIN_NUMBER; i <= Number.MAX_NUMBER; i++) {
            numbers.add(Number.ofValue(i));
        }
        Collections.shuffle(numbers);
        Set<Number> chosenNumbers = new HashSet<>(numbers.subList(0, LottoNumbers.NUMBER_SIZE));
        return Collections.unmodifiableSet(chosenNumbers);
    }
}
