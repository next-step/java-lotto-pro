package step3.model;

import step3.view.InputView;
import step3.view.OutputView;

public class LottoManager {
    private static LottoGenerator lottoGenerator = new LottoGenerator();

    public static void purchaseLotto() {

        Lottos lottos = generateLottos();




    }

    private static Lottos generateLottos() {
        InputView.inputPurchasePrice(lottoGenerator);
        Lottos lottos = lottoGenerator.generateLottos();
        OutputView.outputPurchasedLotto(lottos);
        return lottos;
    }

}
