package step3.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int MATCH_POINT = 1;
    private static final int MISMATCH_POINT = 0;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final String EXCEPTION_MESSAGE_INCONSISTENCY_LOTTO_NUMBERS_SIZE = "로또번호 갯수는 " + LOTTO_NUMBERS_SIZE + "이어야 합니다.";
    protected final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_INCONSISTENCY_LOTTO_NUMBERS_SIZE);
        }
    }

    public int getMatchPoint(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber) ? MATCH_POINT : MISMATCH_POINT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
