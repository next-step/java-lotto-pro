package lotto.domain;

import java.util.List;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    private final LottoGroups lottoGroups;
    private final Money money;
    private final LottoCount manualLottoCount;

    public LottoGame(LottoGroups lottoGroups, Money money, LottoCount manualLottoCount) {
        this.lottoGroups = lottoGroups;
        this.money = money;
        this.manualLottoCount = manualLottoCount;
    }

    public void playGame() {
        ResultView.printCount(manualLottoCount, money);
        ResultView.printLottoGroups(lottoGroups);
        String winLottoNumbers = InputView.inputWinLotto();
        int bonusNumber = InputView.inputBonusNumber();
        List<Rank> matchResults = lottoGroups.matchResults(new WinningLotto(winLottoNumbers, bonusNumber));
        ResultView.printStatistics(matchResults, money);
    }
}
