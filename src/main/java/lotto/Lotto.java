package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(String lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers.LottoNumbersToListOfLottoNumber();
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < lottoNumbers.LottoNumbersToListOfLottoNumber().size() - 1; i++) {
            str += lottoNumbers.LottoNumbersToListOfLottoNumber().get(i).getLottoNum() + ", ";
        }
        return str += lottoNumbers.LottoNumbersToListOfLottoNumber().get(lottoNumbers.LottoNumbersToListOfLottoNumber().size() -1).getLottoNum();
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
