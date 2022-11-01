package lotto;

import java.util.HashSet;
import java.util.List;

public final class Lotto {

    private static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(final List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private static void validateNumbers(final List<LottoNumber> numbers) {
        if (numbers == null) {
            throw new LottoException("numbers cannot be null");
        }
        if (numbers.size() != SIZE) {
            throw new LottoException(String.format("numbers size should be %d", SIZE));
        }

        numbers.forEach(Lotto::validateNumber);

        if (!isUnique(numbers)) {
            throw new LottoException("all numbers should be unique");
        }
    }

    private static void validateNumber(final LottoNumber number) {
        if (number == null) {
            throw new LottoException("number cannot be null");
        }
    }

    private static boolean isUnique(final List<LottoNumber> numbers) {
        return numbers.size() == new HashSet<>(numbers).size();
    }
}
