package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Prize;
import lotto.domain.PrizeExchanger;
import lotto.view.ResultView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoController {
    private static final LottoController INSTANCE = new LottoController();
    private static final int YIELD_SCALE = 2;

    private LottoMachine lottoMachine;

    private LottoController() {
        lottoMachine = LottoMachine.getInstance();
    }

    public static LottoController getInstance() {
        return INSTANCE;
    }

    public int buyLotto(final long money) {
        return lottoMachine.purchase(money);
    }

    public long exchangePrize(final List<Lotto> lottoes, final Lotto answer) {
        PrizeExchanger prizeExchanger = PrizeExchanger.getInstance();
        ResultView.statisticMessage();
        return prizeExchanger.exchange(Prize.matchLotto(lottoes, answer));
    }

    public void printYield(final long totalPrize, final long money) {
        float yield = new BigDecimal(totalPrize)
                .divide(new BigDecimal(money), YIELD_SCALE, RoundingMode.CEILING)
                .floatValue();
        ResultView.resultYield(yield);
    }
}
