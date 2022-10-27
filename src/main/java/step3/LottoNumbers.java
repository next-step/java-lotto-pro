package step3;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> numbers;

    private LottoNumbers() {
        this.numbers = new ArrayList<>();
    }

    private LottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static LottoNumbers generate(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public int getSize() {
        return numbers.size();
    }

    public int match(LottoNumbers selectNumbers) {
        if (numbers.size() != selectNumbers.getSize()) {
            throw new IndexOutOfBoundsException("Incomparable subject. please check lottoNumbers size.");
        }
        return (int) numbers.stream()
                .filter(selectNumbers.numbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        int size = numbers.size();
        long count = numbers.stream().distinct().count();
        if (size != count) {
            throw new IllegalArgumentException("Duplicate numbers cannot input.");
        }
    }
}
