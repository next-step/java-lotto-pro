package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("lottoRankFilterProvideCount")
    @DisplayName("맞춘 갯수에 따른 LottoRank를 반환한다.")
    void lottoRankFilter(int matchCount, LottoRank result) {
        LottoRank reword = LottoRank.reword(matchCount);

        assertThat(reword).isEqualTo(result);
    }

    private static Stream<Arguments> lottoRankFilterProvideCount() {
        return Stream.of(
                Arguments.of(1, LottoRank.FAIL)
                , Arguments.of(0, LottoRank.FAIL)
                , Arguments.of(3, LottoRank.FOURTH)
                , Arguments.of(4, LottoRank.THIRD)
                , Arguments.of(5, LottoRank.SECOND)
                , Arguments.of(6, LottoRank.FIRST)
        );
    }

}