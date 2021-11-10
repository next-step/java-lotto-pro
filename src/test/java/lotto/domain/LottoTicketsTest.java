package lotto.domain;

import lotto.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTicketsTest {

    @Test
    @DisplayName("자동 로또를 개수대로 생성한다")
    void generateRandomLottoTickets() {
        // given
        int amount = 3;

        // when
        LottoTickets lottoTickets = LottoTickets.generateRandomLottoTickets(amount);

        // then
        assertThat(lottoTickets.count()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또를 문자열로 변환한다")
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
}