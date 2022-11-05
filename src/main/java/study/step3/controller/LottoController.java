package study.step3.controller;

import study.step3.domain.lotto.Lottos;
import study.step3.domain.lotto.PurchaseMoney;
import study.step3.domain.lotto.WinningLotto;
import study.step3.domain.lottostatistics.LottoRankCountCache;
import study.step3.domain.lottostatistics.LottoStatistics;

public class LottoController {

    public LottoStatistics match(PurchaseMoney purchaseMoney, Lottos lottos, WinningLotto winningLotto) {
        LottoRankCountCache lottoRankCountCache = lottos.matchAll(winningLotto);
        return new LottoStatistics(purchaseMoney, lottoRankCountCache);
    }
}
