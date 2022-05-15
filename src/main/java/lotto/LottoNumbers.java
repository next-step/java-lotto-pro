package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final static int LOTTO_NUMBER_SIZE_VALUE = 6;
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;

    private List<Integer> numbers;

    public LottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_MAX_VALUE; i++) {
            numbers.add(i+1);
        }
        shuffleNumberList(numbers);
        this.numbers = divideNumberList(numbers);
    }

    private void shuffleNumberList(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }

    private List<Integer> divideNumberList(List<Integer> numbers) {
        return numbers.subList(0, LOTTO_NUMBER_SIZE_VALUE);
    }

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int lottoNumberCount() {
        return LOTTO_NUMBER_SIZE_VALUE;
    }

    public void sortLottoNumber() {
        this.numbers= this.numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int winningCount(List<Integer> answerNumberList) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}

