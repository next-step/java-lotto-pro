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
        Money money = LottoView.getMoney();

        int count = money.buy();
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(number -> new Lotto(this.randomNumbers.random()))
                .collect(Collectors.toList());

        LottoView.displayCount(count);
        LottoView.displayLottos(lottos);

        Lotto winningLotto = LottoView.getWinningLotto();

        final List<Rank> ranks = lottos.stream()
                .map(lotto -> Rank.rank(winningLotto.match(lotto)))
                .collect(Collectors.toList());

        final Result result = new Result(ranks, money);

        LottoView.displayStatic(result);
    }

    public static void main(String[] args) {
        LottoGame game = new LottoGame(new RandomNumbers(new RandomNumber()));
        game.start();
    }
}
