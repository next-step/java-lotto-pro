package lotto.domain;

public class Playslip {

    private final PickedNumbers pickedNumbers;

    public Playslip(final PickedNumbers pickedNumbers) {
        this.pickedNumbers = pickedNumbers;
    }

    public String asString() {
        return pickedNumbers.asString();
    }

    public Prize checkResult(final PickedNumbers winningNumbers, final Number bonusNumber) {
        final int matchingNumbersCount = pickedNumbers.count(winningNumbers);
        if (isSecondPrize(matchingNumbersCount, bonusNumber)) {
            return Prize.SECOND;
        }
        return Prize.matchCountOf(matchingNumbersCount);
    }

    private boolean isSecondPrize(final int matchingNumbersCount, final Number bonusNumber) {
        return Prize.isSecond(matchingNumbersCount) && pickedNumbers.contains(bonusNumber);
    }
}
