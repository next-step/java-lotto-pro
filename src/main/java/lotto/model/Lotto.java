package lotto.model;

import lotto.view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        valid(numbers);
        lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
    }

    private void valid(List<Integer> numbers) {
        if (numbers == null) {
            throw new NullPointerException(ErrorMessage.LOTTO_NULL);
        }
        if (numbers.size() > SIZE || numbers.size() < SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_UNMATCHED);
        }
    }

    public int size() {
        return lottoNumbers.size();
    }

    private boolean compare(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Rank matchNumber(Lotto winLotto) {
        int result = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            result += winLotto.compare(lottoNumber) ? 1 : 0;
        }
        return Rank.valueOf(result);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }


}
