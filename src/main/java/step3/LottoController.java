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
        LotteryTicket lotteryTicket = new LotteryTicket(payment);
        lottoFactory(lotteryTicket);
    
        resultView.resultLotteryTicket(lotteryTicket);

        WinningBonusNumber winningBonusNumber =
                new WinningBonusNumber(inputView.inputWinningNumber(), inputView.inputBonusNumber());

        Statistics statistics = new Statistics(lotteryTicket, winningBonusNumber);
        resultView.resultStatistics(statistics, lotteryTicket.getPayment());
    }
    
    private static void lottoFactory(LotteryTicket lotteryTicket){
        Payment payment = lotteryTicket.getPayment();
        for (int i = 0; i < payment.getLottoCount(); i++){
            LottoGenerator lottoGenerator = new LottoGenerator();
            lotteryTicket.add(lottoGenerator.lottoGenerate());
        }
    }
}
