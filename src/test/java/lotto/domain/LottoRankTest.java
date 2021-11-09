package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LottoRankTest {

    static Stream<Arguments> generateMatchCountAndLottoRank() {
        return Stream.of(
                Arguments.of(6, true, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(0, true, LottoRank.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("generateMatchCountAndLottoRank")
    @DisplayName("당첨개수와 맞는 로또 등수를 반환")
    public void 당첨개수별_로또등수_확인(int matchCount, boolean matchBonus, LottoRank rank) {
        LottoRank lottoRank = LottoRank.of(matchCount, matchBonus);
        Assertions.assertThat(lottoRank).isEqualTo(rank);
    }

    @Test
    @DisplayName("1등, 2등, 3등, 4등, 5등의 총 상금은 2_031_555_000원 이다.")
    public void 당첨순위_당첨금_확인() {
        LottoRank firstRank = LottoRank.of(6, true);
        LottoRank secondRank = LottoRank.of(5, true);
        LottoRank thirdRank = LottoRank.of(5, false);
        LottoRank fourthRank = LottoRank.of(4, true);
        LottoRank fifthRank = LottoRank.of(3, true);

        int total = firstRank.getPrizeMoney();
        total += secondRank.getPrizeMoney();
        total += thirdRank.getPrizeMoney();
        total += fourthRank.getPrizeMoney();
        total += fifthRank.getPrizeMoney();

        Assertions.assertThat(total).isEqualTo(2_000_000_000 + 30_000_000 + 1_500_000 + 50_000 + 5_000);
    }

}