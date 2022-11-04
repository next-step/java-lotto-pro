package lotto.controller.displayer;

import lotto.model.lotto.enums.LottoNumberMatchCount;
import lotto.model.lotto.result.LottoResult;
import lotto.view.BlankLinePrinter;
import lotto.view.LottoScoreTitlePrinter;
import lotto.view.LottoWinningStatisticsPrinter;

import java.util.Map;

public class LottoResultStatisticsDisplayer {
    private final Map<LottoNumberMatchCount, Integer> prizeMoney;
    private final LottoResult lottoResult;

    public LottoResultStatisticsDisplayer(Map<LottoNumberMatchCount, Integer> prizeMoney, LottoResult lottoResult) {
        this.prizeMoney = prizeMoney;
        this.lottoResult = lottoResult;
    }

    public void show() {
        BlankLinePrinter.print();
        LottoScoreTitlePrinter.print();
        LottoWinningStatisticsPrinter.print(prizeMoney, lottoResult);
    }
}
