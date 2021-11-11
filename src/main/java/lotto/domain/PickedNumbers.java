package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PickedNumbers {

    public static final int SIZE = 6;

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

    public int size() {
        return pickedNumbers.size();
    }

    public boolean contains(PickedNumbers other, int x) {
        int numberOfMatchingNumbers = 0;
        for (int i = 0; i < pickedNumbers.size(); i++) {
            numberOfMatchingNumbers += contains(other.pickedNumbers.get(i));
        }
        return numberOfMatchingNumbers == x;
    }

    private int contains(Number pickedNumber) {
        return pickedNumbers.contains(pickedNumber) ? 1 : 0;
    }
}
