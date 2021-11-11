package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Test
    void 중복_검사() {
        // given, when, then
        assertThatThrownBy(() -> new WinningNumbers(new int[] {1, 1}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 로또 번호가 입력될 수 없습니다. (입력값: " + 1 + ")");
    }

    @Test
    void 로또_맞춘_갯수_Map_반환() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(new int[] {1, 2, 3, 4, 11, 12});
        LottoTickets lottoTickets = new LottoTickets(new int[][] {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12}
        });
        List<LottoTicket> getLottoTickets = lottoTickets.getLottoTickets();

        // when
        Map<LottoTicket, Integer> result = winningNumbers.checkWinningCount(lottoTickets);

        // then
        assertThat(result.get(getLottoTickets.get(0))).isEqualTo(4);
        assertThat(result.get(getLottoTickets.get(1))).isEqualTo(2);
    }
}