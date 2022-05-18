package lotto;

import lotto.domain.Match;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void 변환() {
        assertThat(Rank.valueOf(Rank.FIRST.getMatch(), false))
                .isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(Rank.SECOND.getMatch(), true))
                .isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(Rank.THIRD.getMatch(), false))
                .isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(Rank.FOURTH.getMatch(), false))
                .isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(Rank.FOURTH.getMatch(), true))
                .isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(Rank.FIFTH.getMatch(), false))
                .isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(Rank.FIFTH.getMatch(), true))
                .isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(new Match(2), false))
                .isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(new Match(2), true))
                .isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(new Match(1), false))
                .isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(new Match(1), true))
                .isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(Rank.MISS.getMatch(), false))
                .isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(Rank.MISS.getMatch(), true))
                .isEqualTo(Rank.MISS);
    }
}
