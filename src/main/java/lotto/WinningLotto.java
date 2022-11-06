package lotto;

import java.util.List;

import static lotto.common.Constants.INIT_NUM;

public class WinningLotto {
    private LottoNumbers winningLotto;

    public WinningLotto(List<Integer> lottoNumbers) {
        this.winningLotto = new LottoNumbers(lottoNumbers);
    }

    public WinningLotto(LottoNumbers lottoNumbers) {
        this.winningLotto = lottoNumbers;
    }

    public WinningLotto(String lottoNumbers) {
        this.winningLotto = new LottoNumbers(lottoNumbers);
    }

    public int match(Lotto lotto) {
        int cnt = INIT_NUM;
        for (int num : lotto.getLottoNumbers()) {
            cnt += contains(num);
        }

        return cnt;
    }

    private int contains(int num) {
        if (this.winningLotto.getNumbers().contains(num)) {
            return 1;
        }
        return 0;
    }
}
