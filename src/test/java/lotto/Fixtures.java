package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Fixtures {

    public static PickedNumbers createNumbers(List<Integer> numbers) {
        return new PickedNumbers(numbers.stream().map(Number::new).collect(Collectors.toList()));
    }
}
