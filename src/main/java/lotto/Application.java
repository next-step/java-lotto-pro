package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Application {

    private static final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int price = InputView.inputPrice();
        int maxQuantity = lottoMachine.getQuantity(price);
        int manualQuantity = InputView.inputManualNumberCount(maxQuantity);
        int autoQuantity = maxQuantity - manualQuantity;
        Lottos manualLottos =  InputView.inputManualNumbers(manualQuantity);

        Lottos lottos = lottoMachine.buy(autoQuantity, manualLottos);

        ResultView.printQuantity(manualQuantity, autoQuantity);
        ResultView.printLottos(lottos);

        List<Number> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), new Number(bonusNumber));

        List<Rank> ranks = lottos.getRanks(winningLotto);

        ResultView.printStatistics(ranks);
        ResultView.printProfitRate(lottoMachine.getProfitRate(price, ranks));
    }

}
