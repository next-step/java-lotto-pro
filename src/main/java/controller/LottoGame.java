package controller;

import model.*;
import model.strategy.RandomStrategy;
import view.InputView;
import view.OutPutView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {


    public void start() {
        int money = InputView.moneyInput();
        List<Integer> arrangeNumber = initArrangeNumber();
        List<LottoNumber> buyLotto = new Lotto(money, new RandomStrategy(arrangeNumber)).buy();
        OutPutView.outPutLottoNumber(buyLotto);
        List<Integer> winNumber = InputView.winNumberInput();
        Rank rank = new Rank();
        rank.stats(buyLotto, winNumber);
        double percent = new Revenue(rank.getCountRank()).getPercent(money);

        OutPutView.outPutResult(rank.getCountRank(), percent);
    }


    private List<Integer> initArrangeNumber() {
        List<Integer>arrangeNumber = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            arrangeNumber.add(i);
        }

        return arrangeNumber;
    }
}
