package lotto.domain;

import lotto.util.RandomNumberUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    void 로또_번호_6개_발급() {
        LottoTicket numbers = new LottoTicket(RandomNumberUtils.generateRandomNumber());
        assertThat(numbers.getNumbersAsArray()).hasSize(6);
    }

    @Test
    void 로또_ticket_toString_결과() {
        LottoTicket ticket = new LottoTicket(new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        assertThat(ticket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
