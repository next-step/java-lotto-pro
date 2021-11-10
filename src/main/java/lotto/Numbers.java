package lotto;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final int SIZE = 6;

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        validateSize(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateSize(final List<Number> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개의 숫자로 생성할 수 있습니다.");
        }
    }
}
