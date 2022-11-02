package step3;

import step3.domain.LotteryTicket;
import step3.domain.Payment;
import step3.domain.Statistics;
import step3.domain.WinningBonusNumber;
import step3.ui.InputView;
import step3.ui.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    public LottoController(InputView inputView, ResultView resultView){
        this.inputView = inputView;
        this.resultView = resultView;
    }
    public void start() {
        Payment payment = new Payment(inputView.inputPayment(), inputView.inputManualCount());

        LottoGenerator lottoGenerator = new LottoGenerator();
        LotteryTicket lotteryTicket = lottoGenerator.generateLotteryTicket(payment);

        resultView.resultLotteryTicket(lotteryTicket);

        WinningBonusNumber winningBonusNumber =
                new WinningBonusNumber(inputView.inputWinningNumber(), inputView.inputBonusNumber());

        Statistics statistics = new Statistics(lotteryTicket, winningBonusNumber);
        resultView.resultStatistics(statistics, payment);
    }
}
