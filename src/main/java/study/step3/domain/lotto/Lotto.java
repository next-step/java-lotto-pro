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

    public boolean isMatchedBonusLottoNumber(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    public String reportLottoNumbers() {
        return this.lottoNumbers.toString();
    }
}
