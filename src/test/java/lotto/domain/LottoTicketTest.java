package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    void 로또_번호_6개_발급() {
        LottoTicket numbers = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(numbers.getNumbersAsArray()).hasSize(6);
    }

    @Test
    void 로또_ticket_toString_결과() {
        LottoTicket ticket = new LottoTicket(new TestNumberGenerator());
        assertThat(ticket).hasToString("[1, 2, 3, 4, 5, 6]");
    }
}
