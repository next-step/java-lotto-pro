package lotto.model;

import lotto.view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public boolean isBounsNumber(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
