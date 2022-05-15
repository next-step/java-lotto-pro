package lotto;

import lotto.view.InputView;

public class Application {

    private static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int price = InputView.inputPrice();

        Lottos lottos = lottoMachine.buy(price);
    }

}
