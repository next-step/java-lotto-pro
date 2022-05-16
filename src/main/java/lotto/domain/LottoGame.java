package lotto.domain;

import java.util.List;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    private final LottoGroups lottoGroups;
    private final Money money;

    public LottoGame(LottoGroups lottoGroups, Money money) {
        this.lottoGroups = lottoGroups;
        this.money = money;
    }

    public void playGame() {
        ResultView.printCount(money.calculateLottoCount());
        ResultView.printLottoGroups(lottoGroups);
        String winLottoNumbers = InputView.inputWinLotto();
        int bonusNumber = InputView.inputBonusNumber();
        List<Rank> matchResults = lottoGroups.matchResults(new WinningLotto(winLottoNumbers, bonusNumber));
        ResultView.printStatistics(matchResults, money);
    }
}
