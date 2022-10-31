package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.domain.Tickets;

public class LottoTest {    
    Lotto lotto;
    Tickets myTickets = new Tickets();
    String winningTicketStr = "1,2,3,4,5,6";
    
    @Test
    @DisplayName("구입금액에_따른_발급로또_개수_확인")
    public void lotto_issue_count() {
        lotto = new Lotto("14000");
        assertThat(lotto.tickets.size()).isEqualTo(14);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,2,3,4,5,6':'6개 일치 (2000000000원) - 1개'"
                        , "'1,2,3,4,5,7':'5개 일치 (1500000원) - 1개'"
                        , "'1,2,3,4,7,8':'4개 일치 (50000원) - 1개'"
                        , "'1,2,3,7,8,9':'3개 일치 (5000원) - 1개'"
                        }, delimiter = ':')
    @DisplayName("사용자_입력값과_로또_비교하여_결과_출력")
    public void lotto_get_result(String param, String expected) {
        myTickets.addTicket(new Ticket(param));
        
        lotto = new Lotto(myTickets);
        assertThat(lotto.getResultStr(winningTicketStr)).contains(expected);
    }  
    
    @Test
    @DisplayName("사용자_입력값과_로또_비교하여_수익률_출력")
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
        
        lotto = new Lotto(myTickets);
        assertThat(lotto.getResultStr(winningTicketStr)).contains("총 수익률은 0.35입니다.");
    } 
}
