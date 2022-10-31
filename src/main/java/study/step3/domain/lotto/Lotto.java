package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoNumbers;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public long match(Lotto winningLotto) {
        return this.lottoNumbers.match(winningLotto.lottoNumbers);
    }

    public String reportLottoNumbers() {
        return this.lottoNumbers.toString();
    }
}
