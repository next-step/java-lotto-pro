package lotto;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("로또번호 생성 테스트")
    @Test
    void LottoTicket_success() {
        LottoTicket lottoTicket = new LottoTicket();
        assertThat(lottoTicket.getSize()).isEqualTo(6);
    }
}