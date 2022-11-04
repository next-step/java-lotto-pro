package lotto;

import java.util.Arrays;
import java.util.List;

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

    public List<Integer> give() {
        --count;
        return Arrays.asList(inputManualNumber.give());
    }
}
