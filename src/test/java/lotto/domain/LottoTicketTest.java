package lotto.domain;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    public void lottoTicketGenerateTest() {
        LottoTicket ticket = new LottoTicket(new ArrayList<>(List.of(LottoNumbers.fromString("1,2,3,4,5,6"))));

        assertThat(ticket).isEqualTo(new LottoTicket(new ArrayList<>(List.of(LottoNumbers.fromString("1,2,3,4,5,6")))));
    }

}