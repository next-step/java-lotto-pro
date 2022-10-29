package step3.model;

import step3.view.InputView;
import step3.view.OutputView;

public class LottoManager {
    private static LottoGenerator lottoGenerator = new LottoGenerator();


    public static void purchaseLotto() {
        generateLottos();




    }

    private static void generateLottos() {
        InputView.inputPurchasePrice(lottoGenerator);
        lottoGenerator.generateLottos();
        OutputView.outputPurchasedLotto(lottoGenerator.getLottos());
    }

}
