package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final String LOTTO_SIZE_ERROR = "로또 번호의 수는 6개이어야 합니다.";
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new RuntimeException(LOTTO_SIZE_ERROR);
        }
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto valueOf(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
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
