package nextstep.lotto.domain;

import nextstep.lotto.exception.LottoRuntimeException;

import java.util.List;
import java.util.Objects;

public class BonusBall {

    public static final String INVALID_DUPLICATE_LOTTO_NUMBER_COUNT_MESSAGE = "로또 번호는 중복되서는 안됩니다.";

    private final LottoNumber lottoNumber;

    public BonusBall(LottoNumber lottoNumber, Lotto winningLotto) {
        validateDuplicateLottoNumbers(lottoNumber, winningLotto);
        this.lottoNumber = lottoNumber;
    }

    private void validateDuplicateLottoNumbers(LottoNumber bonusNumber, Lotto lotto) {
        if (Lotto.isContainsLottoNumber(bonusNumber, lotto)) {
            throw new LottoRuntimeException(INVALID_DUPLICATE_LOTTO_NUMBER_COUNT_MESSAGE);
        }
    }

    public Boolean isContain(Lotto lotto) {
        return lotto.isContains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusBall bonusBall = (BonusBall) o;
        return Objects.equals(lottoNumber, bonusBall.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
