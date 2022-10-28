package lotto;

import lotto.controller.LottoController;
import lotto.generator.DefaultNumberGeneratorStrategy;
import lotto.generator.LottoGenerator;
import lotto.generator.LottoNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                LottoGenerator.of(LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy()))
        );
        lottoController.start();
    }
}
