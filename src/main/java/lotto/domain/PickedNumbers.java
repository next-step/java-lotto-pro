package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PickedNumbers {

    public static final int SIZE = 6;

    private static final int NUMBER_NOT_CONTAINED = 0;
    private static final int NUMBER_CONTAINED = 1;

    private final List<Number> pickedNumbers;

    public PickedNumbers(List<Number> pickedNumbers) {
        validateSize(pickedNumbers);
        this.pickedNumbers = new ArrayList<>(pickedNumbers);
    }

    public static PickedNumbers of(final String winningNumbers) {
        return new PickedNumbers(
            Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList()));
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

    @Override
    public String toString() {
        return pickedNumbers
            .stream()
            .map(Number::getValue)
            .collect(Collectors.toList())
            .toString();
    }

    private int contains(Number pickedNumber) {
        return pickedNumbers.contains(pickedNumber) ? NUMBER_CONTAINED : NUMBER_NOT_CONTAINED;
    }
}
