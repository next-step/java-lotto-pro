package lotto.ui;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void run() {
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        int quantity = purchaseLotto();
        LottoTicket lottoTicket = createLotto(lottoGenerator, quantity);
        WinningLotto winningLotto = inputWinningNumber();
        createStatisticsResult(lottoTicket, winningLotto);
    }

    private void createStatisticsResult(final LottoTicket lottoTicket, final WinningLotto winningLotto) {
        ResultView.printWinningStatistics();
        StatisticsResult statisticsResult = StatisticsGenerator.create(lottoTicket, winningLotto);
        ResultView.printStatisticsResult(statisticsResult);
    }

    private WinningLotto inputWinningNumber() {
        return new WinningLotto(InputView.inputWinningNumber(), InputView.inputBonusNumber());
    }

    private LottoTicket createLotto(final RandomLottoGenerator lottoGenerator, final int quantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> generatedNumbers = lottoGenerator.create();
            lottoList.add(new Lotto(generatedNumbers));
        }
        return new LottoTicket(lottoList);
    }

    private int purchaseLotto() {
        int quantity = InputView.inputPurchaseAmount();
        ResultView.printMessage(ConsoleMessage.OUTPUT_PURCHASE_COMPLETE.getMessage(), quantity);
        return quantity;
    }
}
