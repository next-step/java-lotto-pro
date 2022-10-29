package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Integer> numbers;

    private Numbers() {
        throw new RuntimeException("Cannot use default constructor.");
    }

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean isDuplicated() {
        int size = numbers.size();
        long distinct = numbers.stream().distinct().count();
        return size != distinct;
    }

    public static Numbers generate(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    public int match(Numbers selectNumbers) {
        if (numbers.size() != selectNumbers.numbers.size()) {
            throw new IndexOutOfBoundsException("Incomparable subject. please check lottoNumbers size.");
        }
        return (int) numbers.stream()
                .filter(selectNumbers.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
