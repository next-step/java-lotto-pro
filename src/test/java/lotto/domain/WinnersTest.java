package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    private static List<Prize> prizes;

    @BeforeAll
    static void beforeAll() {
        prizes = Arrays.asList(Prize.FIRST_PLACE, Prize.FIRST_PLACE, Prize.SECOND_PLACE);
    }

    @Test
    @DisplayName("각 당첨 개수 확인")
    void get_rank_test() {
        Winners winners = new Winners(prizes);
        Map<Prize, Long> rankCount = winners.getRankCount();
        assertThat(rankCount.get(Prize.FIRST_PLACE)).isEqualTo(2L);
        assertThat(rankCount.get(Prize.SECOND_PLACE)).isEqualTo(1L);

    }
    @Test
    @DisplayName("전체 당첨 금액 확인")
    void get_total_prize_test() {
        Winners winners = new Winners(prizes);
        Map<Prize, Long> rankCount = winners.getRankCount();

        assertThat(winners.totalPrize(rankCount)).isEqualTo(4001500000L);
    }
}