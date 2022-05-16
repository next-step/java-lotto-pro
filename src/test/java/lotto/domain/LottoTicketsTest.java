package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @Test
    @DisplayName("여러개의 LottoTicket을 생성한다")
    void create_success() {
        LottoTickets lottoTickets = new LottoTickets(2);
        assertThat(lottoTickets.size()).isEqualTo(2);
    }
}
