package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.domain.Lotto;
import lotto.domain.Ticket;

public class LottoTest {    
    Lotto lotto;
    List<Ticket> myTickets;
    Ticket winningTicket = new Ticket("1,2,3,4,5,6");
    
    @Test
    @DisplayName("구입금액에_따른_발급로또_개수_확인")
    public void lotto_issue_count() {
        lotto = new Lotto("14000");
        assertThat(lotto.ticketList).hasSize(14);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,2,3,4,5,6':'6개 일치 (2000000000원) - 1개'"
                        , "'1,2,3,4,5,7':'5개 일치 (1500000원) - 1개'"
                        , "'1,2,3,4,7,8':'4개 일치 (50000원) - 1개'"
                        , "'1,2,3,7,8,9':'3개 일치 (5000원) - 1개'"
                        }, delimiter = ':')
    @DisplayName("사용자_입력값과_로또_비교하여_결과_출력")
    public void lotto_get_result(String param, String expected) {
        myTickets.add(new Ticket(param));
        
        lotto = new Lotto(myTickets, winningTicket);
        assertThat(lotto.result).contains(expected);
    }  
    
    @Test
    @DisplayName("사용자_입력값과_로또_비교하여_수익률_출력")
    public void lotto_get_return_rate() {
        myTickets.add(new Ticket("1,2,3,7,8,9"));
        myTickets.add(new Ticket("7,8,9,10,11,12"));
        
        lotto = new Lotto(myTickets, winningTicket);
        assertThat(lotto.result).contains("총 수익률은 2.5입니다.");
    } 
}
