package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoExecutor;

public class LottoApplication {
    public static void main(String[] args) {
        new LottoExecutor(new LottoController()).run();
    }
}
