package step3.controller;

import step3.domain.amount.Amount;
import step3.domain.factory.Automatic;
import step3.domain.factory.Manual;
import step3.domain.lotto.*;
import step3.domain.statistics.LottoStatistics;

import java.util.ArrayList;
import java.util.List;

import static step3.domain.lotto.Lotto.DEFAULT_LOTTO_PRICE;
import static step3.view.InputView.*;
import static step3.view.ResultView.*;

public class LottoController {

    public void run() {
        Amount amount = new Amount(inputAmount());
        ManualLottoQuantity manualLottoQuantity = new ManualLottoQuantity(inputManualLottoQuantity());

        printManualLottoQuantity();
        Lottos lottos = new Lottos(getLottos(amount, manualLottoQuantity));

        printLottosQuantity(lottos.getManualCount(), lottos.getAutomaticCount());
        printLottos(lottos.toString());

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputWinningLottoNumber());
        BonusLottoNumber bonusLottoNumber = new BonusLottoNumber(LottoNumber.of(inputBonusLottoNumber()));

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, new WinningLotto(winningLottoNumbers, bonusLottoNumber));

        printResult(lottoStatistics.toString());
        printTotalProfit(lottoStatistics.getTotalProfit());
    }

    private static List<Lotto> getLottos(Amount amount, ManualLottoQuantity manualLottoQuantity) {
        List<Lotto> lottoList = new ArrayList<>();
        int lottoPurchasesCount = amount.getLottoPurchasesCount(DEFAULT_LOTTO_PRICE);
        for (int i = 0; i < manualLottoQuantity.getQuantity(); i++) {
            lottoList.add(new Lotto(new Manual(inputManualLottoNumbers())));
            lottoPurchasesCount--;
        }
        for (int i = 0; i < lottoPurchasesCount; i++) {
            lottoList.add(new Lotto(new Automatic()));
        }
        return lottoList;
    }
}
