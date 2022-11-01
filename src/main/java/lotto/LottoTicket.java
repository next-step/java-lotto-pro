package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoTicket {

    private static final Money DEFAULT_FEE = Money.wons(1000);
    private static final int SIZE = 6;

    private final Money fee;
    private final List<LottoNumber> numbers;

    public LottoTicket(final List<LottoNumber> numbers) {
        this(DEFAULT_FEE, numbers);
    }

    public LottoTicket(final Money fee, final List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
        this.fee = fee;
    }

    public static LottoTicket of(final int... numbers) {
        return new LottoTicket(mapToLottoNumberList(numbers));
    }

    public static LottoTicket of(final Money fee, final int... numbers) {
        return new LottoTicket(fee, mapToLottoNumberList(numbers));
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

        numbers.forEach(LottoTicket::validateNumber);

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

    public LottoMatchResult matchTo(final LottoTicket other) {
        final int matchedCount = (int) numbers.stream()
            .filter(other::containsNumber)
            .count();
        return LottoMatchResult.fromCount(matchedCount);
    }

    private boolean containsNumber(final LottoNumber other) {
        return numbers.contains(other);
    }

    public Money getFee() {
        return fee;
    }

}
