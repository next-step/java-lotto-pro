package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTicketTest {

    @Test
    void toStringTest() {
        // given
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lottoTicket.toResultString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}