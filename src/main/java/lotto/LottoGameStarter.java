package lotto;

import lotto.domain.LottoWinner;
import lotto.domain.Lottos;
import lotto.domain.LottosResult;
import lotto.domain.LottosWinnerCounts;
import lotto.service.LottoWinnerService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameStarter {

    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoWinnerService lottoWinnerService = new LottoWinnerService();
    private final LottoMoneyChecker lottoMoneyChecker = new LottoMoneyChecker();

    public void start() {
        InputView.printEnterGameMoney();
        int gameMoney = InputView.scanGameMoney();
        Lottos lottos = purchaseLottos(gameMoney);
        List<Integer> winnerNumber = inputWinnerNumbers();
        List<LottoWinner> lottoWinners = calculateLottoResults(lottos, winnerNumber);
        LottosWinnerCounts lottosWinnerCounts = lottoWinnerService.makeLottosWinnerCounts(lottoWinners);
        LottosResult lottosResult = new LottosResult(gameMoney, lottosWinnerCounts);
        ResultView.printLottoResults(lottosWinnerCounts, lottosResult);
    }

    private List<LottoWinner> calculateLottoResults(Lottos lottos, List<Integer> winnerNumber) {
        List<LottoWinner> lottoResults = new ArrayList<>();
        for (int i = 0; i < lottos.gameCount(); i++) {
            LottoWinner judge = lottoWinnerService.judge(winnerNumber, lottos.getLotto(i));
            lottoResults.add(judge);
        }
        return lottoResults;
    }

    private List<Integer> inputWinnerNumbers() {
        InputView.printEnterWinnerNumber();
        List<Integer> winnerNumber = InputView.scanWinnerNumber();
        return winnerNumber;
    }

    private Lottos purchaseLottos(int gameMoney) {
        int purchasingCount = lottoMoneyChecker.calculatePurchasingCount(gameMoney);
        Lottos lottos = lottoMachine.purchase(purchasingCount);
        ResultView.printResultPurchase(purchasingCount);
        ResultView.printLottos(lottos);
        return lottos;
    }

    public static void main(String[] args) {
        LottoGameStarter lottoGameStarter = new LottoGameStarter();
        lottoGameStarter.start();
    }
}
