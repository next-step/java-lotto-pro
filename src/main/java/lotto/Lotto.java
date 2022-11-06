package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.common.Constants.BEGIN_INDEX;
import static lotto.common.Constants.LOTTO_LENGTH;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto() {
        lottoNumbers = new LottoNumbers();
        makeLottoNumbers();
    }

    public Lotto(String lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    private void makeLottoNumbers() {
        for (int num = 1; num <= 45; num++) {
            lottoNumbers.add(LottoNumber.of(num));
        }
        Collections.shuffle(lottoNumbers.getLottoNumbers());
        lottoNumbers = new LottoNumbers(lottoNumbers.getLottoNumbers().subList(BEGIN_INDEX, BEGIN_INDEX + LOTTO_LENGTH));
        lottoNumbers.sort();
    }

    @Override
    public String toString() {
        return lottoNumbers.getLottoNumbers().toString();
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
