package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsFactoryTest {
    private final LottoTicketsFactory factory = new LottoTicketsFactory();

    @Test
    @DisplayName("주어진 숫자 만큼의 로또 티켓들이 자동으로 생성되어야 한다.")
    void create_automatically() {
        // given
        final int count = 10;

        // when
        final LottoTickets lottoTickets = factory.createAutomatically(count);

        // then
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets).isInstanceOf(LottoTickets.class);
    }
}
