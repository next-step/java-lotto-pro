package lotto;

import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        game.readMoney();
        game.purchaseLotto();
        game.printMyLotto();
        game.readLastWinningNumbers();
        game.showLottoStatistics();
        game.showLottoProfit();
    }
}
