package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import javax.xml.transform.Result;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.getInstance();
        long money = InputView.inputMoney();
        List<Lotto> lottos = lottoController.buyLotto(money);

        lottos.stream()
                .map(Lotto::printLotto)
                .forEach(ResultView::printLottoNumber);

        Lotto answer = Lotto.ofAnswer(InputView.inputAnswer());
        long totalPrize = lottoController.exchangePrize(lottos, answer);
        lottoController.printYield(totalPrize, money);
    }
}

