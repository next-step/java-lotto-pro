package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @ParameterizedTest(name = "맞춘 개수({0}) 보너스 여부({1})에 따른 로또 등수({2}) 확인")
    @MethodSource("parameterVerifyLottoRank")
    void verifyLottoRank(int hits, boolean hasBonus, LottoRank rank) {
        assertEquals(LottoRank.findByHits(hits, hasBonus), rank);
    }

    public static Stream<Arguments> parameterVerifyLottoRank() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(2, false, LottoRank.MISS),
                Arguments.of(1, false, LottoRank.MISS),
                Arguments.of(0, false, LottoRank.MISS)
        );
    }
}
