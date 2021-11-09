package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static LottoNumbers of(List<Integer> numbers) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new LottoNumbers(lottoNumbers);
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

    public int calculateNumberOfMatch(LottoNumbers winNumbers) {
        int result = 0;
        for (LottoNumber winNumber : winNumbers.numbers) {
            result += countIfMatch(winNumber);
        }
        return result;
    }

    private int countIfMatch(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber) ? 1 : 0;
    }
}
