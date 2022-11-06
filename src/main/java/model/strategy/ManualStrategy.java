package model.strategy;

import java.util.List;

public class ManualStrategy implements NumberStrategy {

    private final List<Integer> manualNumber;

    public ManualStrategy(List<Integer> inputNumber) {
        this.manualNumber = inputNumber;
    }

    @Override
    public List<Integer> shuffle() {
        return manualNumber;
    }
}
