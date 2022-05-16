package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoReport;
import lotto.domain.Player;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    public static void main(String[] args) {
        Player player = Player.buyAutoLotto(autoLottoDeposit());
        ResultView.playerHasLotto(player);

        Lotto winnerLotto = lastWeekWinnerLotto();
        LottoNumber bonusNumber = bonusNumberInput(winnerLotto);

        LottoReport lottoReport = player.matchWinnerLotto(winnerLotto, bonusNumber);

        ResultView.winnerReport(lottoReport);

    }

    private static int autoLottoDeposit() {
        int despotMoney = InputView.userPriceInput();
        if (despotMoney < Lotto.LOTTO_MONEY) {
            return InputView.retryPriceInput();
        }
        return despotMoney;
    }

    private static LottoNumber bonusNumberInput(Lotto winnerLotto) {
        try {
            return LottoNumber.createBonusNumber(winnerLotto, InputView.bonusNumberInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusNumberInput(winnerLotto);
        }
    }

    private static Lotto lastWeekWinnerLotto() {
        return Lotto.createCustomLotto(InputView.winnerNumberInput());
    }



}
