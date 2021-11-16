package nextstep.lotto.service;

import nextstep.lotto.domain.LottoCount;
import nextstep.lotto.domain.MatchCountCollection;
import nextstep.lotto.domain.PurchaseLotto;
import nextstep.lotto.domain.PurchaseLottoAmount;
import nextstep.lotto.domain.TotalWinningAmount;
import nextstep.lotto.domain.WinningLotto;
import nextstep.lotto.io.LottoDisplay;

import java.math.BigDecimal;

public class LottoService {

    public void startLotto() {

        PurchaseLottoAmount purchaseLottoAmount = LottoDisplay.inputPurchaseAmount();
        LottoCount lottoCount = new LottoCount(purchaseLottoAmount);

        PurchaseLotto purchaseLotto = LottoDisplay.inputManualPurchaseLotto(lottoCount);
        LottoDisplay.printLottoCountResult(lottoCount);
        LottoDisplay.printAutoLottoResult(purchaseLotto);

        WinningLotto winningLotto = LottoDisplay.inputLastWeekWinningLotto();
        MatchCountCollection matchCountCollection = MatchCountCollection.matchPurchaseLottoWithWinningLotto(purchaseLotto, winningLotto);

        LottoDisplay.printWinningStatMessage(matchCountCollection);
        TotalWinningAmount totalWinningAmount = new TotalWinningAmount(matchCountCollection);
        BigDecimal returnRate = totalWinningAmount.calculateReturnRate(purchaseLottoAmount);
        LottoDisplay.printReturnRate(returnRate);
    }
}
