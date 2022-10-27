package lotto.ticket;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class WinnerLottoTicketTest {

    @Test
    void invalid(){
        LottoTicket lottoTicket = new LottoTicket("1,2,3,4,5,6");
        assertThatThrownBy(() -> {
            new WinnerLottoTicket(lottoTicket, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
