package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("로또 등수 상태 테스트")
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

    @DisplayName("LottoRankingStatus 보너스 확인")
    @Test
    void getLottoRankingStatusMatch5Bonus1Test() {
        assertThat(LottoRankingStatus.valueOf(5, true)).isEqualTo(LottoRankingStatus.SECOND);
    }
}
