package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

// 로또
public class Lotto {

    public static final int LOTTO_COUNT = 6;
    private final List<LottoNumber> numbers;
    private int winningNumberMatchCount;

    public Lotto(List<LottoNumber> lottoNumbers) {
        numberCountValid(lottoNumbers);
        numberDuplicateValid(lottoNumbers);
        this.numbers = Collections.unmodifiableList(lottoNumbers);
    }

    public Lotto(List<LottoNumber> numbers, int winningNumberMatchCount) {
        this(numbers);
        this.winningNumberMatchCount = winningNumberMatchCount;
    }

    public int winningNumberMatchCount(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            winningNumberMatchCheck(winningNumber);
        }
        return winningNumberMatchCount;
    }

    private void winningNumberMatchCheck(Integer winningNumber) {
        if (this.numbers.contains(new LottoNumber(winningNumber))) {
            winningNumberMatchCount++;
        }
    }

    private void numberCountValid(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void numberDuplicateValid(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> nonDuplicationLottoNumber = new HashSet<>(lottoNumbers);
        if (nonDuplicationLottoNumber.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "" + numbers + "";
    }
}
