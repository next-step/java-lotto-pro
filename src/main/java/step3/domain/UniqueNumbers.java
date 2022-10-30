package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class UniqueNumbers {

    private final List<Integer> numbers;

    private UniqueNumbers(List<Integer> numbers) {
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    public static UniqueNumbers generate(List<Integer> numbers) {
        return new UniqueNumbers(numbers);
    }

    public int match(UniqueNumbers selectNumbers) {
        return (int) numbers.stream()
                .filter(selectNumbers.numbers::contains)
                .count();
    }

    public void validateDuplicated(List<Integer> numbers) {
        int size = numbers.size();
        long distinct = numbers.stream().distinct().count();
        if (size != distinct) {
            throw new IllegalArgumentException("Duplicate numbers cannot input.");
        }
    }

    public boolean isEqualSize(UniqueNumbers numbers) {
        return this.numbers.size() == numbers.numbers.size();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
