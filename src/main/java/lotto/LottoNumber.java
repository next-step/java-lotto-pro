package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    public static final int LOTTO_NUMBERS_COUNT = 6;
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        //todo 여기서 정렬해야할까?
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalStateException();
        }
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalStateException();
        }
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalStateException();
        }
    }
}
