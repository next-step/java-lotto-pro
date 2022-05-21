package lotto.domain;

import lotto.util.RandomNumberUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    void 로또_번호_6개_발급() {
        LottoTicket numbers = new LottoTicket(RandomNumberUtils.generateRandomNumber());
        assertThat(numbers.getNumbersAsArray()).hasSize(6);
    }
}
