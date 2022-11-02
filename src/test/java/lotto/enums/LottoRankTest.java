package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 랭크 테스트")
class LottoRankTest {

    @DisplayName("숫자가 매칭되는 값에 따라 해당 순위를 알 수 있다.")
    @ParameterizedTest(name = "#{index} - {0}개가 매칭되고 보너스가 {1}이면 {2}이며 {3}원이다.")
    @MethodSource("match_rank")
    void number_matching_rank(int matchCount, boolean isBonus, LottoRank lottoRank, int price) {
        assertThat(LottoRank.findLottoRank(matchCount, isBonus)).isEqualTo(lottoRank);
    }

    @DisplayName("숫자가 매칭되는 값에 따라 해당 순위의 상금을 알 수 있다.")
    @ParameterizedTest(name = "#{index} - {0}개가 매칭되고 보너스가 {1}이면 상금은 {3}이다.")
    @MethodSource("match_rank")
    void winning_price(int matchCount, boolean isBonus, LottoRank lottoRank, int reward) {
        LottoRank rank = LottoRank.findLottoRank(matchCount, isBonus);
        assertThat(rank.getReward()).isEqualTo(reward);
    }

    private static Stream<Arguments> match_rank() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST, 2_000_000_000),
                Arguments.of(5, true, LottoRank.SECOND, 30_000_000),
                Arguments.of(5, false, LottoRank.THIRD, 1_500_000),
                Arguments.of(4, false, LottoRank.FOURTH, 50_000),
                Arguments.of(3, false, LottoRank.FIFTH, 5_000),
                Arguments.of(2, false, LottoRank.NONE, 0),
                Arguments.of(1, false, LottoRank.NONE, 0),
                Arguments.of(0, false, LottoRank.NONE, 0)
        );
    }

    @DisplayName("2등 여부 확인")
    @Test
    void lottery_2nd_place_confirmation() {
        LottoRank lottoRank = LottoRank.findLottoRank(5, true);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
        lottoRank = LottoRank.findLottoRank(5, false);
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
        lottoRank = LottoRank.findLottoRank(6, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

}