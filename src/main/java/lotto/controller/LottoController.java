package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.domain.Number;
import lotto.domain.*;
import lotto.ui.inputView.WinningLottoInputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoGenerator.generate;
import static lotto.ui.inputView.BonusBallInputView.readBonusBall;
import static lotto.ui.inputView.LottoMoneyInputView.readPurchaseMoney;
import static lotto.ui.inputView.ManualLottoInputView.readManualLottoCount;
import static lotto.ui.inputView.WinningLottoInputView.readWinningLotto;
import static lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.ui.outputView.StatisticsOutputView.winningResult;

public class LottoController {

    public void run() {
        Map<String, Lottos> lottosMap = createLottos();
        printLottos(lottosMap);
        winningResult(lottosMap, new WinningLotto(winningLottos(), new Number(readBonusBall())));
    }

    private static List<Integer> numbers(String[] winningLottos) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningLottos) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private static Map<String, Lottos> createLottos() {
        Map<String, Lottos> lottos = new HashMap<>();
        int money = readPurchaseMoney();
        Lottos manualLottos = new Lottos();
        int manualLottoCount = readManualLottoCount();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(new Lotto(numbers(new TextExtractor(new Delimiters(), WinningLottoInputView.readWinningLotto1()).extract())));
        }
        lottos.put("manual", manualLottos);
        lottos.put("auto", generate(new LottoMoney(money - manualLottoCount * 1000).purchaseCount()));
        return lottos;
    }

    private static String[] winningLottos() {
        return new TextExtractor(new Delimiters(), readWinningLotto()).extract();
    }
}
