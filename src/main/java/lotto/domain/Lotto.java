package lotto.domain;

import lotto.view.Error;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    public static void validate(List<LottoNumber> numbers) throws IllegalArgumentException {
        validateNumbersSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateNumbersSize(List<LottoNumber> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_LENGTH);
        }
    }

    private static void validateDuplicate(List<LottoNumber> numbers) throws IllegalArgumentException {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_DUPLICATE);
        }
    }

    public boolean hasBonusBall(LottoNumber bonusBall) {
        return numbers.contains(bonusBall);
    }

    public int getCorrectCount(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
