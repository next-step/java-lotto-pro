package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoTicketBundleTest {

    @Test
    void addLottoTicket_랜덤_LottoTicker_추가() {
        // when then
        LottoTicketBundle lottoTicketBundle = new LottoTicketBundle();
        lottoTicketBundle.addLottoTicket();
    }

    @Test
    void toLottoTicketVoucher_LottoTicketBundle_인스턴스_검증() {
        // when then
        LottoTicketBundle lottoTicketBundle = new LottoTicketBundle();
        assertThat(lottoTicketBundle.toLottoTicketVoucher()).isInstanceOf(LottoTicketVoucher.class);
    }
}
