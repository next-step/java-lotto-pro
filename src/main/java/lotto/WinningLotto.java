package lotto;

import lotto.common.LottoAutoUtils;

import java.util.List;

import static lotto.common.Constants.INIT_NUM;

public class WinningLotto {
    private LottoNumbers winningLotto;
    private LottoNumber bonusNum;

    public WinningLotto(List<LottoNumber> lottoNumbers) {
        this.winningLotto = new LottoNumbers(lottoNumbers);
    }

    public WinningLotto(LottoNumbers lottoNumbers) {
        this.winningLotto = lottoNumbers;
    }

    public WinningLotto(String lottoNumbers) {
        this.winningLotto = new LottoNumbers(lottoNumbers);
    }

    public WinningLotto(String lottoNumbers, String bonusNum) {
        this.winningLotto = new LottoNumbers(lottoNumbers);
        this.bonusNum = LottoNumber.of(new LottoAutoUtils().stringToNumber(bonusNum));
    }

    public int match(Lotto lotto) {
        int cnt = INIT_NUM;
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            cnt += contains(lottoNumber);
        }

        return cnt;
    }

    private int contains(LottoNumber num) {
        if (this.winningLotto.getLottoNumbers().contains(num)) {
            return 1;
        }
        return 0;
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        if (lotto.getLottoNumbers().contains(this.bonusNum)) {
            return true;
        }
        return false;
    }
}
