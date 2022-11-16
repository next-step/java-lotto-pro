package study.step4.models;

import study.step4.exception.LottoInvalidSizeException;
import study.step4.helper.LottoStringParser;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String lottoNumbers) {
        this(LottoStringParser.stringToLottoNumbers(lottoNumbers));
    }

    private void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new LottoInvalidSizeException(String.format("로또 사이즈는 %d이어야 합니다.", LOTTO_SIZE));
        }
    }

    public int countNumberOfMatching(WinningLotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public boolean contains(LottoNumber bonusBall) {
        return lottoNumbers.contains(bonusBall);
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
