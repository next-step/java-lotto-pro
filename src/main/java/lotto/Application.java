package lotto;

import lotto.controller.LottoController;
import lotto.model.lotto.DefaultNumberGeneratorStrategy;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoNumberGenerator;
import lotto.model.money.Money;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                LottoGenerator.of(LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy()), Money.from(1000))
        );
        lottoController.start();
    }
}
