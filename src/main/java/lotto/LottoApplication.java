package lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.LottoStore;
import lotto.domain.lotto.Money;
import lotto.domain.lotto.pick.CombinedNumberPickStrategy;
import lotto.domain.lotto.pick.DefaultRandomNumberGenerator;
import lotto.domain.lotto.pick.NumberPickStrategy;
import lotto.domain.lotto.pick.PlayerPickStrategy;
import lotto.domain.lotto.pick.QuickPickStrategy;
import lotto.domain.statistics.MatchingResult;
import lotto.ui.BuyLottoView;
import lotto.ui.WinningStatisticsView;
import lotto.ui.dto.BuyLottoInput;
import lotto.ui.dto.BuyLottoOutput;
import lotto.ui.dto.WinningNumbersInput;
import lotto.ui.dto.WinningStatisticsOutput;

public class LottoApplication {

    public static final Money LOTTO_UNIT_PRICE = new Money(1000);
    public static final NumberPickStrategy QUICK_PICK = new QuickPickStrategy(
            new DefaultRandomNumberGenerator()
    );

    public static void main(String[] args) {
        final List<Lotto> lottos = buyLotto();

        showLottoResults(lottos);
    }

    private static List<Lotto> buyLotto() {
        final LottoStore store = new LottoStore(LOTTO_UNIT_PRICE);
        final BuyLottoInput buyLottoInput = BuyLottoView.buyLotto();

        final List<LottoNumbers> playerPicks = buyLottoInput.getPlayerPicks();
        final NumberPickStrategy pickStrategy = new CombinedNumberPickStrategy(
                new PlayerPickStrategy(playerPicks),
                QUICK_PICK
        );
        final List<Lotto> lottos = store.buyLottos(buyLottoInput.getMoney(), pickStrategy);

        BuyLottoView.printLottos(new BuyLottoOutput(lottos, playerPicks.size()));
        return lottos;
    }

    private static void showLottoResults(List<Lotto> lottos) {
        final WinningNumbersInput winningNumbersInput = WinningStatisticsView.receiveWinningNumbers();
        final MatchingResult matchingResult = MatchingResult.analyze(
                lottos,
                LOTTO_UNIT_PRICE,
                winningNumbersInput.toWinningNumbers()
        );
        WinningStatisticsView.printResult(new WinningStatisticsOutput(matchingResult));
    }
}
