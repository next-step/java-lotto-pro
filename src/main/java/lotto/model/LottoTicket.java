package lotto.model;

import lotto.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
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
        if (numbers == null || numbers.size() != LottoConstants.LOTTO_SIZE) {
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
            result += count(number);
        }
        return result;
    }

    private int count(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber) ? 1 : 0;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }
}
