package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    @Test
    @DisplayName("티켓 개수를 파라미터로 LottoTickets 객체가 생성되어야 한다")
    void create() {
        // given
        final int amountOfTickets = 5;

        // when
        final LottoTickets lottoTickets = new LottoTickets(amountOfTickets);

        // when and then
        assertThat(lottoTickets).isInstanceOf(LottoTickets.class);
    }
}
