package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final LottoNumber... lottoNumbers) {
        verifyLottoNumbersLength(lottoNumbers);

        this.lottoNumbers = Arrays.asList(lottoNumbers);
    }

    private boolean isAvailableLottoNumbersLength(final LottoNumber[] lottoNumbers) {
        return lottoNumbers.length == LOTTO_LENGTH;
    }

    private void verifyLottoNumbersLength(final LottoNumber[] lottoNumbers) {
        if (!isAvailableLottoNumbersLength(lottoNumbers)) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        final Lotto lotto = (Lotto)o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
