package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueNumbers {

    private final List<Number> numbers;

    private UniqueNumbers(List<Number> numbers) {
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    public static UniqueNumbers generate(List<Number> numbers) {
        Collections.sort(numbers);
        return new UniqueNumbers(numbers);
    }

    public int match(UniqueNumbers selectNumbers) {
        return (int) numbers.stream()
                .filter(selectNumbers::contains)
                .count();
    }

    private void validateDuplicated(List<Number> numbers) {
        int size = numbers.size();
        long distinct = numbers.stream().distinct().count();
        if (size != distinct) {
            throw new IllegalArgumentException("Duplicate numbers cannot input.");
        }
    }

    public boolean isEqualSize(UniqueNumbers numbers) {
        return this.numbers.size() == numbers.numbers.size();
    }

    public boolean contains(Number lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
