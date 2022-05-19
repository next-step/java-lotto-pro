package lotto.domain;

import static lotto.constants.LottoConstants.SPLIT_SYMBOL;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.validator.LottoNumbersValidatorGroup;
import lotto.exception.ExceptionType;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private BonusNumber bonusNumber;
    private static final LottoNumbersValidatorGroup validatorGroup = LottoNumbersValidatorGroup.getInstance();

    public WinningNumbers(String winningNumbersInput) {
        winningNumbersInput = replaceBlank(winningNumbersInput);
        validatorGroup.validate(winningNumbersInput);
        this.winningNumbers = splitWinningNumbers(winningNumbersInput);
    }

    public void addBonusNumber(BonusNumber bonusNumber) {
        validateOverlapNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateOverlapNumber(BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(ExceptionType.ALREADY_EXISTS_WINNINGS_NUMBER.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public boolean isContainsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }

    public int bonusCount(Lotto lotto) {
        if (isContainsBonusNumber(lotto)) {
            return 1;
        }

        return 0;
    }

    private String replaceBlank(String winningNumbersInput) {
        return winningNumbersInput.replace(" ", "");
    }

    private Lotto splitWinningNumbers(String winningNumbersInput) {
        List<Integer> numbers = Stream.of(winningNumbersInput.split(SPLIT_SYMBOL))
            .mapToInt(Integer::parseInt)
            .boxed().collect(Collectors.toList());

        return new Lotto(numbers);
    }
}
