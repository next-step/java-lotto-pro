package step3.model;

import step3.view.InputView;

public class LottoManager {
    private static LottoGenerator lottoGenerator = new LottoGenerator();

    public static void purchaseLotto() {

        Lottos lottos = generateLottos();




    }

    private static Lottos generateLottos() {
        InputView.inputPurchasePrice(lottoGenerator);
        Lottos lottos = lottoGenerator.generateLottos();
        return lottos;
    }

}
