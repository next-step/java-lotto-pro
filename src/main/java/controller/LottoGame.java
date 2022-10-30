package controller;

import model.Lotto;
import model.LottoNumber;
import model.Rank;
import model.strategy.RandomStrategy;
import view.InputView;
import view.OutPutView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {


    public void start() {
        int money = InputView.moneyInput();
        List<Integer> arrangeNumber = initArrangeNumber();
        List<LottoNumber> buy = new Lotto(money, new RandomStrategy(arrangeNumber)).buy();
        OutPutView.outPutLottoNumber(buy);
        List<Integer> winNumber = InputView.winNumberInput();
        new Rank().stats(buy, winNumber);
    }


    private List<Integer> initArrangeNumber() {
        List<Integer>arrangeNumber = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            arrangeNumber.add(i);
        }

        return arrangeNumber;
    }
}
