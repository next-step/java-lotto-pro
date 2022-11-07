package step3.model;

import step3.service.LottoGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 당첨 번호
 */
public class LottoWinningNumber {

    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this(winningNumbers);
        this.bonusNumber = bonusNumber;
        validateUniqueBonus(winningNumbers, bonusNumber);
    }

    private void validateUniqueBonus(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new RuntimeException("번호가 동일한게 존재합니다.");
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNull(winningNumbers);
        validateSizeSixNumbers(winningNumbers);
        validateDuplicatedNumbers(winningNumbers);
        isExceedRange(winningNumbers);
    }

    private void validateDuplicatedNumbers(List<Integer> winningNumbers) {
        if (isDuplicated(winningNumbers)) {
            throw new RuntimeException("증복된 숫자가 있습니다.");
        }
    }

    private void validateSizeSixNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new RuntimeException("6자리 수만 입력받을수있습니다.");
        }
    }

    private void validateNull(List<Integer> winningNumbers) {
        if (winningNumbers == null) {
            throw new RuntimeException("행운의번호가 널입니다.");
        }
    }

    private void isExceedRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            isNotBetween(number);
        }
    }

    private void isNotBetween(int number) {
        if (number < LottoGenerator.LOTTO_START_NUMBER || number > LottoGenerator.LOTTO_END_NUMBER) {
            throw new RuntimeException("로또범위의 숫자가 아닙니다.");
        }
    }

    private boolean isDuplicated(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        return uniqueNumbers.size() != winningNumbers.size();
    }

    public boolean containWinningNumber(int lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean isMatchedBonusNumber(int lottoNumber) {
        return lottoNumber == bonusNumber;
    }
}
