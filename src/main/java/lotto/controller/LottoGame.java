package lotto.controller;

import lotto.model.LottoPaper;
import lotto.model.LottoPapers;
import lotto.model.LottoResult;

public class LottoGame {

    public LottoResult getLottoResult(LottoPapers lottoPapers, LottoPaper winningLottoPaper) {
        LottoResult lottoResult = new LottoResult();
        lottoPapers.getLottoPapers()
                .forEach(lottoPaper -> lottoPaper.matchLottoPaper(winningLottoPaper, lottoResult));
        return  lottoResult;
    }

}
