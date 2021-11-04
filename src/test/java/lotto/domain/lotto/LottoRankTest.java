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
    void findBy(int matchCount, LottoRank excepted) {
        //given //when
        LottoRank lottoRank = LottoRank.findBy(matchCount);

        //then
        assertThat(lottoRank).isEqualTo(excepted);
    }

    private static Stream<Arguments> lottoRank() {
        return Stream.of(
                Arguments.of(6, LottoRank.FIRST),
                Arguments.of(5, LottoRank.SECOND),
                Arguments.of(4, LottoRank.THIRD),
                Arguments.of(3, LottoRank.FOURTH),
                Arguments.of(2, LottoRank.LOSE),
                Arguments.of(1, LottoRank.LOSE),
                Arguments.of(0, LottoRank.LOSE)
        );
    }

}