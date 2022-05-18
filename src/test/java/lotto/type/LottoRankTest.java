package lotto.type;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoRankTest {

    @ParameterizedTest
    @DisplayName("맞춘 개수에 따라 로또 등수를 출력")
    @MethodSource("providerLottoRankTest")
    void 맞춘_숫자에_따른_로또등수_출력(int matchCount, boolean bonusMatch, LottoRank lottoRank) {
        LottoRank actualLottoRank = LottoRank.rankMatch(matchCount, bonusMatch);
        assertEquals(actualLottoRank, lottoRank);
    }

    private static Stream<Arguments> providerLottoRankTest() {
        return Stream.of(
            Arguments.of(-1, true, LottoRank.NONE),
            Arguments.of(3, true, LottoRank.THREE),
            Arguments.of(4, false, LottoRank.FOUR),
            Arguments.of(5, false, LottoRank.FIVE),
            Arguments.of(4, true, LottoRank.FIVE_BONUS),
            Arguments.of(6, true, LottoRank.SIX)
        );
    }

}
