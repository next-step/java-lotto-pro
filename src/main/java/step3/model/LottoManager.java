package step3.model;

import step3.view.InputView;

public class LottoManager {
    private LottoGenerator lottoGenerator;

    public static void purchaseLotto() {
        InputView.inputPurchasePrice(new LottoGenerator());


    }

}
