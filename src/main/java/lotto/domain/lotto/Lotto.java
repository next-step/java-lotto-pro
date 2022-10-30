package lotto.domain.lotto;

import lotto.constant.LottoConstant;
import lotto.status.ErrorStatus;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstant.LOTTO_COMPONENT_COUNT) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_LOTTO_COMPONENT.getMessage());
        }
    }

    public int matchCount(WinnerLotto winnerLotto) {
        return (int) this.lottoNumbers.stream()
                .filter(winnerLotto::containLottoNumber)
                .count();
    }

    public boolean contain(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }
}
