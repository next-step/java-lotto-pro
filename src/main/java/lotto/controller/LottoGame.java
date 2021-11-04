package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private RandomNumbers randomNumbers;

    public LottoGame(RandomNumbers randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public void start() {
        final Money money = LottoView.getMoney();
        final Lottos lottos = new Lottos(money, randomNumbers);

        LottoView.displayCount(money);
        LottoView.displayLottos(lottos);

        final Lotto winningLotto = LottoView.getWinningLotto();
        final List<Rank> ranks = lottos.match(winningLotto);

        LottoView.displayStatic(new Result(ranks, money));
    }

    public static void main(String[] args) {
        LottoGame game = new LottoGame(new RandomNumbers(new RandomNumber()));
        game.start();
    }
}
