package lotto.domain;

import static lotto.constants.LottoConstants.SPLIT_SYMBOL;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.validator.WinningNumberValidatorGroup;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private static final WinningNumberValidatorGroup validatorGroup = WinningNumberValidatorGroup.getInstance();

    public WinningNumbers(String winningNumbersInput) {
        winningNumbersInput = replaceBlank(winningNumbersInput);
        validatorGroup.validate(winningNumbersInput);
        this.winningNumbers = splitWinningNumbers(winningNumbersInput);
    }

    private String replaceBlank(String winningNumbersInput) {
        return winningNumbersInput.replace(" ", "");
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
