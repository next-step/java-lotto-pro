package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameResultTest {

    @Test
    @DisplayName("상금을 계산한다")
    void getPrize() {
        // given
        ArrayList<LottoTicket> lottoTicketsSource = new ArrayList<>();
        lottoTicketsSource.add(new LottoTicket(Arrays.asList(10, 2, 3, 4, 5, 6)));
        lottoTicketsSource.add(new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));
        lottoTicketsSource.add(new LottoTicket(Arrays.asList(7, 8, 9, 10, 4, 12)));
        lottoTicketsSource.add(new LottoTicket(Arrays.asList(7, 8, 9, 10, 4, 5)));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketsSource);

        // when
        GameResult gameResult = lottoTickets.getGameResult(new LottoTicket(Arrays.asList(7, 8, 9, 10, 4, 5), 24));

        // then
        assertThat(gameResult.getPrize()).isEqualTo(2001555000);
    }

    @Test
    void getSecondPrize() {
        // given
        ArrayList<LottoTicket> lottoTicketsSource = new ArrayList<>();
        lottoTicketsSource.add(new LottoTicket(Arrays.asList(10, 2, 3, 4, 5, 6)));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketsSource);

        // when
        GameResult gameResult = lottoTickets.getGameResult(new LottoTicket(Arrays.asList(10, 2, 3, 4, 5, 11), 6));

        // then
        assertThat(gameResult.getPrize()).isEqualTo(30000000);
    }
}