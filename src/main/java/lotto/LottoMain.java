package lotto;

import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Seller;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoMain {
    private static final LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        int purchaseMoney = InputView.printInputMoney();
        int countOfAutoLotto = Seller.returnLotto(purchaseMoney);
        int countOfManualLotto = InputView.printInputManualLottoCount();

        Lottos manualLottos = lottoService.createManualLotto(countOfManualLotto, countOfAutoLotto);

        OutputView.printLottoCount(countOfManualLotto , countOfAutoLotto);

        Lottos autoLottos = lottoService.createAutoLotto(countOfAutoLotto - countOfManualLotto);

        Lottos mergedLottos = new Lottos(manualLottos.lottos(), autoLottos.lottos());
        OutputView.printLotto(mergedLottos.toString());

        List<Integer> winningLottoNumbers = InputView.printInputWinningLotto();
        int bonusBallNumber = InputView.printInputBonusNumber();
        lottoService.makeWinningLotto(winningLottoNumbers, bonusBallNumber);

        Map<Rank, Integer> lottoResult = lottoService.result(mergedLottos);
        OutputView.printResult(lottoResult, purchaseMoney);
    }
}
