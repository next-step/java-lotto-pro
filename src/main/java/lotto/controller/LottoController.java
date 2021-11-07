package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Price;
import lotto.model.Result;
import lotto.service.LottoCreateFactory;
import lotto.util.Console;
import lotto.view.InputHandler;
import lotto.view.Message;
import lotto.view.ResultView;
import lotto.view.View;

import java.math.BigInteger;

public class LottoController {
    private Lottos lottos;
    private Lotto winLotto;

    public void start() {
        View.print(Message.PURCHASE_AMOUNT);
        try {
            inputPurchase();
        } catch (Exception e) {
            View.print(e.getMessage());
            inputPurchase();
        }
    }

    private void inputPurchase() {
        String priceText = Console.readLine();
        int lottoCount = InputHandler.price(priceText);
        printLottoCount(lottoCount);
    }

    private void printLottoCount(int lottoCount) {
        ResultView.printBought(lottoCount);
        buyLottos(lottoCount);
    }

    private void buyLottos(int lottoCount) {
        lottos = LottoCreateFactory.createLottos(lottoCount);
        View.print(lottos.toString());
        putWinLotto();
    }

    private void putWinLotto() {
        View.print(Message.WINNING_NUMBER);
        try {
            inputWinLotto();
        } catch (Exception e) {
            View.print(e.getMessage());
            inputWinLotto();
        }
    }

    private void inputWinLotto() {
        String winLottoText = Console.readLine();
        int[] winLottoNumbers = InputHandler.splitTextToInts(winLottoText);
        winLotto = LottoCreateFactory.createLotto(winLottoNumbers);
        printStatsMessage();
    }

    private void printStatsMessage() {
        View.print(Message.WINNING_STATS);
        View.print(Message.WINNING_LINE);
        winStatistics();
    }

    private void winStatistics() {
        try {
            Result result = new Result(lottos,winLotto);
            View.print(result.toString());
            printYield(result);
        } catch (Exception e) {
            View.print(e.getMessage());
        }
    }

    private void printYield(Result result) {
        BigInteger purchase = Price.getPurchase(lottos.size());
        ResultView.printYield(result.yield(purchase));
    }
}
