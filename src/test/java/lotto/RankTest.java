package lotto;

import lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void 로또를_맞춘_숫자를_입력하면_등수를_반환한다() {
        // when
        Rank rank = Rank.of(3);
        // then
        assertThat(rank).isEqualTo(Rank.FOUR);
    }

    @Test
    void 당첨순위에_없는_숫자를_입력하면_NO_RANK를_반환한다() {
        // when and then
        assertThat(Rank.of(2)).isEqualTo(Rank.NO_RANK);
    }
}