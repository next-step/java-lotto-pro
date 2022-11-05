package controller;

import model.*;
import model.strategy.ManualStrategy;
import model.strategy.RandomStrategy;
import view.InputView;
import view.OutPutView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int INIT_START_NUMBER = 0;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    public void start() {
        int money = InputView.moneyInput();
        int manualCount = InputView.manualBuyCountInput();
        int autoCount = new Money(money).availableBuyAutoLottoCount(manualCount);

        List<LottoNumber> autoLottoNumber = buyAutoLotto(autoCount);
        List<LottoNumber> manualLotto = buyManualLotto(manualCount);

        Lottos lottos = new Lottos(autoLottoNumber, manualLotto);

        OutPutView.outPutLottoNumber(lottos.getLotto());
        InputView.winNumberMessage();

        List<Integer> winNumber = InputView.inputNumber();
        Rank rank = getRank(lottos, winNumber);
        OutPutView.outPutResult(rank.getCountRank(), new Revenue(rank.getCountRank()).getPercent(money));
    }

    private List<LottoNumber> buyAutoLotto(int autoCount) {
        Seller seller = new Seller();
        seller.buyAuto(autoCount, new RandomStrategy(initArrangeNumber()));
        return seller.getLotto();
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
        Seller seller = new Seller();
        for (int i = INIT_START_NUMBER; i < count; i++) {
            ManualStrategy manualStrategy = new ManualStrategy(InputView.inputNumber());
            seller.buyManual(manualStrategy);
        }

        return seller.getLotto();
    }


    private List<Integer> initArrangeNumber() {
        List<Integer> arrangeNumber = new ArrayList<>();
        for (int i = START_LOTTO_NUMBER; i <= END_LOTTO_NUMBER; i++) {
            arrangeNumber.add(i);
        }

        return arrangeNumber;
    }
}
