package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoReport;
import lotto.domain.Player;
import lotto.domain.PlayerMoney;
import lotto.domain.WinnerLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    public static void main(String[] args) {
        Player player = new Player(PlayerMoney.of(InputView.userPriceInput()));
        int manualLottoQty = manualLottoQtyInput(player);
        player.buyCustomLottos(manualLottoInput(manualLottoQty));
        player.buyAutoLottos();

        ResultView.printLottoAutoAndManualQty(manualLottoQty, player.lottoQty());
        ResultView.playerHasLotto(player);

        WinnerLotto winnerLotto = bonusNumberInput(lastWeekWinnerLotto());
        LottoReport lottoReport = player.matchWinnerLotto(winnerLotto);
        ResultView.winnerReport(lottoReport);
    }

    private static int manualLottoQtyInput(Player player) {
        int manualLottoQty = InputView.manualLottoQtyInput();
        if (player.isBuyAble(manualLottoQty)) {
            return manualLottoQty;
        }
        System.out.println("구매가능 수량이 넘었습니다.");
        return manualLottoQtyInput(player);
    }

    private static List<Lotto> manualLottoInput(int qty) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
            lottos.add(manualLottoInput());
        }
        return lottos;
    }

    private static Lotto manualLottoInput() {
        try {
            return Lotto.createCustomLotto(InputView.manualNumberInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("재 입력 해주세요");
            return manualLottoInput();
        }
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
