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

    public void run() {
        try {
            LottosCount lottosCount = buyLotto();

            final Lottos totalLottos = createLotto(lottosCount);

            final WinningLotto winningLotto = inputWinningLotto();

            statistics(totalLottos, winningLotto);
        } catch (Exception e) {
            View.print(e.getMessage());
        }
    }

    private LottosCount buyLotto() {
        View.print(Message.PURCHASE_AMOUNT);
        int price = InputHandler.validStringToInt(Console.readLine());
        int totalCount = Price.numberPurchases(price);

        View.print(Message.MANUAL_PURCHASE);
        int manualCount = InputHandler.validStringToInt(Console.readLine());
        return new LottosCount(totalCount, manualCount);
    }

    private Lottos createLotto(LottosCount lottosCount) {
        View.print(Message.MANUAL_LOTTO);
        List<Lotto> inputManualLottos = inputManualLotto(lottosCount.getManual());
        Lottos totalLottos = LottoCreateFactory.createTotalLottos(lottosCount, inputManualLottos);
        ResultView.printBought(lottosCount);
        ResultView.printLottoList(totalLottos);
        return totalLottos;
    }

    private List<Lotto> inputManualLotto(int manual) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < manual; i++) {
            result.add(Console.readLine());
        }
        return InputHandler.createManualLotto(result);
    }

    private WinningLotto inputWinningLotto() {
        View.print(Message.WINNING_NUMBER);
        List<Integer> winLottoNumbers = InputHandler.splitTextToInts(Console.readLine());
        View.print(Message.BONUS_NUMBER);
        int bonusNumber = InputHandler.validStringToInt(Console.readLine());
        return LottoCreateFactory.createWinningLotto(winLottoNumbers, bonusNumber);
    }

    private void statistics(Lottos totalLottos, WinningLotto winningLotto) {
        View.print(Message.WINNING_STATS);
        View.print(Message.WINNING_LINE);
        Result result = new Result(totalLottos, winningLotto);
        ResultView.printReport(result.getMatchResult());
        ResultView.printYield(result.yield(totalLottos.size()));
    }
}
