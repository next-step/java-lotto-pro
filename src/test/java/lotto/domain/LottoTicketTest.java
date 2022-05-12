package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    @Test
    @DisplayName("6개의 숫자 배열을 파라미터로 로또 티켓이 생성되어야 한다")
    void create() {
        // given
        final int[] numbers = {1, 2, 3, 4, 5, 6};

        // when and then
        assertThat(new LottoTicket(numbers)).isInstanceOf(LottoTicket.class);
        assertThat(new LottoTicket(numbers)).isEqualTo(new LottoTicket(numbers));
    }
}
