package lotto;

import lotto.controller.LottoController;
import lotto.generator.DefaultNumberGeneratorStrategy;
import lotto.generator.LottoGenerator;
import lotto.generator.LottoNumberGenerator;
import lotto.domain.money.Money;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                LottoGenerator.of(LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy()), Money.from(1000))
        );
        lottoController.start();
    }
}
