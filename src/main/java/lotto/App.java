package lotto;

import lotto.controller.LottoGame;
import lotto.domain.RandomNumbers;

public class App {

    public static void main(String[] args) {
        LottoGame game = new LottoGame(new RandomNumbers());
        game.start();
    }
}
