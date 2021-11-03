package lotto.domain.statistics;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    @Test
    @DisplayName("당첨 순위의 수익률을 계산한다")
    void profit_rate() {
        //given
        LottoTickets lottoTickets = lottoTickets();
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningResult winningResult = new WinningResult(winningNumbers);
        winningResult.aggregate(lottoTickets);

        //when
        WinningStatistics winningStatistics = new WinningStatistics(winningResult);
        float profit = winningStatistics.profitRate(lottoTickets.getLottoTickets().size());

        //then
        assertThat(profit).isEqualTo(2.0f);
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