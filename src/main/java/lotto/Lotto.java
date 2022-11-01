package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class Lotto {

    private static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(final List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(final int... numbers) {
        return new Lotto(mapToLottoNumberList(numbers));
    }

    private static List<LottoNumber> mapToLottoNumberList(final int... numbers) {
        if (numbers == null) {
            return Collections.emptyList();
        }
        return Arrays.stream(numbers)
            .mapToObj(LottoNumber::valueOf)
            .collect(Collectors.toList());
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

    public LottoMatchResult matchTo(final Lotto other) {
        final int matchedCount = (int) numbers.stream()
            .filter(other::containsNumber)
            .count();
        return LottoMatchResult.fromCount(matchedCount);
    }

    private boolean containsNumber(final LottoNumber other) {
        return numbers.contains(other);
    }
}
