package nextstep.lotto.domain;

import nextstep.lotto.constance.LottoExceptionMessage;
import nextstep.lotto.exception.LottoRuntimeException;

import java.util.List;
import java.util.Objects;

public class BonusBall {

    private final LottoNumber lottoNumber;

    public BonusBall(LottoNumber lottoNumber, Lotto winningLotto) {
        validateDuplicateLottoNumbers(lottoNumber, winningLotto);
        this.lottoNumber = lottoNumber;
    }

    private void validateDuplicateLottoNumbers(LottoNumber bonusNumber, Lotto lotto) {
        if (Lotto.isContainsLottoNumber(bonusNumber, lotto)) {
            throw new LottoRuntimeException(LottoExceptionMessage.INVALID_DUPLICATE_LOTTO_NUMBER_COUNT_MESSAGE);
        }
    }

    public Boolean isContain(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(lottoNumber);
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
