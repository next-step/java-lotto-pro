package lotto.domain;

import static lotto.constants.LottoConstants.SPLIT_SYMBOL;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.validator.LottoNumbersValidatorGroup;
import lotto.exception.ExceptionType;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private LottoNo bonusNumber;
    private static final LottoNumbersValidatorGroup validatorGroup = LottoNumbersValidatorGroup.getInstance();

    public WinningNumbers(String winningNumbersInput) {
        winningNumbersInput = replaceBlank(winningNumbersInput);
        validatorGroup.validate(winningNumbersInput);
        this.winningNumbers = splitWinningNumbers(winningNumbersInput);
    }

    public void addBonusNumber(LottoNo bonusNumber) {
        validateOverlapNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateOverlapNumber(LottoNo bonusNumber) {
        if (winningNumbers.contains(bonusNumber.getLottoNo())) {
            throw new IllegalArgumentException(ExceptionType.ALREADY_EXISTS_WINNINGS_NUMBER.getMessage());
        }
    }

    public List<LottoNo> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public boolean isContainsBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber.getLottoNo());
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
        List<LottoNo> lottoNumbers = Stream.of(winningNumbersInput.split(SPLIT_SYMBOL))
            .map(LottoNo::new)
            .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    public int getMatchOfCount(Lotto lotto) {
        int countOfMatch = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        countOfMatch += bonusCount(lotto);

        return countOfMatch;
    }
}
