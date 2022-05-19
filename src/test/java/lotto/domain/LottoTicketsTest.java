package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketsTest {
    @Test
    @DisplayName("여러개의 LottoTicket을 생성한다")
    void create_success() {
        LottoTickets lottoTickets = new LottoTickets(2);
        assertThat(lottoTickets.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("마지막 LottoTicket과 LottoNumber를 받고 현재의 LottoTickets를 돌면서 LottoPrize를 리턴한다")
    void return_match_results() {
        LottoTickets givenLottoTickets = new LottoTickets(3);
        List<Integer> lastWinningLottoNumbers = new ArrayList<>();
        lastWinningLottoNumbers.add(1);
        lastWinningLottoNumbers.add(2);
        lastWinningLottoNumbers.add(3);
        lastWinningLottoNumbers.add(4);
        lastWinningLottoNumbers.add(5);
        lastWinningLottoNumbers.add(6);

        LottoPrizes lottoPrizes = givenLottoTickets.matchResults(
                new LottoTicket(LottoNumbers.generateLottoNumbers(lastWinningLottoNumbers).getReadOnlyLottoNumbers()),
                new LottoNumber(7)
        );

        assertAll(
                () -> assertThat(lottoPrizes).isNotNull(),
                () -> assertThat(lottoPrizes.getLottoPrizes()).hasSize(3)
        );
    }
}
