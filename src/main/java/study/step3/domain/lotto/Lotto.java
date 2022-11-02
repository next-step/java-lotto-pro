package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoNumber;
import study.step3.domain.lottonumber.LottoNumbers;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public long matchLotto(Lotto other) {
        return this.lottoNumbers.match(other.lottoNumbers);
    }

    public long matchBonusLottoNumber(LottoNumber bonusNumber) {
        boolean isMatchedBonusNumber = this.lottoNumbers.contains(bonusNumber);
        if(isMatchedBonusNumber) {
            return 1L;
        }
        return 0L;
    }

    public String reportLottoNumbers() {
        return this.lottoNumbers.toString();
    }
}
