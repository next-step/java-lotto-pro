package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
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

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int calculateNumberOfMatch(LottoTicket ticket) {
        int result = 0;
        for (LottoNumber number : ticket.numbers) {
            result += countIfMatch(number);
        }
        return result;
    }

    private int countIfMatch(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber) ? 1 : 0;
    }
}
