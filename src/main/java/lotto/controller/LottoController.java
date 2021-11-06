package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.Result;
import lotto.service.LottoCreateFactory;
import lotto.util.Console;
import lotto.util.PriceUtil;
import lotto.view.Message;
import lotto.view.ResultView;
import lotto.view.View;

import java.math.BigInteger;
import java.util.Map;

public class LottoController {
    private Lottos lottos;
    private Lotto winLotto;

    public void start(){
        View.print(Message.PURCHASE_AMOUNT);
        try {
            inputPurchase();
        }catch (Exception e){
            View.print(e.getMessage());
            inputPurchase();
        }
    }

    //로또 구입
    private void inputPurchase() {
        String priceText = Console.readLine();
        printLottoCount(priceText);
    }

    //로또 갯수 출력
    private void printLottoCount(String priceText) {
        int lottoCount = PriceUtil.getCount(Integer.parseInt(priceText));
        ResultView.printBought(lottoCount);
        buyLottos(lottoCount);
    }

    // 로또 표출
    private void buyLottos(int lottoCount) {
        lottos = LottoCreateFactory.createLottos(lottoCount);
        View.print(lottos.toString());
        putWinLotto();
    }

    private void putWinLotto() {
        View.print(Message.WINNING_NUMBER);
        try {
            inputWinLotto();
        }catch (Exception e){
            View.print(e.getMessage());
            inputWinLotto();
        }
    }

    private void inputWinLotto() {
        String winLottoText = Console.readLine();
        winLotto = LottoCreateFactory.createLotto(winLottoText);
        printStatsMessage();
    }

    private void printStatsMessage() {
        View.print(Message.WINNING_STATS);
        View.print(Message.WINNING_LINE);
        winStatistics();
    }

    private void winStatistics() {
        try{
            Map<Rank, Integer> matchResult = lottos.matchResult(winLotto);
            Result result = new Result(matchResult);
            View.print(result.toString());
            BigInteger purchase = PriceUtil.getPurchase(lottos.size());
            ResultView.printYield(result.yield(purchase));
        }catch (Exception e){
            View.print(e.getMessage());
        }
    }
}
