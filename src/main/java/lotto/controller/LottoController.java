package lotto.controller;

import static lotto.constants.LottoGuideMessage.BONUS_BALL_INPUT;
import static lotto.constants.LottoGuideMessage.LAST_WINNING_INPUT;

import java.util.List;
import lotto.domain.LottoMarket;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WinningStatistics;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoResultView resultView;
    private final LottoMarket lottoMarket;

    public LottoController() {
        this.lottoInputView = new LottoInputView();
        this.resultView = new LottoResultView();
        this.lottoMarket = new LottoMarket();
    }

    public void play() {
        Money money = lottoInputView.inputMoney();
        LottoTicket lottoTicket = lottoMarket.purchaseLottoTicket(money);
        resultView.printLottos(lottoTicket);

        LottoNumbers lastWinningLottoNumbers = LottoNumbers.generateBy(inputLastWinningLottoNumbers());
        LottoNumber bonusBallNumber = inputBonusBall(lastWinningLottoNumbers);

        WinningStatistics winningStatistics = WinningStatistics.of(lottoTicket, money, lastWinningLottoNumbers, bonusBallNumber);
        winningStatistics.statistics();

        resultView.printWinningStatistics(winningStatistics);
    }

    private LottoNumber inputBonusBall(LottoNumbers lastWinningLottoNumbers) {
        System.out.println(BONUS_BALL_INPUT);
        return lottoInputView.inputBonusBall(lastWinningLottoNumbers, BONUS_BALL_INPUT);
    }

    private List<Integer> inputLastWinningLottoNumbers() {
        System.out.println(LAST_WINNING_INPUT);
        return lottoInputView.inputLottoNumbers(LAST_WINNING_INPUT);
    }
}
