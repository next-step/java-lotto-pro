package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.Arrays;
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
        @DisplayName("발급로또 번호 1에서 45 사이인지 확인")
        public void ticket_num_validate_one_to_fortyfive() {
            IntStream.rangeClosed(0, 5).forEach(i -> {
                assertThat(ticket.lottoNumbers.numbers[i]).isBetween(1, 45);
            });
        }

        @Test
        @DisplayName("발급로또 번호가 중복을 허용하지 않는지 확인")
        public void ticket_num_validate_duplicate() {
            Set<Integer> lottoSet = new HashSet<>(Arrays.asList(ticket.lottoNumbers.numbers));
            
            assertThat(lottoSet).hasSameSizeAs(ticket.lottoNumbers.numbers);
        }
    }

    @Nested
    @DisplayName("당첨로또_테스트")
    class WinningTicket {
        @Test
        @DisplayName("당첨번호가 6개가 아닌 경우 오류 발생")
        public void winningTicket_validate_count() {
            assertThatThrownBy(() -> new Ticket("1,2,3,4,5")).hasMessage("여섯 개의 숫자를 입력해 주세요.");
        }
        
        @Test
        @DisplayName("당첨번호가 숫자가 아닌 경우 오류 발생")
        public void winningTicket_validate_number() {
            assertThatThrownBy(() -> new Ticket("a,b,c,d,e,f")).hasMessage("올바른 숫자를 입력해 주세요.");
        }
        
        @Test
        @DisplayName("당첨번호가 null인 경우 오류 발생")
        public void winningTicket_validate_null() {
            assertThatThrownBy(() -> new Ticket(null)).hasMessage("값을 입력해 주세요");
            
        }
        
        @Test
        @DisplayName("당첨번호가 빈값인 경우 오류 발생")
        public void winningTicket_validate_emtpy() {
            assertThatThrownBy(() -> new Ticket("")).hasMessage("값을 입력해 주세요");
        } 
        
        @Test
        @DisplayName("당첨번호에 중복숫자가 있는 경우 오류 발생")
        public void winningTicket_validate_duplicate() {
            assertThatThrownBy(() -> new Ticket("1,2,3,4,5,5")).hasMessage("중복된 숫자는 허용되지 않습니다.");
        }  
    }
    
    @Nested
    @DisplayName("보너스번호 테스트")
    class BonusNum {
        @Test
        @DisplayName("보너스번호가 숫자가 아닌 경우 오류 발생")
        public void bonusNum_validate_number() {
            assertThatThrownBy(() -> new Ticket("1,2,3,4,5,6", "a")).hasMessage("올바른 숫자를 입력해 주세요.");
        }
        
        @Test
        @DisplayName("보너스번호가 null인 경우 오류 발생")
        public void bonusNum_validate_null() {
            assertThatThrownBy(() -> new Ticket("1,2,3,4,5,6", null)).hasMessage("값을 입력해 주세요");
            
        }
        
        @Test
        @DisplayName("보너스번호가 빈값인 경우 오류 발생")
        public void bonusNum_validate_emtpy() {
            assertThatThrownBy(() -> new Ticket("1,2,3,4,5,6", "")).hasMessage("값을 입력해 주세요");
        } 
        
        @Test
        @DisplayName("보너스번호가 당첨번호와 중복인 경우 오류 발생")
        public void bonusNum_validate_duplicate() {
            assertThatThrownBy(() -> new Ticket("1,2,3,4,5,6", "5")).hasMessage("중복된 숫자는 허용되지 않습니다.");
        }  
    }
}
