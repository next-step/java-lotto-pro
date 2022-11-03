package lotto;

public class BuyManualCount {
    private final InputManualNumber inputManualNumber;
    private int count;

    public BuyManualCount(InputManualNumber inputManualNumber, int count) {
        this.inputManualNumber = inputManualNumber;
        this.count = count;
    }

    public boolean hasCount() {
        return this.count > 0;
    }

    public Integer[] give() {
        --count;
        return inputManualNumber.give();
    }
}
