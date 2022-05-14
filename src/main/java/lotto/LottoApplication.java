package lotto;

import lotto.utils.LottoGame;

import java.io.IOException;

public class LottoApplication {
    public static void main(String[] args) throws IOException {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}
