package lotto;

import lotto.factory.LottoCreateFactory;
import lotto.model.*;
import lotto.util.Console;
import lotto.view.InputHandler;
import lotto.view.Message;
import lotto.view.ResultView;
import lotto.view.View;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private LottosCount lottosCount;
    private Lottos totalLottos;
    private WinningLotto winningLotto;

    public void run() {
        try {
            buyLotto();

            createLotto();

            inputWinningLotto();

            statistics();
        } catch (Exception e) {
            View.print(e.getMessage());
        }
    }

    private void buyLotto() {
        View.print(Message.PURCHASE_AMOUNT);
        int price = InputHandler.validStringToInt(Console.readLine());
        int totalCount = Price.numberPurchases(price);

        View.print(Message.MANUAL_PURCHASE);
        int manualCount = InputHandler.validStringToInt(Console.readLine());
        lottosCount = new LottosCount(totalCount, manualCount);
    }

    private void createLotto() {
        View.print(Message.MANUAL_LOTTO);
        List<String> manualLottoTexts = inputManualLotto(lottosCount.getManual());
        totalLottos = LottoCreateFactory.createTotalLottos(lottosCount, manualLottoTexts);
        ResultView.printBought(lottosCount);
        ResultView.printLottoList(totalLottos);
    }

    private List<String> inputManualLotto(int manual) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < manual; i++) {
            result.add(Console.readLine());
        }
        return result;
    }

    private void inputWinningLotto() {
        View.print(Message.WINNING_NUMBER);
        List<Integer> winLottoNumbers = InputHandler.splitTextToInts(Console.readLine());
        View.print(Message.BONUS_NUMBER);
        int bonusNumber = InputHandler.validStringToInt(Console.readLine());
        winningLotto = LottoCreateFactory.createWinningLotto(winLottoNumbers, bonusNumber);
    }

    private void statistics() {
        View.print(Message.WINNING_STATS);
        View.print(Message.WINNING_LINE);
        Result result = new Result(totalLottos, winningLotto);
        ResultView.printReport(result.getMatchResult());
        ResultView.printYield(result.yield(totalLottos.size()));
    }
}
