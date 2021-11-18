package lotto.domain;

import lotto.exception.IllegalLottoNumberException;
import lotto.exception.IllegalLottoNumberSizeException;
import lotto.exception.NumberDuplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTicketTest {

    @Test
    @DisplayName("티켓을 문자열로 변환한다")
    void toStringTest() {
        // given, when
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lottoTicket.toDTO().toResultString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("티켓의 개수를 구한다")
    void numberSizeTest() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalLottoNumberSizeException.class);
    }

    @Test
    @DisplayName("중복된 숫자가 있으면 예외를 반환한다")
    void numberDuplicationTest() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(NumberDuplicationException.class);
    }

    @Test
    @DisplayName("1-45범위의 숫자가 아니면 예외를 반환한다")
    void illegalLottoNumberTest() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalLottoNumberException.class);
    }

    @Test
    @DisplayName("동일한 숫자의 개수를 반환한다")
    void getSameNumberCountTest() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 8);

        assertThat(lottoTicket.getPrize(winningLottoNumbers)).isEqualTo(Prize.THIRD);
    }

    @Test
    @DisplayName("숫자를 오름차순으로 정렬한다")
    void sortTest() {
        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(7, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(2, 3, 4, 5, 6, 7));

        assertThat(lottoTicket1.toDTO().toString()).isEqualTo(lottoTicket2.toDTO().toString());
    }
}