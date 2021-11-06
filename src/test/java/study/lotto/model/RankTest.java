package study.lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void 당첨결과_MISS_는_상금이_0_이다() {
        assertThat(Rank.MISS.getWinningMoney()).isEqualTo(0);
    }

    @Test
    void 당첨결과_5등_은_상금이_5_000_이다() {
        assertThat(Rank.FIFTH.getWinningMoney()).isEqualTo(5_000);
    }

    @Test
    void 당첨결과_4등_은_상금이_50_000_이다() {
        assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(50_000);
    }

    @Test
    void 당첨결과_3등_은_상금이_1_500_000_이다() {
        assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(1_500_000);
    }

    @Test
    void 당첨결과_1등_은_상금이_2_000_000_000_이다() {
        assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2_000_000_000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 0, 7, 8, 9, 10, 11, -1, 231})
    void 일치한_갯수가_3에서_6이아니면_당첨결과_MISS값이_반환된다(final int countOfMatch) {
        final Rank rank = Rank.valueOf(countOfMatch);
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @Test
    void 일치한_갯수가_3이면_당첨결과5등이이_반환된다() {
        final Rank rank = Rank.valueOf(3);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 일치한_갯수가_4이면_당첨결과4등이이_반환된다() {
        final Rank rank = Rank.valueOf(4);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 일치한_갯수가_5이면_당첨결과3등이이_반환된다() {
        final Rank rank = Rank.valueOf(5);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 일치한_갯수가_6이면_당첨결과1등이이_반환된다() {
        final Rank rank = Rank.valueOf(6);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
}