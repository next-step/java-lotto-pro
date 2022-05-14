import lotto.LottoTicket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    void 생성() {
        LottoTicket lottoTicket = new LottoTicket(14000);
        assertThat(lottoTicket.size()).isEqualTo(14);
    }

    @Test
    void 생성_예외() {
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = new LottoTicket(900);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
