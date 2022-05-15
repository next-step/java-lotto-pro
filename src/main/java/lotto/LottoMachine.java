package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final List<Number> NUMBERS = IntStream.rangeClosed(1, 45).mapToObj(Number::new).collect(Collectors.toList());

    public static List<Number> getRandomNumbers() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.subList(0, 6);
    }

}
