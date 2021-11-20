package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Number;
import lotto.domain.PickedNumbers;
import lotto.domain.WinningNumbers;

public class Fixtures {

    public static final List<PickedNumbers> manuallyPickedNumbers = Arrays.asList(
        Fixtures.createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
        Fixtures.createNumbers(Arrays.asList(40, 41, 42, 43, 44, 45))
    );

    public static final PickedNumbers winningNumbersWithoutBonusNumber = Fixtures.createNumbers(
        Arrays.asList(1, 2, 3, 4, 5, 6)
    );

    public static final Number bonusNumber = new Number(7);

    public static final WinningNumbers winningNumbers = new WinningNumbers(
        winningNumbersWithoutBonusNumber, bonusNumber
    );

    public static PickedNumbers createNumbers(List<Integer> numbers) {
        return new PickedNumbers(numbers.stream().map(Number::new).collect(Collectors.toList()));
    }
}
