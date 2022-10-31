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
        @DisplayName("발급로또_번호_1에서_45_사이인지_확인")
        public void ticket_num_validate_one_to_fortyfive() {
            IntStream.rangeClosed(0, 5).forEach(i -> {
                assertThat(ticket.lottoNumbers.get(i)).isBetween(1, 45);
            });
        }

        @Test
        @DisplayName("발급로또_번호가_중복을_허용하지_않는지_확인")
        public void ticket_num_validate_duplicate() {
            Set<Integer> lottoSet = new HashSet<>(ticket.lottoNumbers);
            
            assertThat(lottoSet).hasSameSizeAs(ticket.lottoNumbers);
        }
    }

    @Nested
    @DisplayName("당첨로또_테스트")
    class WinningTicket {
        @Test
        @DisplayName("당첨번호가_6개가_아닌_경우_오류_발생")
        public void winningTicket_validate_count() {
            assertThatThrownBy(() -> new Ticket("1,2,3,4,5")).hasMessage("여섯 개의 숫자를 입력해 주세요.");
        }
        
        @Test
        @DisplayName("당첨번호가_숫자가_아닌_경우_오류_발생")
        public void winningTicket_validate_number() {
            assertThatThrownBy(() -> new Ticket("a,b,c,d,e,f")).hasMessage(Constants.ERR_VALUE_NOT_VALID);
        }
        
        @Test
        @DisplayName("당첨번호가_null인_경우_오류_발생")
        public void winningTicket_validate_null() {
            assertThatThrownBy(() -> new Ticket(null)).hasMessage(Constants.ERR_NULL_VALUE);
            
        }
        
        @Test
        @DisplayName("당첨번호가_빈값인_경우_오류_발생")
        public void winningTicket_validate_emtpy() {
            assertThatThrownBy(() -> new Ticket("")).hasMessage(Constants.ERR_NULL_VALUE);
        } 
        
        @Test
        @DisplayName("당첨번호에_중복숫자가_있는_경우_오류_발생")
        public void winningTicket_validate_duplicate() {
            assertThatThrownBy(() -> new Ticket("1,2,3,4,5,5")).hasMessage("중복된 숫자는 허용되지 않습니다.");
        }  
    }
}
