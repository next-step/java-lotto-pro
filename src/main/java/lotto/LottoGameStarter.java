package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameStarter {

    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoMoneyChecker lottoMoneyChecker = new LottoMoneyChecker();

    public void start() {
        int gameMoney = inputGameMoney();
        int countOfManualGame = inputCountOfManualGame(gameMoney);
        Lottos lottos = purchaseLottos(countOfManualGame, gameMoney);
        List<Integer> winnerNumber = inputWinnerNumbers();
        BonusBall bonusNumber = inputBonusNumber(winnerNumber);
        LottoWinnerNumbers lottoWinnerNumbers = new LottoWinnerNumbers(winnerNumber, bonusNumber);
        List<LottoWinner> lottoWinners = lottoWinnerNumbers.calculateLottoResults(lottos);
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts(lottoWinners);
        LottosResult lottosResult = new LottosResult(gameMoney, lottosWinnerCounts);
        ResultView.printLottoResults(lottosWinnerCounts, lottosResult);
    }

    private int inputCountOfManualGame(int money) {
        InputView.printEnterCountOfManualGame();
        return scanCountOfManualGame(money);
    }

    private int scanCountOfManualGame(int money) {
        int count = InputView.scanNumberValue();
        lottoMoneyChecker.validateCountOfManualGame(count, money);
        return count;
    }

    private int inputGameMoney() {
        InputView.printEnterGameMoney();
        return scanGameMoney();
    }

    private int scanGameMoney() {
        int gameMoney = InputView.scanNumberValue();
        lottoMoneyChecker.validateMoney(gameMoney);
        return gameMoney;
    }

    private List<Integer> inputWinnerNumbers() {
        InputView.printEnterWinnerNumber();
        return InputView.scanLottoNumber();
    }

    private BonusBall inputBonusNumber(List<Integer> winnerNumber) {
        InputView.printEnterBonusBall();
        return new BonusBall(InputView.scanBonusBall(), winnerNumber);
    }

    private Lottos purchaseLottos(int countOfManualCount, int gameMoney) {
        int countOfAutoGame = lottoMoneyChecker.calculatePurchasingAutoGameCount(countOfManualCount, gameMoney);
        Lottos lottos = lottoMachine.purchase(countOfManualCount, countOfAutoGame);
        ResultView.printResultPurchase(countOfManualCount, countOfAutoGame);
        ResultView.printLottos(lottos);
        return lottos;
    }

    public static void main(String[] args) {
        LottoGameStarter lottoGameStarter = new LottoGameStarter();
        lottoGameStarter.start();
    }
}
