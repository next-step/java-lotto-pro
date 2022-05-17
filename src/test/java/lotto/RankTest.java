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
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 당첨순위에_없는_숫자를_입력하면_NO_RANK를_반환한다() {
        // when and then
        assertThat(Rank.of(2)).isEqualTo(Rank.NO_RANK);
    }

    @Test
    void 보너스볼이_일치하고_5개가_일치하면_2등을_반환한다() {
        // given
        Rank third = Rank.THIRD;
        // when and then
        assertThat(third.convertSecondPrize(true)).isEqualTo(Rank.SECOND);
    }
}