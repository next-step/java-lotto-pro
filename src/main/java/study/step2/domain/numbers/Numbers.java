package study.step2.domain.numbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
        validateNumbers();
    }

    public static Numbers of(String[] textNumbers) {
        List<Integer> numbers = Arrays.stream(textNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        return new Numbers(numbers);
    }

    private void validateNumbers() {
        if(hasMinusNumber()) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private boolean hasMinusNumber() {
        return this.numbers.stream().anyMatch(i -> i < 0);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public int sum() {
        return this.numbers.stream().reduce(0, Integer::sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Numbers numbers1 = (Numbers) o;

        return numbers.equals(numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }
}
