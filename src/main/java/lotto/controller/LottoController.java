package lotto.controller;

import static lotto.constants.LottoGuideMessage.*;
import static lotto.constants.LottoGuideMessage.BONUS_BALL_INPUT;
import static lotto.constants.LottoGuideMessage.LAST_WINNING_INPUT;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.LottoGuideMessage;
import lotto.domain.LottoCount;
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
        LottoCount manualLottoCount = lottoInputView.inputManualLottoPurchaseCount(money.calculateLottoCount());
        LottoTicket lottoTicket = purchaseLottoTicket(money, manualLottoCount);
        resultView.printLottos(lottoTicket);

        LottoNumbers lastWinningLottoNumbers = LottoNumbers.generateBy(inputLastWinningLottoNumbers());
        LottoNumber bonusBallNumber = inputBonusBall(lastWinningLottoNumbers);

        WinningStatistics winningStatistics = WinningStatistics.of(lottoTicket, money, lastWinningLottoNumbers, bonusBallNumber);
        winningStatistics.statistics();

        resultView.printWinningStatistics(winningStatistics);
    }

    private LottoTicket purchaseLottoTicket(Money money, LottoCount manualLottoCount) {
        LottoTicket lottoTicket = lottoMarket.purchaseAutoLottoTicket(money, manualLottoCount);
        LottoTicket manualLottoTicket = lottoMarket.purchaseManualLottoTicket(inputManualLottoNumbers(manualLottoCount));
        lottoTicket.merge(manualLottoTicket);
        return lottoTicket;
    }

    private List<LottoNumbers> inputManualLottoNumbers(LottoCount manualLottoCount) {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS);
        List<LottoNumbers> inputManualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount.getCount(); i++) {
            inputManualLottoNumbers.add(LottoNumbers.generateBy(
                lottoInputView.inputLottoNumbers(INPUT_MANUAL_LOTTO_NUMBERS)));
        }
        return inputManualLottoNumbers;
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
