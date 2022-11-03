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
        int manualQuantity = new ManualLottoQuantity(inputManualLottoQuantity()).getQuantity();
        Lottos lottos = getLottos(amount, manualQuantity);

        printLottosQuantity(manualQuantity, getAutomatic(manualQuantity, lottos));
        printLottos(lottos.toString());
        printLottoResult(lottos);
    }

    private int getAutomatic(int manualQuantity, Lottos lottos) {
        return lottos.value().size() - manualQuantity;
    }

    private Lottos getLottos(Amount amount, int manualQuantity) {
        printManualLottoQuantity();
        return new Lottos(getLottos(amount.getLottoPurchasesCount(DEFAULT_LOTTO_PRICE), manualQuantity));
    }

    private void printLottoResult(Lottos lottos) {
        LottoStatistics lottoStatistics = getLottoStatistics(lottos);
        printLottoStatistics(lottoStatistics.toString());
        printTotalProfit(lottoStatistics.getTotalProfit());
    }

    private LottoStatistics getLottoStatistics(Lottos lottos) {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputWinningLottoNumber());
        BonusLottoNumber bonusLottoNumber = new BonusLottoNumber(LottoNumber.of(inputBonusLottoNumber()));

        return new LottoStatistics(lottos, new WinningLotto(winningLottoNumbers, bonusLottoNumber));
    }

    private static List<Lotto> getLottos(int lottoPurchasesCount, int manualQuantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < manualQuantity; i++) {
            lottoList.add(new Lotto(new Manual(inputManualLottoNumbers())));
            lottoPurchasesCount--;
        }
        for (int i = 0; i < lottoPurchasesCount; i++) {
            lottoList.add(new Lotto(new Automatic()));
        }
        return lottoList;
    }
}
