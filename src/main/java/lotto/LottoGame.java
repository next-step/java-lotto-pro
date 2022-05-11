package lotto;

import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int cost = InputView.inputMoney();
        Lottos lottos = lottoMachine.buy(cost);
        ResultView.printLottos(lottos);




    }

}
