package controller;

import model.*;
import model.strategy.RandomStrategy;
import view.InputView;
import view.OutPutView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    public void start() {
        int money = InputView.moneyInput();
        int manualCount = InputView.manualBuyCountInput();
        List<LottoNumber> manualLotto = buyManualLotto(manualCount);
        int autoCount = new Money(money).availableBuyAutoLottoCount(manualCount);
        Lottos lottos = new Lottos(autoCount, manualLotto, new RandomStrategy(initArrangeNumber()));

        OutPutView.outPutLottoNumber(lottos.getLotto());

        InputView.winNumberMessage();
        List<Integer> winNumber = InputView.inputNumber();
        Rank rank = getRank(lottos, winNumber);

        OutPutView.outPutResult(rank.getCountRank(), new Revenue(rank.getCountRank()).getPercent(money));
    }

    private Rank getRank(Lottos lottos, List<Integer> winNumber) {
        int bonusNumber = InputView.bonusNumberInput();
        Rank rank = new Rank();
        rank.stats(lottos, winNumber, bonusNumber);
        return rank;
    }

    private List<LottoNumber> buyManualLotto(int manualCount) {
        InputView.manualNumberMessage();
        return getManualInput(manualCount);
    }

    public static List<LottoNumber> getManualInput(int count) {
        List<LottoNumber> manualLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> integers = InputView.inputNumber();
            manualLotto.add(new LottoNumber(integers));
        }

        return manualLotto;
    }


    private List<Integer> initArrangeNumber() {
        List<Integer> arrangeNumber = new ArrayList<>();
        for (int i = START_LOTTO_NUMBER; i <= END_LOTTO_NUMBER; i++) {
            arrangeNumber.add(i);
        }

        return arrangeNumber;
    }
}
