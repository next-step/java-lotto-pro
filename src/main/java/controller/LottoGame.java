package controller;

import model.Lottos;
import model.Money;
import model.Rank;
import model.Revenue;
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
        List<Integer> arrangeNumber = initArrangeNumber();
        Lottos lottos = new Lottos(new Money(money), new RandomStrategy(arrangeNumber));

        OutPutView.outPutLottoNumber(lottos.getLotto());
        List<Integer> winNumber = InputView.winNumberInput();
        int bonusNumber = InputView.bonusNumberInput();

        Rank rank = new Rank();
        rank.stats(lottos, winNumber, bonusNumber);

        double percent = new Revenue(rank.getCountRank()).getPercent(money);

        OutPutView.outPutResult(rank.getCountRank(), percent);
    }


    private List<Integer> initArrangeNumber() {
        List<Integer> arrangeNumber = new ArrayList<>();
        for (int i = START_LOTTO_NUMBER; i <= END_LOTTO_NUMBER; i++) {
            arrangeNumber.add(i);
        }

        return arrangeNumber;
    }
}
