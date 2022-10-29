package lotto.ticket;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class WinnerLottoTicketTest {

    @Test
    void 당첨번호에_보너스번호가_포함되면_예외를_발상한다(){
        LottoTicket lottoTicket = new LottoTicket("1,2,3,4,5,6");
        assertThatThrownBy(() -> new WinnerLottoTicket(lottoTicket, 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
