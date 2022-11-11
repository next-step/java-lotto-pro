package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.domain.Number;
import lotto.domain.*;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.LottoGenerator.generate;
import static lotto.ui.inputView.BonusBallInputView.readBonusBall;
import static lotto.ui.inputView.LottoMoneyInputView.readPurchaseMoney;
import static lotto.ui.inputView.ManualLottoInputView.readManualLotto;
import static lotto.ui.inputView.ManualLottoInputView.readManualLottoCount;
import static lotto.ui.inputView.WinningLottoInputView.readWinningLotto;
import static lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.ui.outputView.StatisticsOutputView.winningResult;
import static utils.NumberUtil.convert;

public class LottoController {

    public void run() {
        Map<String, Lottos> lottosMap = createLottos();
        printLottos(lottosMap);
        winningResult(lottosMap, new WinningLotto(new Lotto(convert(winningLottos())), new Number(readBonusBall())));
    }

    private static Map<String, Lottos> createLottos() {
        Map<String, Lottos> lottos = new HashMap<>();
        int manualLottoCount = readManualLottoCount();
        lottos.put("manual", createManualLottos(manualLottoCount));
        lottos.put("auto", generate(new LottoMoney(readPurchaseMoney()).purchaseCount(manualLottoCount)));
        return lottos;
    }

    private static Lottos createManualLottos(int manualLottoCount) {
        Lottos manualLottos = new Lottos();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(new Lotto(convert(new TextExtractor(new Delimiters(), readManualLotto()).extract())));
        }
        return manualLottos;
    }

    private static String[] winningLottos() {
        return new TextExtractor(new Delimiters(), readWinningLotto()).extract();
    }
}
