package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import lotto.domain.Ticket;
import lotto.util.Constants;

public class TicketTest {
    Ticket ticket;
    
    @Nested
    @DisplayName("발급로또_테스트")
    class IssuedTicket {
        @BeforeEach
        public void generateTicket() {
            ticket = new Ticket();
        }

        @Test
        @DisplayName("발급로또_번호_검증_범위")
        public void ticket_num_validate_one_to_fortyfive() {
            IntStream.rangeClosed(Constants.TICKET_MIN_IDX, Constants.TICKET_MAX_IDX).forEach(i -> {
                assertThat(ticket.lottoNumbers.get(i)).isBetween(Constants.TICKET_MIN_LOTTO_NUM, Constants.TICKET_MAX_LOTTO_NUM);
            });
        }

        @Test
        @DisplayName("발급로또_번호_검증_중복")
        public void ticket_num_validate_duplicate() {
            Set<Integer> lottoSet = new HashSet<>(ticket.lottoNumbers);
            
            assertThat(lottoSet).hasSameSizeAs(ticket.lottoNumbers);
        }
    }

    @Nested
    @DisplayName("당첨로또_테스트")
    class WinningTicket {
        @Test
        @DisplayName("당첨번호_검증_개수")
        public void winningTicket_validate_count() {
            assertThatThrownBy(() -> new Ticket("1,2,3,4,5")).hasMessage(Constants.ERR_SIX_NUMBERS);
        }
        
        @Test
        @DisplayName("당첨번호_검증_숫자")
        public void winningTicket_validate_number() {
            assertThatThrownBy(() -> new Ticket("a,b,c,d,e,f")).hasMessage(Constants.ERR_VALUE_NOT_VALID);
        }
        
        @Test
        @DisplayName("당첨번호_검증_null")
        public void winningTicket_validate_null() {
            assertThatThrownBy(() -> new Ticket(null)).hasMessage(Constants.ERR_NULL_VALUE);
            
        }
        
        @Test
        @DisplayName("당첨번호_검증_빈값")
        public void winningTicket_validate_emtpy() {
            assertThatThrownBy(() -> new Ticket("")).hasMessage(Constants.ERR_NULL_VALUE);
        } 
        
        @Test
        @DisplayName("당첨번호_검증_중복")
        public void winningTicket_validate_duplicate() {
            assertThatThrownBy(() -> new Ticket("1,2,3,4,5,5")).hasMessage(Constants.ERR_DUP_NUMBERS);
        }  
    }
}
