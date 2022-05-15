package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.validator.WinningNumberValidatorGroup;

public class WinningNumbers {
    public static final String SPLIT_SYMBOL = ",";

    private final List<Integer> winningNumbers;
    private static final WinningNumberValidatorGroup validatorGroup = WinningNumberValidatorGroup.getInstance();

    public WinningNumbers(String winningNumbersInput) {
        validatorGroup.validate(winningNumbersInput);
        this.winningNumbers = splitWinningNumbers(winningNumbersInput);
    }

    private List<Integer> splitWinningNumbers(String winningNumbersInput) {
        return Stream.of(winningNumbersInput.split(SPLIT_SYMBOL)).mapToInt(
            Integer::parseInt).boxed().collect(
            Collectors.toList());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
