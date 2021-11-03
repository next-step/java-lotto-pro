package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("랜덤 로또티켓 생성 테스트")
    @Test
    void constructRandomLottoTicket_success() {
        LottoTicket lottoTicket = new LottoTicket();
        assertThat(lottoTicket.getSize()).isEqualTo(6);
    }

    @DisplayName("입력받은 로또티켓 생성 테스트")
    @Test
    void constructLottoTicketFromText_success() {
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        assertThat(lottoTicket.getSize()).isEqualTo(6);
    }

    @DisplayName("로또티켓 메시지 생성 테스트")
    @Test
    void makeMessage_success() {
        LottoTicket lottoTicket = new LottoTicket();
        assertThat(lottoTicket.makePrintableMessage()).contains("[", ", ", "]");
    }
}