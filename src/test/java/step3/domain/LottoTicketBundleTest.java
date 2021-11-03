package step3.domain;

import org.junit.jupiter.api.Test;

public class LottoTicketBundleTest {

    @Test
    void 로또번들_랜덤_LottoTicker_추가() {
        // when then
        LottoTicketBundle lottoTicketBundle = new LottoTicketBundle();
        lottoTicketBundle.addLottoTicket();
    }
}
