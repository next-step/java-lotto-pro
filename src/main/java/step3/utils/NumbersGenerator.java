package step3.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step3.domain.UniqueNumbers;
import step3.io.InputView;

public class NumbersGenerator {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int MAX_SELECT_NUMBER = 6;

    public static UniqueNumbers random() {
        List<Integer> numbers = generateNumbers();
        Collections.shuffle(numbers);
        List<Integer> subNumbers = numbers.subList(0, MAX_SELECT_NUMBER);
        Collections.sort(subNumbers);
        return UniqueNumbers.generate(subNumbers);
    }

    private static List<Integer> generateNumbers() {
        return IntStream.range(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static UniqueNumbers userInput() {
        return UniqueNumbers.generate(InputView.inputManualNumbers());
    }
}
