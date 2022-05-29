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
        BonusBall bonusNumber = inputBonusNumber(winnerNumber);
        LottoWinnerNumbers lottoWinnerNumbers = new LottoWinnerNumbers(winnerNumber, bonusNumber);
        List<LottoWinner> lottoWinners = lottoWinnerNumbers.calculateLottoResults(lottos);
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts(lottoWinners);
        LottosResult lottosResult = new LottosResult(gameMoney, lottosWinnerCounts);
        ResultView.printLottoResults(lottosWinnerCounts, lottosResult);
    }

    private int scanGameMoney() {
        int gameMoney = InputView.scanGameMoney();
        lottoMoneyChecker.validateMoney(gameMoney);
        return gameMoney;
    }

    private List<Integer> inputWinnerNumbers() {
        InputView.printEnterWinnerNumber();
        List<Integer> winnerNumber = InputView.scanWinnerNumber();
        LottoNumberValidator.validLottoNumbers(winnerNumber);
        return winnerNumber;
    }

    private BonusBall inputBonusNumber(List<Integer> winnerNumber) {
        InputView.printEnterBonusBall();
        return new BonusBall(InputView.scanBonusBall(), winnerNumber);
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
