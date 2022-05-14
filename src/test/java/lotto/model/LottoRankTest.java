package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @ParameterizedTest(name = "맞춘 개수({0})에 따른 로또 등수 확인")
    @MethodSource("parameterVerifyLottoRank")
    void verifyLottoRank(int hits, LottoRank rank) {
        assertEquals(LottoRank.findByHits(hits), rank);
    }

    public static Stream<Arguments> parameterVerifyLottoRank() {
        return Stream.of(
                Arguments.of(6, LottoRank.FIRST),
                Arguments.of(5, LottoRank.SECOND),
                Arguments.of(4, LottoRank.THIRD),
                Arguments.of(3, LottoRank.FOURTH),
                Arguments.of(2, LottoRank.MISS),
                Arguments.of(1, LottoRank.MISS),
                Arguments.of(0, LottoRank.MISS)
        );
    }
}
