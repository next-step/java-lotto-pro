package step3;

import step3.domain.LotteryTicket;
import step3.domain.Lotto;
import step3.domain.Payment;
import step3.domain.Statistics;
import step3.domain.WinningBonusNumber;
import step3.ui.InputView;
import step3.ui.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        Payment payment = new Payment(inputView.inputPayment(), inputView.inputManualCount());
        LotteryTicket lotteryTicket = lottoFactory(payment);
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoGenerator.generateLotteryTicket(lotteryTicket, payment);

        resultView.resultLotteryTicket(lotteryTicket, payment);

        WinningBonusNumber winningBonusNumber =
                new WinningBonusNumber(inputView.inputWinningNumber(), inputView.inputBonusNumber());

        Statistics statistics = new Statistics(lotteryTicket, winningBonusNumber);
        resultView.resultStatistics(statistics, payment);
    }

    private LotteryTicket lottoFactory(Payment payment) {
        resultView.printRequestManualNumber();
        LotteryTicket lotteryTicket = new LotteryTicket();
        for (int i = 0; i < payment.getManualLottoCount(); i++) {
            Lotto winningNumber = new Lotto(inputView.inputManualNumber());
            lotteryTicket.add(winningNumber);
        }
        return lotteryTicket;
    }
}
