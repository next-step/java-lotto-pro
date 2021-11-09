package lotto;

import lotto.factory.LottoCreateFactory;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Price;
import lotto.model.Result;
import lotto.util.Console;
import lotto.view.InputHandler;
import lotto.view.Message;
import lotto.view.ResultView;
import lotto.view.View;

import java.util.List;

public class LottoGame {
    private static Lottos lottos;
    private static Lotto winLotto;

    public void run() {
        try {
            buyLotto();

            //setWinningLotto();

            //statistics();
        } catch (Exception e) {
            View.print(e.getMessage());
        }
    }

    private void buyLotto() {
        View.print(Message.PURCHASE_AMOUNT);
        int lottoCount = InputHandler.price(Console.readLine());
        ResultView.printBought(lottoCount);
        lottos = LottoCreateFactory.createLottos(lottoCount);
        View.print(lottos.toString());
    }

    /*private void setWinningLotto() {
        View.print(Message.WINNING_NUMBER);
        List<Integer> winLottoNumbers = InputHandler.splitTextToInts(Console.readLine());
        winLotto = LottoCreateFactory.createLotto(winLottoNumbers);
    }

    private void statistics() {
        View.print(Message.WINNING_STATS);
        View.print(Message.WINNING_LINE);
        Result result = new Result(lottos, winLotto);
        ResultView.printReport(result.getMatchResult());
        ResultView.printYield(result.yield(lottos.size()));
    }*/
}
