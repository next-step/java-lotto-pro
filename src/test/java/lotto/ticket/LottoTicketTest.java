package lotto.ticket;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    private final int SLOT_SIZE = 6;
    Random random = null;

    @BeforeEach
    void Setup(){
        random = new Random();
    }

    @Test
    void 중복없는_로또번호_6자리_생성(){
        LottoTicket lottoTicket = new LottoTicket();
        int size = lottoTicket.getNumbers().size();
        assertThat(size).isEqualTo(SLOT_SIZE);
    }

}
