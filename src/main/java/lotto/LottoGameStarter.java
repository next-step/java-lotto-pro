package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameStarter {

    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoMoneyChecker lottoMoneyChecker = new LottoMoneyChecker();

    public void start() {
        InputView.printEnterGameMoney();
        int gameMoney = scanGameMoney();
        Lottos lottos = purchaseLottos(gameMoney);
        List<Integer> winnerNumber = inputWinnerNumbers();
        Integer bonusNumber = inputBonusNumber();
        List<LottoWinner> lottoWinners = calculateLottoResults(lottos, new LottoWinnerNumbers(winnerNumber, bonusNumber));
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts(lottoWinners);
        LottosResult lottosResult = new LottosResult(gameMoney, lottosWinnerCounts);
        ResultView.printLottoResults(lottosWinnerCounts, lottosResult);
    }

    private int scanGameMoney() {
        int gameMoney = InputView.scanGameMoney();
        lottoMoneyChecker.validateMoney(gameMoney);
        return gameMoney;
    }

    private List<LottoWinner> calculateLottoResults(Lottos lottos, LottoWinnerNumbers lottoWinnerNumbers) {
        List<LottoWinner> lottoResults = new ArrayList<>();
        for (int i = 0; i < lottos.gameCount(); i++) {
            LottoWinner judge = lottos.getLotto(i).judge(lottoWinnerNumbers);
            lottoResults.add(judge);
        }
        return lottoResults;
    }

    private List<Integer> inputWinnerNumbers() {
        InputView.printEnterWinnerNumber();
        List<Integer> winnerNumber = InputView.scanWinnerNumber();
        return winnerNumber;
    }

    private Integer inputBonusNumber() {
        InputView.printEnterBonusBall();
        return InputView.scanBonusBall();
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
