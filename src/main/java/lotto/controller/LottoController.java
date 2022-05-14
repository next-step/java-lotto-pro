package lotto.controller;

import static lotto.constants.LottoGuideMessage.LAST_WINNING_INPUT;

import java.util.List;
import lotto.domain.LottoMarket;
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

        WinningStatistics winningStatistics = WinningStatistics.of(lottoTicket, lastWinningLottoNumbers, money);
        winningStatistics.statistics();

        resultView.printWinningStatistics(winningStatistics);
    }

    private List<Integer> inputLastWinningLottoNumbers() {
        System.out.println(LAST_WINNING_INPUT);
        return lottoInputView.inputLottoNumbers(LAST_WINNING_INPUT);
    }
}
