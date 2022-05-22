package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Application {

    private static final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int price = InputView.inputPrice();
        int maxQuantity = lottoMachine.getQuantity(price);
        int passiveQuantity = InputView.inputPassiveNumberCount(maxQuantity);
        int autoQuantity = maxQuantity - passiveQuantity;
        List<String[]> numbersArray =  InputView.inputPassiveNumbers(passiveQuantity);

        Lottos lottos = lottoMachine.buy(autoQuantity, numbersArray);

        ResultView.printQuantity(passiveQuantity, autoQuantity);
        ResultView.printLottos(lottos);

        String[] winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), new Number(bonusNumber));

        List<Rank> ranks = lottos.getRanks(winningLotto);

        ResultView.printStatistics(ranks);
        ResultView.printProfitRate(lottoMachine.getProfitRate(price, ranks));
    }

}
