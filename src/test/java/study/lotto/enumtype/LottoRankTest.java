package study.lotto.enumtype;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    private static final int MATCH_COUNT_1 = 1;
    private static final int MATCH_COUNT_7 = 7;

    @Test
    @DisplayName("enum 변환 테스트")
    void valueOf() {
        assertThatCode(() -> LottoRank.valueOf(MATCH_COUNT_1))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("enum 변환 테스트 - 범위 초과 예외")
    void valueOf_exceededRange() {
        assertThat(LottoRank.valueOf(MATCH_COUNT_7)).isEqualTo(LottoRank.MISS);
    }
}
