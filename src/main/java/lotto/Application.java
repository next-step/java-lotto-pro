package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoReport;
import lotto.domain.Player;
import lotto.domain.WinnerLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    public static void main(String[] args) {
        Player player = Player.buyAutoLotto(autoLottoDeposit());
        ResultView.playerHasLotto(player);

        WinnerLotto winnerLotto = bonusNumberInput(lastWeekWinnerLotto());

        LottoReport lottoReport = player.matchWinnerLotto(winnerLotto);

        ResultView.winnerReport(lottoReport);

    }

    private static int autoLottoDeposit() {
        int despotMoney = InputView.userPriceInput();
        if (despotMoney < Lotto.LOTTO_MONEY) {
            return InputView.retryPriceInput();
        }
        return despotMoney;
    }

    private static WinnerLotto bonusNumberInput(Lotto winnerLotto) {
        try {
            return new WinnerLotto(winnerLotto, LottoNumber.of(InputView.bonusNumberInput()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusNumberInput(winnerLotto);
        }
    }

    private static Lotto lastWeekWinnerLotto() {
        try {
            return Lotto.createCustomLotto(InputView.winnerNumberInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lastWeekWinnerLotto();
        }
    }



}
