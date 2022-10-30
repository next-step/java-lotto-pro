package step3;

import step3.domain.LotteryTicket;
import step3.domain.Payment;
import step3.domain.Statistics;
import step3.domain.WinningNumber;
import step3.ui.ConsoleInputView;
import step3.ui.ConsoleResultView;

public class LottoController {
    private final ConsoleInputView inputView;
    private final ConsoleResultView resultView;
    
    public LottoController(ConsoleInputView inputView, ConsoleResultView resultView){
        this.inputView = inputView;
        this.resultView = resultView;
    }
    public void start() {
        Payment payment = new Payment(inputView.inputPayment());
        LotteryTicket lotteryTicket = new LotteryTicket(payment);
        lottoFactory(lotteryTicket);
        
        resultView.resultLotteryTicket(lotteryTicket);
    
        WinningNumber winningNumber = new WinningNumber(inputView.inputWinningNumber());
        Statistics statistics = new Statistics(lotteryTicket, winningNumber);
        resultView.resultStatistics(statistics, payment);
    }
    
    private static void lottoFactory(LotteryTicket lotteryTicket){
        Payment payment = lotteryTicket.getPayment();
        for (int i = 0; i < payment.getLottoCount(); i++){
            LottoGenerator lottoGenerator = new LottoGenerator();
            lotteryTicket.add(lottoGenerator.lottoGenerate());
        }
    }
}
