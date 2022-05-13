package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    @Test
    @DisplayName("LottoNumbers 객체를 파라미터로 LottoTicket 객체가 생성되어야 한다")
    void create() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // then
        assertThat(lottoTicket).isInstanceOf(LottoTicket.class);
        assertThat(lottoTicket).isEqualTo(new LottoTicket(lottoNumbers));
    }
}
