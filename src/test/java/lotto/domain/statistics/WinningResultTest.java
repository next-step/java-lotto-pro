package lotto.domain.statistics;

import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @ParameterizedTest(name = "당첨 번호와 일치하는 개수: [{index}] {1}")
    @MethodSource("lottoTickets")
    @DisplayName("당첨 번호와 일치하는 로또 번호 개수를 반환한다.")
    void matchWinningNumbers(LottoTicket lottoTicket, int excepted) {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        WinningResult winningResult = new WinningResult(winningNumbers);
        int matchCount = winningResult.matchCount(lottoTicket);

        //then
        assertThat(matchCount).isEqualTo(excepted);
    }

    private static Stream<Arguments> lottoTickets() {
        return Stream.of(
                Arguments.of(LottoTicket.from(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(LottoTicket.from(2, 3, 4, 5, 6, 7), 5),
                Arguments.of(LottoTicket.from(3, 4, 5, 6, 7, 8), 4),
                Arguments.of(LottoTicket.from(4, 5, 6, 7, 8, 9), 3),
                Arguments.of(LottoTicket.from(5, 6, 7, 8, 9, 10), 2),
                Arguments.of(LottoTicket.from(6, 7, 8, 9, 10, 11), 1),
                Arguments.of(LottoTicket.from(7, 8, 9, 10, 11, 12), 0)
        );
    }
}