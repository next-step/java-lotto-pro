package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("로또티켓 생성 테스트")
    @Test
    void constructLottoTicket_success() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("입력받은 로또티켓 생성 테스트")
    @Test
    void constructLottoTicketFromText_success() {
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또티켓 메시지 생성 테스트")
    @Test
    void makeMessage_success() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.makePrintableMessage()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}