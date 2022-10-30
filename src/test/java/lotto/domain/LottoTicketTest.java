package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 리스트로 구성된 로또 티켓세트 생성 작업이 정상적으로 동작한다.")
    public void constructor() {
        Lotto firstLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(firstLotto, secondLotto));
        assertThat(lottoTicket.getLottoCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("구입한 Lotto 리스트와 당첨 로또 번호 비교를 통해 당첨내역 조회 작업이 정상적으로 동작한다.")
    public void check() {
        Lotto firstLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(firstLotto, secondLotto));

        Ranks ranks = lottoTicket.check(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7));

        assertAll(
                () -> assertThat(ranks.getCountsOfRanks()).containsEntry(Rank.FIRST, 1),
                () -> assertThat(ranks.getCountsOfRanks()).containsEntry(Rank.MISS, 1)
        );
    }
}
