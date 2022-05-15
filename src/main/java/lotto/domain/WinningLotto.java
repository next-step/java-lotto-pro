package lotto.domain;

import lotto.enums.LottoRank;

public class WinningLotto {

    private LottoNumbers answer;

    private WinningLotto(LottoNumbers answer) {
        this.answer = answer;
    }

    public static WinningLotto from(LottoNumbers answer) {
        return new WinningLotto(answer);
    }

    public LottoRank match(LottoNumbers lottoNumbers) {
        return LottoRank.valueOf(answer.hitCounts(lottoNumbers));
    }
}
