package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int SIZE = 6;
    private static final List<Number> numberList = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(Number::new)
            .collect(Collectors.toList());

    public List<Number> pickNumbers() {
        Collections.shuffle(numberList);
        return Collections.unmodifiableList(numberList.stream()
                .limit(SIZE)
                .collect(Collectors.toList()));
    }
}
