package lotto;

import java.util.ArrayList;
import java.util.List;

public class PickedNumbers {

    private static final int SIZE = 6;

    private final List<Number> pickedNumbers;

    public PickedNumbers(List<Number> pickedNumbers) {
        validateSize(pickedNumbers);
        this.pickedNumbers = new ArrayList<>(pickedNumbers);
    }

    private void validateSize(final List<Number> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개의 숫자로 생성할 수 있습니다.");
        }
    }
}
