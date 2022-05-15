package lotto;

import lotto.ui.InputView;

public class Main {

    public static void main(String[] args) {
        int purchasePrice = InputView.getPurchasePrice();
        LottoGame game = new LottoGame(purchasePrice);
        String winnerNumbers = InputView.getWinnerNumbers();
    }
}
