package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoView;

import java.util.*;

public class LottoGame {

    private RandomNumbers randomNumbers;

    public LottoGame(RandomNumbers randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public void start() {
        Money money = LottoView.getMoney();
        List<Lotto> lottos = LottoView.getLotto(money.buy(), this.randomNumbers);
        Lotto winningLotto = LottoView.getWinningLotto();
        LottoView.getStatic(lottos, winningLotto, money);
    }

    public static void main(String[] args) {
        LottoGame game = new LottoGame(
                new RandomNumbers(new RandomNumber()));
        game.start();
    }
}
