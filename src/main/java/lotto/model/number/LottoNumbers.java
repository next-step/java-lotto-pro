package lotto.model.number;

import static lotto.constant.LottoSetting.LOTTO_SIZE;

import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public String toLottoNumbersString() {
        return lottoNumbers.toString();
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 숫자는 %d가 필요합니다.", LOTTO_SIZE));
        }
    }

    public int countContainLottoNumber(LottoNumbers winningLottoNumbers) {
        return (int) this.lottoNumbers.stream().filter(winningLottoNumbers::existLottoNumber).count();
    }

    private boolean existLottoNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

}
