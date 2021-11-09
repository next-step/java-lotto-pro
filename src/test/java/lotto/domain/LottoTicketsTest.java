package lotto.domain;

import lotto.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTicketsTest {

    @Test
    void generateRandomLottoTickets() {
        // given
        int amount = 3;

        // when
        LottoTickets lottoTickets = LottoTickets.generateRandomLottoTickets(amount);

        // then
        assertThat(lottoTickets.count()).isEqualTo(3);
    }

    @Test
    void toStringTest() {
        // given
        ResultView resultView = new ResultView();
        ArrayList<LottoTicket> lottoTicketsSource = new ArrayList<>();
        lottoTicketsSource.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTicketsSource.add(new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketsSource);

        // then
        assertThat(resultView.getLottoResultString(lottoTickets.toDTO())).isEqualTo(
                "[1, 2, 3, 4, 5, 6]"
                        + "\n"
                        + "[7, 8, 9, 10, 11, 12]"
        );
    }

    @Test
    @DisplayName("게임 결과를 출력한다")
    void getGameResultTest() {
        // given
        ArrayList<LottoTicket> lottoTicketsSource = new ArrayList<>();
        lottoTicketsSource.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTicketsSource.add(new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketsSource);

        // when
        GameResult gameResult = lottoTickets.getGameResult(new LottoTicket(Arrays.asList(7, 8, 9, 10, 4, 5)));

        // then
        assertThat(gameResult.toString()).isEqualTo("3개 일치 (5000원)- 0개\n" +
                "4개 일치 (50000원)- 1개\n" +
                "5개 일치 (1500000원)- 0개\n" +
                "6개 일치 (2000000000원)- 0개");
    }
}