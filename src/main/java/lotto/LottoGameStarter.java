package lotto;

import lotto.domain.*;
import lotto.domain.vo.AutoGameCount;
import lotto.domain.vo.ManualGameCount;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameStarter {

    private final LottoMachine lottoMachine = new LottoMachine();

    public void start() {
        int gameMoney = inputGameMoney();
        ManualGameCount manualGameCount = inputCountOfManualGame(gameMoney);
        Lottos lottos = purchaseLottos(manualGameCount, gameMoney);
        List<Integer> winnerNumber = inputWinnerNumbers();
        BonusBall bonusNumber = inputBonusNumber(winnerNumber);
        LottoWinnerNumbers lottoWinnerNumbers = new LottoWinnerNumbers(winnerNumber, bonusNumber);
        List<LottoWinner> lottoWinners = lottoWinnerNumbers.calculateLottoResults(lottos);
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts(lottoWinners);
        LottosResult lottosResult = new LottosResult(gameMoney, lottosWinnerCounts);
        ResultView.printLottoResults(lottosWinnerCounts, lottosResult);
    }

    private ManualGameCount inputCountOfManualGame(int money) {
        InputView.printEnterCountOfManualGame();
        int count = scanCountOfManualGame(money);
        return new ManualGameCount(count, money);
    }

    private int scanCountOfManualGame(int money) {
        return InputView.scanNumberValue();
    }

    private int inputGameMoney() {
        InputView.printEnterGameMoney();
        return scanGameMoney();
    }

    private int scanGameMoney() {
        int gameMoney = InputView.scanNumberValue();
        LottoMoneyChecker.validateMoney(gameMoney);
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

    private Lottos purchaseLottos(ManualGameCount manualGameCount, int gameMoney) {
        AutoGameCount autoGameCount = new AutoGameCount(manualGameCount, gameMoney);
        Lottos lottos = lottoMachine.purchase(manualGameCount, autoGameCount);
        ResultView.printResultPurchase(manualGameCount, autoGameCount);
        ResultView.printLottos(lottos);
        return lottos;
    }

    public static void main(String[] args) {
        LottoGameStarter lottoGameStarter = new LottoGameStarter();
        lottoGameStarter.start();
    }
}
