package lotto.domain;

public class Playslip {

    private final PickedNumbers pickedNumbers;

    public Playslip(final PickedNumbers pickedNumbers) {
        this.pickedNumbers = pickedNumbers;
    }

    public Prize checkResult(final WinningNumbers winningNumbers) {
        return winningNumbers.checkNumbers(pickedNumbers);
    }

    public String asString() {
        return pickedNumbers.asString();
    }
}
