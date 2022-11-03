package lotto.controller;

import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.ticket.Ticket;
import lotto.domain.ticket.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Lotto lotto;
    private Money money;
    private Tickets myTickets;
    private Ticket winningTicket;
    private Result myResult;
    
    private int manualTicketBuyCount;
    private int autoTicketBuyCount;
    
    public void playLotto() {
        initLotto();
        
        setMoney();
        
        setAutoTickets();
        
        setManualTickets();
        
        this.myTickets = lotto.getMyTickets();

        OutputView.printHowManyTicketsPurchased(manualTicketBuyCount, autoTicketBuyCount);
        OutputView.print(this.myTickets.toString());
        
        setWinningTicket();

        checkResult();
    }
    
    private void initLotto() {
        this.lotto = new Lotto();
    }
    
    private void setMoney() {
        try {
            OutputView.startLottoOutput();
            
            this.money = new Money(InputView.getStringInput());
        }catch(IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            
            setMoney();
        }
    }
    
    private void setAutoTickets() {
        try {
            OutputView.printHowManyManualTickets();
            
            this.manualTicketBuyCount = InputView.getIntegerInput();
            this.autoTicketBuyCount = lotto.buyAutoTickets(money, manualTicketBuyCount);
        }catch(IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            
            setAutoTickets();
        }
    }
    
    private void setManualTickets() {
        try {
            OutputView.printBuyManualTickets();
            
            buyManualTicketsWithInput();
        }catch(IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            
            setManualTickets();
        }
    }
    
    private void buyManualTicketsWithInput() {
        IntStream.range(0, manualTicketBuyCount).forEach(i -> {
            this.lotto.buyManualTicket(InputView.getStringInput());
        });
    }
    
    private void setWinningTicket() {
        try {
            OutputView.printWinningLottoNumOutput();
            
            String winningTicketNumbers = InputView.getStringInput();
    
            OutputView.printBonusNumOutput();
            
            this.winningTicket = new Ticket(winningTicketNumbers, InputView.getStringInput());
        }catch(IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            
            setWinningTicket();
        }
    }
    
    private void checkResult() {
        this.myResult = new Result();
        
        this.myTickets.countTicketResult(this.myResult, this.winningTicket);
        this.myResult.checkResultRate(this.money);
        
        OutputView.printResultOutput(this.myResult.winningMap, this.myResult.returnRate);
    }
}
