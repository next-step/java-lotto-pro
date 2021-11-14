package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        lottoTickets = new LottoTickets(new int[][] {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12}
        });
    }

    @Test
    void 주어진_번호가_있으면_캐시에_저장() throws Exception {
        // given
        Number number = Number.of(1);
        Map<LottoTicket, Integer> winningCountCache = new HashMap<>();

        // when
        lottoTickets.checkContainsNumber(number, winningCountCache);

        // then
        List<LottoTicket> getLottoTickets = lottoTickets.getLottoTickets();
        assertThat(winningCountCache.get(getLottoTickets.get(0))).isEqualTo(1);
        assertThat(winningCountCache.get(getLottoTickets.get(1))).isNull();
    }

    @Test
    void 구입한_로또_금액_조회() {
        // when
        int result = lottoTickets.calculatePurchaseMoney();

        // then
        assertThat(result).isEqualTo(2000);
    }

    @Test
    void 보너스_번호_포함_여부_Map_조회() {
        // given
        Number bonusNumber = Number.of(6);
        List<LottoTicket> lottoTickets = this.lottoTickets.getLottoTickets();

        // when
        Map<LottoTicket, Boolean> result = this.lottoTickets.checkContainsBonusNumber(bonusNumber);

        // then
        assertThat(result.get(lottoTickets.get(0))).isTrue();
        assertThat(result.get(lottoTickets.get(1))).isFalse();
    }
}