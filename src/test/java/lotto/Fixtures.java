package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Fixtures {

    public static Numbers createNumbers(List<Integer> numbers) {
        return new Numbers(numbers.stream().map(Number::new).collect(Collectors.toList()));
    }
}
