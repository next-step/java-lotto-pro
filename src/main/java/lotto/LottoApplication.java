package lotto;

import lotto.utils.LottoGame;

import java.io.IOException;

public class LottoApplication {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}
