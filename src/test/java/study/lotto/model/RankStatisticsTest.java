package study.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertAll;

class RankStatisticsTest {
    @Test
    void 당첨등수통계_를_생성_할_수있다() {
        assertThatNoException()
                .isThrownBy(RankStatistics::getInstance);
    }

    @ParameterizedTest(name = "{displayName}[{index}] {0} 는 0 이다.")
    @DisplayName("초기화된 당첨 순위 갯수 ")
    @ValueSource(strings = {"FIRST", "THIRD", "FOURTH", "FIFTH", "MISS"})
    void 당첨등수통계는_전부_0_으로_초기화_된다(final Rank rank) {
        final RankStatistics rankStatistics = RankStatistics.getInstance();
        assertThat(rankStatistics.countByRank(rank)).isEqualTo(0);
    }

    @Test
    void 해당_등수에_따른_당첨갯수_를_확인_할_수_있다() {
        final RankStatistics rankStatistics = RankStatistics.valueOf(getDummyRankStatistics());

        assertAll(() -> {
            assertThat(rankStatistics.countByRank(Rank.FIRST)).isEqualTo(1);
            assertThat(rankStatistics.countByRank(Rank.THIRD)).isEqualTo(2);
            assertThat(rankStatistics.countByRank(Rank.FOURTH)).isEqualTo(3);
            assertThat(rankStatistics.countByRank(Rank.FIFTH)).isEqualTo(4);
            assertThat(rankStatistics.countByRank(Rank.MISS)).isEqualTo(5);
        });
    }

    private EnumMap<Rank, Integer> getDummyRankStatistics() {
        final EnumMap<Rank, Integer> r = new EnumMap<>(Rank.class);
        r.put(Rank.FIRST, 1);
        r.put(Rank.THIRD, 2);
        r.put(Rank.FOURTH, 3);
        r.put(Rank.FIFTH, 4);
        r.put(Rank.MISS, 5);
        return r;
    }
}