package step3.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step3.domain.Number;
import step3.domain.UniqueNumbers;

public class NumbersGenerator {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int MAX_SELECT_NUMBER = 6;

    public static UniqueNumbers random() {
        List<Number> numbers = generateNumbers();
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, MAX_SELECT_NUMBER);
        return UniqueNumbers.generate(numbers);
    }

    private static List<Number> generateNumbers() {
        return IntStream.range(START_NUMBER, END_NUMBER)
                .boxed()
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
