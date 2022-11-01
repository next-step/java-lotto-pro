package step3.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step3.domain.Number;
import step3.domain.UniqueNumbers;

public class TestNumberProvider {

    public static List<UniqueNumbers> randomUniqueNumbersList(int totalCount) {
        List<UniqueNumbers> uniqueNumbersList = new ArrayList<>();
        for (int count = 0; count < totalCount; count++) {
            uniqueNumbersList.add(NumbersGenerator.random());
        }
        return uniqueNumbersList;
    }

    public static UniqueNumbers rangeUniqueNumbers(int start, int end) {
        List<Number> numbers = rangeNumbers(start, end);
        return UniqueNumbers.generate(numbers);
    }

    public static List<Number> rangeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public static List<Number> numbers(int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
