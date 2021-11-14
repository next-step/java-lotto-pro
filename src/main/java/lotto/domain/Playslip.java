package lotto.domain;

public class Playslip {

    private static final int NUMBER_CONTAINED = 1;

    private final PickedNumbers pickedNumbers;

    public Playslip(final PickedNumbers pickedNumbers) {
        this.pickedNumbers = pickedNumbers;
    }

    public boolean contains(PickedNumbers winningNumbers, int x) {
        return pickedNumbers.contains(winningNumbers, x);
    }

    public boolean contains(Number bonusNumber) {
        return pickedNumbers.contains(bonusNumber) == NUMBER_CONTAINED;
    }

    public String asString() {
        return pickedNumbers.asString();
    }
}
