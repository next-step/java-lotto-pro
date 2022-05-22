package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryTest {
    @Test
    void 로또_수익_금액_합계() {
        Map<Rank, Integer> ranks = new LinkedHashMap<>();
        for (Rank rank : Rank.reverseValues()) {
            ranks.put(rank, 1);
        }
        Summary summary = new Summary(ranks);
        assertThat(summary.totalPrizeMoney()).isEqualTo(2031555000);
    }

    @Test
    void 로또_수익_금액_없음() {
        Map<Rank, Integer> ranks = new LinkedHashMap<>();
        for (Rank rank : Rank.reverseValues()) {
            ranks.put(rank, 0);
        }
        Summary summary = new Summary(ranks);
        assertThat(summary.totalPrizeMoney()).isEqualTo(0);
    }
}
