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
                Arguments.of(6, LottoRank.FIRST),
                Arguments.of(5, LottoRank.SECOND),
                Arguments.of(4, LottoRank.THIRD),
                Arguments.of(3, LottoRank.FOURTH),
                Arguments.of(0, LottoRank.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("generateMatchCountAndLottoRank")
    @DisplayName("당첨개수와 맞는 로또 등수를 반환")
    public void 당첨개수별_로또등수_확인(int matchCount, LottoRank rank) {
        LottoRank lottoRank = LottoRank.from(matchCount);
        Assertions.assertThat(lottoRank).isEqualTo(rank);
    }

    @Test
    @DisplayName("1등, 2등, 3등, 4등의 총 상금은 2_001_555_000원 이다.")
    public void 당첨순위_당첨금_확인() {
        LottoRank firstRank = LottoRank.from(6);
        LottoRank secondRank = LottoRank.from(5);
        LottoRank thirdRank = LottoRank.from(4);
        LottoRank fourthRank = LottoRank.from(3);

        int total = firstRank.getPrizeMoney();
        total += secondRank.getPrizeMoney();
        total += thirdRank.getPrizeMoney();
        total += fourthRank.getPrizeMoney();

        Assertions.assertThat(total).isEqualTo(2_000_000_000 + 1_500_000 + 50_000 + 5_000);
    }

}