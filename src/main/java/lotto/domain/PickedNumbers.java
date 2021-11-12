package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PickedNumbers {

    public static final int SIZE = 6;

    private static final int NUMBER_NOT_CONTAINED = 0;
    private static final int NUMBER_CONTAINED = 1;

    private final List<Number> pickedNumbers;

    public PickedNumbers(List<Number> pickedNumbers) {
        validateSize(pickedNumbers);
        validateDuplicates(pickedNumbers);
        this.pickedNumbers = new ArrayList<>(pickedNumbers);
    }

    public static PickedNumbers of(final String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
            .map(Number::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), PickedNumbers::new));
    }

    private void validateSize(final List<Number> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자로 생성할 수 있습니다.");
        }
    }

    private void validateDuplicates(final List<Number> numbers) {
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복 선택할 수 없습니다.");
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

    public String asString() {
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
