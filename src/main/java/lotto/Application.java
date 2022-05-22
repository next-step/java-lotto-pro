package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Application {

    private static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int price = InputView.inputPrice();

        Lottos lottos = lottoMachine.buy(price);
        ResultView.printQuantity(lottos.getLottos().size());
        ResultView.printLottos(lottos);

        String[] winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), new Number(bonusNumber));

        List<Rank> ranks = lottos.getRanks(winningLotto);

        ResultView.printStatistics(ranks);
        ResultView.printProfitRate(lottoMachine.getProfitRate(price, ranks));
    }

}
