package lotto;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGeneratorUtil {

    public static List<Integer> generate() {
        List<Integer> numbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(toList());
        Collections.shuffle(numbers);
        Collections.sort(numbers);
        return numbers.subList(0, 6);
    }
}
