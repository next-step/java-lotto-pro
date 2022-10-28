package step3.domain;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    private Numbers() {
        throw new RuntimeException("Cannot use default constructor.");
    }

    private Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        int size = numbers.size();
        long count = numbers.stream().distinct().count();
        if (size != count) {
            throw new IllegalArgumentException("Duplicate numbers cannot input.");
        }
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
}
