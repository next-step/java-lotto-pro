package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("lottoRankFilterProvideCount")
    @DisplayName("맞춘 갯수에 따른 LottoRank를 반환한다.")
    void lottoRankFilter(int matchCount,boolean bonus,LottoRank result) {
        LottoRank reword = LottoRank.reword(matchCount, bonus);

        assertThat(reword).isEqualTo(result);
    }

    @Test
    @DisplayName("당첨된 상태만 반환한다")
    void winnerRanks() {
        List<LottoRank> winnerRanks = LottoRank.winnerRanks();

        assertThat(winnerRanks.contains(LottoRank.FAIL)).isFalse();
        assertThat(winnerRanks)
                .contains(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH);
    }

    @Test
    @DisplayName("상태에 대한 메시지 반환")
    public void message() {
        assertThat(LottoRank.SECOND.message()).isEqualTo("5개 일치, 보너스 볼 일치 (30000000원)");
        assertThat(LottoRank.FIRST.message()).isEqualTo("6개 일치 (2000000000원)");
    }

    private static Stream<Arguments> lottoRankFilterProvideCount() {
        return Stream.of(
                 Arguments.of(0, true, LottoRank.FAIL)
                , Arguments.of(3, false, LottoRank.FIFTH)
                , Arguments.of(3, true, LottoRank.FIFTH)
                , Arguments.of(4, true, LottoRank.FOURTH)
                , Arguments.of(5, false, LottoRank.THIRD)
                , Arguments.of(5, true, LottoRank.SECOND)
                , Arguments.of(6, false, LottoRank.FIRST)
        );
    }

}