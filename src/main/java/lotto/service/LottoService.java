package lotto.service;

import lotto.domain.Lotteries;
import lotto.domain.LottoResult;

public class LottoService {

    public Lotteries buyLotto(int buyAmount) {
        return new Lotteries(buyAmount);
    }

    public LottoResult lottoResult(Lotteries lotteries, int[] readWinningNumbers, int buyAmount) {
        return new LottoResult(lotteries,readWinningNumbers,buyAmount);
    }
}
