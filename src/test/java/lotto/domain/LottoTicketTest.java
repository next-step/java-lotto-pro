package lotto.domain;

import lotto.module.AutoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @ParameterizedTest
    @ValueSource(ints = {
            1, 5
    })
    @DisplayName("로또 번호 자동생성")
    public void autoGenerateTest(int boughtLotto) {
        LottoTicket ticket = LottoTicket.generate(boughtLotto, new AutoGenerator());

        assertThat(ticket.getTicket().size()).isEqualTo(boughtLotto);
    }

}