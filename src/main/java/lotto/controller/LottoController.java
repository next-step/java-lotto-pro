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
        Map<String, Lottos> lottos = createLottos(readPurchaseMoney());
        printLottos(lottos);
        winningResult(lottos, createWinningLotto());
    }

    private static Map<String, Lottos> createLottos(int purchaseMoney) {
        int manualLottoCount = readManualLottoCount();
        Map<String, Lottos> lottos = new HashMap<>();
        try {
            lottos.put("manual", createManualLottos(manualLottoCount));
            lottos.put("auto", generate(new LottoMoney(purchaseMoney).purchaseCount(manualLottoCount)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLottos(purchaseMoney);
        }
        return lottos;
    }

    private static Lottos createManualLottos(int manualLottoCount) throws NumberFormatException {
        Lottos manualLottos = new Lottos();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(new Lotto(convert(new TextExtractor(new Delimiters(), readManualLotto()).extract())));
        }
        return manualLottos;
    }

    private static WinningLotto createWinningLotto() {
        Lotto lotto = createLotto();
        Number bonusBall = createBonusBall();
        try {
            return new WinningLotto(lotto, bonusBall);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningLotto();
        }
    }

    private static Lotto createLotto() {
        try {
            return new Lotto(convert(winningLottos()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLotto();
        }
    }

    private static String[] winningLottos() {
        return new TextExtractor(new Delimiters(), readWinningLotto()).extract();
    }

    private static Number createBonusBall() {
        try {
            return new Number(readBonusBall());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBonusBall();
        }
    }
}
