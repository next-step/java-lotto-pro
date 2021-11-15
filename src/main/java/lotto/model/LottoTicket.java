package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.model.LottoNumber.MAX_VALUE;
import static lotto.model.LottoNumber.MIN_VALUE;

public class LottoTicket {
    public static final Money SELLING_PRICE = new Money(1000);
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    private LottoTicket(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static int countPurchasable(Money money) {
        if (money.isZero()) {
            return 0;
        }
        return (int) money.divideBy(SELLING_PRICE);
    }

    public static LottoTicket of(List<Integer> numbers) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket ofRandomNumbers() {
        final List<Integer> numbers = LottoTicket.getRandomNumbers();
        return LottoTicket.of(numbers);
    }

    private static List<Integer> getRandomNumbers() {
        final List<Integer> allNumbers = getAllNumbers();
        Collections.shuffle(allNumbers);
        final List<Integer> pickedNumbers = new ArrayList<>(allNumbers.subList(0, LOTTO_SIZE));
        Collections.sort(pickedNumbers);
        return pickedNumbers;
    }

    private static List<Integer> getAllNumbers() {
        final List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    public Rank calculateWinning(WinTicket winTicket) {
        final int count = winTicket.calculateNumberOfMatch(this);
        final boolean bonus = winTicket.matchBonusNumber(numbers);
        return Rank.of(count, bonus);
    }

    public int calculateNumberOfMatch(LottoTicket ticket) {
        int result = 0;
        for (LottoNumber number : ticket.numbers) {
            result += count(number);
        }
        return result;
    }

    private int count(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber) ? 1 : 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
