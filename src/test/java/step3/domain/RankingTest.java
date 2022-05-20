package step3.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class RankingTest {

    @ParameterizedTest(name = "맞춘 숫자 개수에 따른 당첨 순위를 구한다.")
    @MethodSource("intBooleanAneRankingProvider")
    void 당첨순위_찾기(int hitCount, boolean isHitBonusNumber, Ranking ranking) {
        assertThat(Ranking.findRanking(hitCount, isHitBonusNumber)).isEqualTo(ranking);
    }

    static Stream<Arguments> intBooleanAneRankingProvider() {
        return Stream.of(
                arguments(6, false, Ranking.FIRST),
                arguments(5, true, Ranking.SECOND),
                arguments(5, false, Ranking.THIRD),
                arguments(4, false, Ranking.FOURTH),
                arguments(3, false, Ranking.FIFTH),
                arguments(2, false, Ranking.NONE)
        );
    }
}