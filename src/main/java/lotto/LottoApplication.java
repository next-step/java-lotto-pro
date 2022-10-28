package lotto;

import lotto.domain.LottoGame;
import lotto.ui.StandardInput;
import lotto.ui.StandardOutput;

public class LottoApplication {

    public static void main(String[] args) {
        new LottoGame(new StandardInput(), new StandardOutput()).run();
    }
}
