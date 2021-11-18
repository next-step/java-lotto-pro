package lotto.domain;

public class WinningNumbers {

    private final PickedNumbers winningNumbers;
    private final Number bonusNumber;

    public WinningNumbers(final PickedNumbers winningNumbers, final Number bonusNumber) {
        validateNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNumbers(final PickedNumbers winningNumbers, final Number bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼은 일치할 수 없습니다.");
        }
    }

    public Prize checkNumbers(final PickedNumbers pickedNumbers) {
        final int matchingNumbersCount = pickedNumbers.count(winningNumbers);
        if (Prize.isSecond(matchingNumbersCount)) {
            return pickedNumbers.contains(bonusNumber) ? Prize.SECOND : Prize.THIRD;
        }
        return Prize.matchCountOf(matchingNumbersCount);
    }
}
