package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> data;

    public LottoNumbers(List<LottoNumber> data) {
        validate(data);
        this.data = data;
    }

    public static LottoNumbers of(List<Integer> numbers) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new LottoNumbers(lottoNumbers);
    }

    private void validate(List<LottoNumber> data) {
        if (data == null || data.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public int findNumberOfMatch(LottoNumbers winNumbers) {
        int result = 0;
        for (LottoNumber winNumber : winNumbers.data) {
            result += countIfMatch(winNumber);
        }
        return result;
    }

    private int countIfMatch(LottoNumber lottoNumber) {
        return this.data.contains(lottoNumber) ? 1 : 0;
    }
}
