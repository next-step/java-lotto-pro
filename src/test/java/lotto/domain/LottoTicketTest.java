package lotto.domain;

import com.sun.tools.javac.util.List;
import lotto.module.AutoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

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

    @Test
    public void lottoTicketGenerateTest() {
        LottoTicket ticket = new LottoTicket(new ArrayList<>(List.of(LottoNumbers.fromString("1,2,3,4,5,6"))));

        assertThat(ticket).isEqualTo(new LottoTicket(new ArrayList<>(List.of(LottoNumbers.fromString("1,2,3,4,5,6")))));
    }

}