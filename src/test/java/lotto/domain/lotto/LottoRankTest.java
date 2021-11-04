package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @ParameterizedTest(name = "당첨 개수에 따른 당첨 순위: [{index}] {0}")
    @MethodSource("lottoRank")
    @DisplayName("로또 당첨 개수 따라 로또 당첨 순위를 조회한다.")
    void findBy(int winningCount, boolean isMatchBonus, LottoRank excepted) {
        //given //when
        LottoRank lottoRank = LottoRank.findBy(winningCount, isMatchBonus);

        //then
        assertThat(lottoRank).isEqualTo(excepted);
    }

    private static Stream<Arguments> lottoRank() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(2, false, LottoRank.LOSE),
                Arguments.of(1, false, LottoRank.LOSE),
                Arguments.of(0, false, LottoRank.LOSE)
        );
    }
}