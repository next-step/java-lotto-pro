package generator;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator{

    private final List<Integer> numbers;

    public TestNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return this.numbers;
    }
}
