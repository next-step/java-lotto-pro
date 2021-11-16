package lotto.domain;

public class Playslip {

    private static final int NUMBER_CONTAINED = 1;

    private final PickedNumbers pickedNumbers;

    public Playslip(final PickedNumbers pickedNumbers) {
        this.pickedNumbers = pickedNumbers;
    }

    public String asString() {
        return pickedNumbers.asString();
    }

    public Prize checkResult(PickedNumbers winningNumbers, Number bonusNumber) {
        Prize result = Prize.NONE;
        for (Prize prize : Prize.values()) {
            result = checkResult(winningNumbers, bonusNumber, prize);
            if (result != Prize.NONE) {
                break;
            }
        }
        return result;
    }

    private Prize checkResult(
        final PickedNumbers winningNumbers,
        final Number bonusNumber,
        final Prize prize
    ) {
        if (prize == Prize.SECOND && pickedNumbers.contains(bonusNumber) == NUMBER_CONTAINED) {
            return Prize.SECOND;
        }
        if (pickedNumbers.contains(winningNumbers, prize.getMatchCount())) {
            return prize;
        }
        return Prize.NONE;
    }
}
