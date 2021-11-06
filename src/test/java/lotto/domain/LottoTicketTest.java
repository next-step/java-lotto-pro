package lotto.domain;

import lotto.exception.IllegalLottoNumberException;
import lotto.exception.IllegalLottoNumberSizeException;
import lotto.exception.NumberDuplicationException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTicketTest {

    @Test
    void toStringTest() {
        // given, when
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lottoTicket.toResultString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void numberSizeTest() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalLottoNumberSizeException.class);
    }

    @Test
    void numberDuplicationTest() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(NumberDuplicationException.class);
    }

    @Test
    void illegalLottoNumberTest() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalLottoNumberException.class);
    }
}