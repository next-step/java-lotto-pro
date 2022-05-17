package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    void 로또_번호_6개_발급() {
        LottoTicket numbers = new LottoTicket();
        assertThat(numbers.getNumbersAsArray()).hasSize(6);
    }
}
