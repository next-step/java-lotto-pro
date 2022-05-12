package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    @Test
    @DisplayName("LottoTickets 객체가 생성되어야 한다")
    void create() {
        // given
        final int amountOfTickets = 5;

        // when
        final LottoTickets lottoTickets = new LottoTickets(amountOfTickets);
        System.out.println(lottoTickets);

        // when and then
        assertThat(lottoTickets).isInstanceOf(LottoTickets.class);
    }
}
