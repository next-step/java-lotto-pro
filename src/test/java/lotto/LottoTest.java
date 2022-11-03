package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.ticket.Ticket;
import lotto.domain.ticket.Tickets;

public class LottoTest {    
    Lotto lotto;
    Tickets myTickets;
    Result myResult;
    Ticket winningTicket = new Ticket("1,2,3,4,5,6", "7");
    
    @BeforeEach
    public void initTest() {
        myTickets = new Tickets();
        myResult = new Result();
    }
    
    @Test
    @DisplayName("구입금액에_따른_발급로또_개수_확인")
    public void lotto_issue_count() {
        Money money = new Money("14000");
        this.lotto = new Lotto();
        this.myTickets = lotto.buyTickets(money);
        
        assertThat(this.myTickets.size()).isEqualTo(14);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,2,3,4,5,6':0"
                        , "'1,2,3,4,5,7':1"
                        , "'1,2,3,4,5,8':2"
                        , "'1,2,3,4,7,8':3"
                        , "'1,2,3,7,8,9':4"
                        }, delimiter = ':')
    @DisplayName("사용자_입력값과_로또_비교하여_결과_출력")
    public void lotto_get_result(String lottoNumber, int index) {
        myTickets.addTicket(new Ticket(lottoNumber));
        
        this.lotto = new Lotto(myTickets);
        
        this.myTickets.countTicketResult(this.myResult, this.winningTicket);
        this.myResult.checkResultRate(lotto.getUsedMoney());
        
        assertThat(this.myResult.winningMap.get(Rank.values()[index])).isEqualTo(1);
    }  
    
    @Test
    @DisplayName("사용자 입력값과 로또 비교하여 수익률 체크")
    public void lotto_get_return_rate() {
        myTickets.addTicket(new Ticket("8, 21, 23, 41, 42, 43"));
        myTickets.addTicket(new Ticket("3, 5, 11, 16, 32, 38"));
        myTickets.addTicket(new Ticket("7, 11, 16, 35, 36, 44"));
        myTickets.addTicket(new Ticket("1, 8, 11, 31, 41, 42"));
        myTickets.addTicket(new Ticket("13, 14, 16, 38, 42, 45"));
        myTickets.addTicket(new Ticket("7, 11, 30, 40, 42, 43"));
        myTickets.addTicket(new Ticket("2, 13, 22, 32, 38, 45"));
        myTickets.addTicket(new Ticket("23, 25, 33, 36, 39, 41"));
        myTickets.addTicket(new Ticket("1, 3, 5, 14, 22, 45"));
        myTickets.addTicket(new Ticket("5, 9, 38, 41, 43, 44"));
        myTickets.addTicket(new Ticket("2, 8, 9, 18, 19, 21"));
        myTickets.addTicket(new Ticket("13, 14, 18, 21, 23, 35"));
        myTickets.addTicket(new Ticket("17, 21, 29, 37, 42, 45"));
        myTickets.addTicket(new Ticket("3, 8, 27, 30, 35, 44"));
        
        this.lotto = new Lotto(myTickets);
        
        this.myTickets.countTicketResult(this.myResult, this.winningTicket);
        this.myResult.checkResultRate(lotto.getUsedMoney());
        
        assertThat(this.myResult.returnRate).isEqualTo(0.35);
    } 
}
