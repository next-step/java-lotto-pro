package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.factory.LottoAutoFactory;
import lotto.model.money.Money;
import lotto.model.number.LottoNumbers;
import lotto.model.purchased.PurchasedInfo;
import lotto.model.purchased.PurchasedLotto;
import lotto.model.result.LottoResult;
import lotto.type.LottoWinningPriceType;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    public void start() {
        Money purchasedMoney = new Money(InputView.inputPurchasedMoney());

        PurchasedInfo purchasedInfo = new PurchasedInfo(purchasedMoney, LottoAutoFactory.create());
        OutputView.OutputPurchaseResult(purchasedInfo);

        LottoNumbers winningNumbers = LottoNumbers.fromInputLottoNumbers(InputView.inputWinningNumber());

        Map<LottoWinningPriceType, List<PurchasedLotto>> lottoWinningPriceTypeListMap =
            purchasedInfo.winningLotto(winningNumbers);

        LottoResult lottoStatistics = new LottoResult(lottoWinningPriceTypeListMap, purchasedMoney);
        OutputView.OutputLottoResult(lottoStatistics);
    }

}
