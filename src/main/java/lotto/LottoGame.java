package lotto;

import lotto.factory.LottoCreateFactory;
import lotto.model.*;
import lotto.util.Console;
import lotto.view.InputHandler;
import lotto.view.Message;
import lotto.view.ResultView;
import lotto.view.View;

import java.util.List;

public class LottoGame {
    private Lottos lottos;
    private WinningLotto winningLotto;

    public void run() {
        try {
            buyLotto();

            enterWinningLotto();

            statistics();
        } catch (Exception e) {
            View.print(e.getMessage());
        }
    }

    private void buyLotto() {
        View.print(Message.PURCHASE_AMOUNT);
        int lottoCount = InputHandler.price(Console.readLine());
        ResultView.printBought(lottoCount);
        lottos = LottoCreateFactory.createLottos(lottoCount);
        ResultView.printLottoList(lottos);
    }

    private void enterWinningLotto() {
        View.print(Message.WINNING_NUMBER);
        List<Integer> winLottoNumbers = InputHandler.splitTextToInts(Console.readLine());
        View.print(Message.BONUS_NUMBER);
        int bonusNumber = InputHandler.validStringToInt(Console.readLine());
        winningLotto = LottoCreateFactory.createWinningLotto(winLottoNumbers, bonusNumber);
    }

    private void statistics() {
        View.print(Message.WINNING_STATS);
        View.print(Message.WINNING_LINE);
        Result result = new Result(lottos, winningLotto);
        ResultView.printReport(result.getMatchResult());
        ResultView.printYield(result.yield(lottos.size()));
    }
}
