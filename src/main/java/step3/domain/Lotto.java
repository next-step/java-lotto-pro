package step3.domain;

import static java.text.MessageFormat.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Lotto {

    public static final int LOTTO_LENGTH = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        verifyLottoNumbersLength(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> get() {
        return this.lottoNumbers;
    }

    public int check(final Lotto winningLotto) {
        int winningCount = 0;

        for (LottoNumber lottoNumber : this.lottoNumbers) {
            winningCount += lottoNumber.check(winningLotto.get());
        }

        return winningCount;
    }

    private boolean isAvailableLottoNumbersLength(final List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() == LOTTO_LENGTH;
    }

    private void verifyLottoNumbersLength(final List<LottoNumber> lottoNumbers) {
        if (!isAvailableLottoNumbersLength(lottoNumbers)) {
            throw new IllegalArgumentException(format("로또는 {0}개의 숫자로 구성되어야 합니다.", LOTTO_LENGTH));
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

    @Override
    public String toString() {
        final StringJoiner numberJoiner = new StringJoiner(", ", "[", "]");

        for (LottoNumber lottoNumber : lottoNumbers) {
            numberJoiner.add(lottoNumber.toString());
        }

        return numberJoiner.toString();
    }
}
