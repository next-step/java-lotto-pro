package step3;

import step3.domain.*;
import step3.ui.ConsoleInputView;
import step3.ui.ConsoleResultView;

public class LottoController {
    public LottoController(){
    }
    public void start() {
        LotteryTicket lotteryTicket = new LotteryTicket(ConsoleInputView.inputPayment());
        lottoFactory(lotteryTicket);
    
        ConsoleResultView.resultLotteryTicket(lotteryTicket);
       
        WinningBonusNumber winningBonusNumber = new WinningBonusNumber(ConsoleInputView.inputWinningNumber(), ConsoleInputView.inputBonusNumber());
        
        Statistics statistics = new Statistics(lotteryTicket, winningBonusNumber);
        ConsoleResultView.resultStatistics(statistics, lotteryTicket.getPayment());
    }
    
    private static void lottoFactory(LotteryTicket lotteryTicket){
        Payment payment = lotteryTicket.getPayment();
        for (int i = 0; i < payment.getLottoCount(); i++){
            LottoGenerator lottoGenerator = new LottoGenerator();
            lotteryTicket.add(lottoGenerator.lottoGenerate());
        }
    }
}
