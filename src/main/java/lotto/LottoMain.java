package lotto;

import lotto.domain.*;
import lotto.view.ResultView;

import java.util.List;

import static lotto.domain.Lotto.generateLottoGame;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.lottoGameResultMessage;
import static lotto.view.ResultView.lottoGameStatisticsMessage;

public class LottoMain {

    public static void main(String[] args) {
        Money money = new Money(inputMoney());
        int gameCount = Lotto.gameCount(money);

        ResultView.purchasesCountMessage(gameCount);
        List<LottoNumbers> lottoNumbers = generateLottoGame(gameCount);
        Lotto lotto = new Lotto(lottoNumbers);

        LottoWiningNumbers lottoWiningNumbers = new LottoWiningNumbers(lastWeekWinningNumberString());
        BonusBall bonusBall = new BonusBall(bonusNumberString());
        LottoRanks lottoRanks = new LottoRanks(lotto.gamePlay(lottoWiningNumbers.generate(), bonusBall));

        double lottoGameEarningsRate = LottoResult.lottoGameEarningsRate(money.currentMoney(), lottoRanks);

        lottoGameResultMessage(lottoRanks);
        lottoGameStatisticsMessage(lottoGameEarningsRate);
    }
}
