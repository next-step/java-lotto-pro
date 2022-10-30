package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.WinningTicket;
import lotto.util.Constants;

public class WinningTicketTest {
    @Test
    @DisplayName("당첨번호_검증_개수")
    public void winningTicket_validate_count() {
        assertThatThrownBy(() -> new WinningTicket("1,2,3,4,5")).hasMessage(Constants.ERR_SIX_NUMBERS);
    }
    
    @Test
    @DisplayName("당첨번호_검증_숫자")
    public void winningTicket_validate_number() {
        assertThatThrownBy(() -> new WinningTicket("a,b,c,d,e,f")).hasMessage(Constants.ERR_VALUE_NOT_VALID);
    }
    
    @Test
    @DisplayName("당첨번호_검증_null")
    public void winningTicket_validate_null() {
        assertThatThrownBy(() -> new WinningTicket(null)).hasMessage(Constants.ERR_NULL_VALUE);
        
    }
    
    @Test
    @DisplayName("당첨번호_검증_빈값")
    public void winningTicket_validate_emtpy() {
        assertThatThrownBy(() -> new WinningTicket("")).hasMessage(Constants.ERR_NULL_VALUE);
    } 
    
    @Test
    @DisplayName("당첨번호_검증_중복")
    public void winningTicket_validate_duplicate() {
        assertThatThrownBy(() -> new WinningTicket("1,2,3,4,5,5")).hasMessage(Constants.ERR_DUP_NUMBERS);
    }     
}
