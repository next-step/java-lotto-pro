package lotto.domain.winning;

import lotto.domain.lotto.LottoRank;
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
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        //when
        WinningResult winningResult = new WinningResult(winningNumbers);
        winningResult.aggregate(lottoTickets());

        //then
        assertThat(winningResult.findMatchCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(winningResult.findMatchCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(winningResult.findMatchCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(winningResult.findMatchCount(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(winningResult.findMatchCount(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(winningResult.findMatchCount(LottoRank.LOSE)).isEqualTo(2);
    }

    private static LottoTickets lottoTickets() {
        return LottoTickets.from(
                Arrays.asList(
                        (LottoTicket.from(1, 2, 3, 4, 5, 6)),   //6개 일치-FIRST
                        (LottoTicket.from(2, 3, 4, 5, 6, 7)),   //5개 일치+보너스 일치-SECOND
                        (LottoTicket.from(2, 3, 4, 5, 6, 8)),   //5개 일치-THIRD
                        (LottoTicket.from(3, 4, 5, 6, 7, 8)),   //4개 일치-FOURTH
                        (LottoTicket.from(4, 5, 6, 7, 8, 9)),   //3개 일치-FIFTH
                        (LottoTicket.from(5, 6, 7, 8, 9, 10)),  //2개 일치-LOSE
                        (LottoTicket.from(6, 7, 8, 9, 10, 11))  //1개 일치-LOSE
                )
        );
    }
}