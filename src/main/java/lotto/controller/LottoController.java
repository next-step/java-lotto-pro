package lotto.controller;

import lotto.domain.*;
import lotto.view.ResultView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static final LottoController INSTANCE = new LottoController();
    private static final int YIELD_SCALE = 2;

    private final LottoMachine lottoMachine;

    private LottoController() {
        lottoMachine = LottoMachine.getInstance();
    }

    public static LottoController getInstance() {
        return INSTANCE;
    }

    public List<Lotto> buyLotto(final long money) {
        int buyCount = lottoMachine.purchase(money);
        printBuyCount(buyCount);

        return lottoMachine.generateAutos(buyCount);
    }

    private void printBuyCount(final int buyCount) {
        ResultView.resultBuyCount(buyCount);
    }

    public long exchangePrize(final List<Lotto> lottoes, final WinningNumbers answer) {
        Winners winners = Prize.matchLotto(lottoes, answer);
        Map<Prize, Long> rankCount = winners.getRankCount();
        ResultView.printEachPrize(rankCount);
        return winners.totalPrize(rankCount);
    }

    public void printYield(final long totalPrize, final long money) {
        float yield = new BigDecimal(totalPrize)
                .divide(new BigDecimal(money), YIELD_SCALE, RoundingMode.CEILING)
                .floatValue();
        ResultView.resultYield(yield);
    }
}
