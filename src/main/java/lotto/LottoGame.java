package lotto;

import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int cost = InputView.inputMoney();
        int quantity = lottoMachine.buy(cost);
        ResultView.printLottoQuantity(quantity);


    }

}
