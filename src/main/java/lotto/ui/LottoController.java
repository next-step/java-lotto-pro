package lotto.ui;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void run() {
        int quantity = purchaseLotto();
        LottoTicket lottoTicket = createLotto(quantity);
        WinningLotto winningLotto = inputWinningNumber();
        createStatisticsResult(lottoTicket, winningLotto);
    }

    private void createStatisticsResult(final LottoTicket lottoTicket, final WinningLotto winningLotto) {
        ResultView.printWinningStatistics();
        StatisticsResult statisticsResult = StatisticsGenerator.create(lottoTicket, winningLotto);
        ResultView.printStatisticsResult(statisticsResult);
    }

    private WinningLotto inputWinningNumber() {
        List<Integer> numbers = InputView.inputWinningNumber();
        return new WinningLotto(numbers);
    }

    private LottoTicket createLotto(final int quantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < quantity; i++) {
            List<Integer> generatedNumbers = LottoGenerator.create();
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
