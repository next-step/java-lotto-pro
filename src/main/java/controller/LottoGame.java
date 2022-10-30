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

import static common.Constants.END_LOTTO_NUMBER;
import static common.Constants.START_LOTTO_NUMBER;

public class LottoGame {

    public void start() {
        int money = InputView.moneyInput();
        List<Integer> arrangeNumber = initArrangeNumber();
        Lottos lottos = new Lottos(new Money(money), new RandomStrategy(arrangeNumber));

        OutPutView.outPutLottoNumber(lottos.getLotto());
        List<Integer> winNumber = InputView.winNumberInput();

        Rank rank = new Rank();
        rank.stats(lottos, winNumber);

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
