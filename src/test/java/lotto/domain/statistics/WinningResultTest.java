package lotto.domain.statistics;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @Test
    @DisplayName("당첨 순위별로 당첨된 로또 티켓 개수를 조회한다.")
    void createWinningResult() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        WinningResult winningResult = new WinningResult(winningNumbers);
        winningResult.aggregate(lottoTickets());

        //then
        assertThat(winningResult.findMatchCount(LottoRank.FOURTH)).isEqualTo(2);
        assertThat(winningResult.findMatchCount(LottoRank.LOSE)).isEqualTo(3);
    }

    private static LottoTickets lottoTickets() {
        return LottoTickets.from(
                Arrays.asList(
                        (LottoTicket.from(4, 5, 6, 7, 8, 9)),   //3개 일치-FOURTH
                        (LottoTicket.from(4, 5, 6, 7, 8, 9)),   //3개 일치-FOURTH
                        (LottoTicket.from(5, 6, 7, 8, 9, 10)),  //2개 일치-LOSE
                        (LottoTicket.from(6, 7, 8, 9, 10, 11)), //1개 일치-LOSE
                        (LottoTicket.from(6, 7, 8, 9, 10, 11))  //1개 일치-LOSE
                )
        );
    }
}