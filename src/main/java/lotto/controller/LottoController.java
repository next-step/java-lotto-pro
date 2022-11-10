package lotto.controller;

import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    
    public void playLotto() {
        try {
            //1. insert money
            OutputView.startLottoOutput();
            
            Money money = new Money(InputView.getStringInput());
            LottoMachine lottoMachine = new LottoMachine(money);

            //2. buy tickets
            OutputView.printHowManyManualTickets();
            
            int manualTicketBuyCount = InputView.getIntegerInput();
            int autoTicketBuyCount = lottoMachine.buyLottoAuto(manualTicketBuyCount);
            
            buyManualTicketsWithInput(manualTicketBuyCount, lottoMachine);
    
            OutputView.printHowManyTicketsPurchased(manualTicketBuyCount, autoTicketBuyCount);
            OutputView.print(lottoMachine.getLottoList());
            
            //3. set winningTicket
            OutputView.printWinningLottoNumOutput();
            Lotto winningTicket = new Lotto(InputView.getStringInput());
    
            OutputView.printBonusNumOutput();
            winningTicket.setBonusNum(InputView.getStringInput());
            
            //4. get result
            Result myResult = lottoMachine.getResult(winningTicket);
            OutputView.printResultOutput(myResult.winningMap, myResult.returnRate);
        }catch(IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            
            playLotto();
        }
    }
    
    private void buyManualTicketsWithInput(int manualTicketBuyCount, LottoMachine lottoMachine) {
        IntStream.range(0, manualTicketBuyCount).forEach(i -> {
            lottoMachine.buyLottoManual(InputView.getStringInput());
        });
    }

}
