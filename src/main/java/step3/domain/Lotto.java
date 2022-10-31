package step3.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final String EXCEPTION_MESSAGE_INCONSISTENCY_LOTTO_NUMBERS_SIZE = "로또번호 갯수는 " + LOTTO_NUMBERS_SIZE + "이어야 합니다.";
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_INCONSISTENCY_LOTTO_NUMBERS_SIZE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }
}
