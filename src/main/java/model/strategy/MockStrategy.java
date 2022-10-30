package model.strategy;

import java.util.List;

public class MockStrategy implements NumberStrategy{

    List<Integer> mockNumber;

    public MockStrategy(List<Integer> inputNumber) {
        this.mockNumber = inputNumber;
    }

    @Override
    public List<Integer> shuffle() {
        return mockNumber;
    }
}
