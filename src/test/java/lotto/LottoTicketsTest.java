package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @DisplayName("로또 티켓 묶음 생성 테스트")
    @Test
    void LottoTickets_success() {
        assertThat(new LottoTickets(1).getSize()).isEqualTo(1);
    }
}