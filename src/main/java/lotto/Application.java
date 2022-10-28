package lotto;

import lotto.controller.LottoController;
import lotto.money.Money;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                LottoGenerator.of(LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy()), Money.from(1000))
        );
        lottoController.start();
    }
}
