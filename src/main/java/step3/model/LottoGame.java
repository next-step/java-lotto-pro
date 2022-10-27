package step3.model;

import step3.veiw.InputView;
import step3.veiw.OutputView;

public class LottoGame {

    private static LottoGenerator lottoGenerator = new LottoGenerator();

    public void startGame() {
        generateLotto();
    }

    private static void generateLotto() {
        InputView.inputPurchasePrice(lottoGenerator);
        Lottos lottos = lottoGenerator.generateLottos();
        OutputView.outputResultGenerateLotto(lottos);
    }

}
