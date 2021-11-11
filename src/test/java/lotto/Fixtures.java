package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Number;
import lotto.domain.PickedNumbers;

public class Fixtures {

    public static final PickedNumbers winningNumbers = Fixtures.createNumbers(
        Arrays.asList(1, 2, 3, 4, 5, 6)
    );

    public static PickedNumbers createNumbers(List<Integer> numbers) {
        return new PickedNumbers(numbers.stream().map(Number::new).collect(Collectors.toList()));
    }
}
