package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.*;

// 로또
public class Lotto {

    public static final int LOTTO_COUNT = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        numberCountValid(lottoNumbers);
        numberDuplicateValid(lottoNumbers);
        this.numbers = Collections.unmodifiableList(lottoNumbers);
    }

    public WinningNumberMatchResult winningNumberMatch(Lotto winningNumbers, LottoNumber bonusNumber) {
        int winningNumberMatchCount = 0;

        for (LottoNumber winningNumber : winningNumbers.numbers) {
            winningNumberMatchCount += winningNumberMatchCount(winningNumber.getNumber());
        }
        return new WinningNumberMatchResult(winningNumberMatchCount, isBonusNumberMatch(bonusNumber));
    }

    private boolean isBonusNumberMatch(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    private int winningNumberMatchCount(Integer winningNumber) {
        if (isWinningNumberMatch(winningNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean isWinningNumberMatch(Integer winningNumber) {
        return this.numbers.contains(new LottoNumber(winningNumber));
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
