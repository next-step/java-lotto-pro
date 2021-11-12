package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    public static final Money SELLING_PRICE = new Money(1000);
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    protected LottoTicket(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static LottoTicket of(List<Integer> numbers) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new LottoTicket(lottoNumbers);
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

    public Winning calculateWinning(WinTicket winTicket) {
        final int count = calculateNumberOfMatch(winTicket);
        final boolean bonus = numbers.contains(winTicket.getBonusNumber());
        return Winning.of(count, bonus);
    }

    int calculateNumberOfMatch(LottoTicket ticket) {
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

}
