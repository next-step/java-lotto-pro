package lottoauto.service;

import lottoauto.wrapper.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTicketTest {
    @Test
    void 로또_추가_기능_테스트() {
        LottoTicket lottoTicket = new LottoTicket();

        lottoTicket.add(new Lotto());
        lottoTicket.add(new Lotto());
        lottoTicket.add(new Lotto());
        lottoTicket.add(new Lotto());
        lottoTicket.add(new Lotto());

        assertThat(lottoTicket.size()).isEqualTo(5);
    }
}
