package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoRankingStatusTest {

    @ParameterizedTest(name = "LottoRankingStatus 범위 확인")
    @EnumSource(
            value = LottoRankingStatus.class,
            names = {"NONE"},
            mode = EnumSource.Mode.EXCLUDE)
    void getLottoRankingMatchRangeTest(LottoRankingStatus lottoRankingStatus) {
        int matchNumber = lottoRankingStatus.getMatchAmount();
        assertTrue(matchNumber >= 3 && matchNumber <= 6);
    }
}
