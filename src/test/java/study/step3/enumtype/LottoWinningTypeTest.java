package study.step3.enumtype;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningTypeTest {
    private static final int MATCH_COUNT_1 = 1;
    private static final int MATCH_COUNT_9999 = 9999;

    @Test
    @DisplayName("enum 변환 테스트")
    void valueOf() {
        assertThatCode(() -> LottoWinningType.valueOf(MATCH_COUNT_1))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("enum 변환 테스트 - 범위 초과 예외")
    void valueOf_exceededRange() {
        assertThatThrownBy(() -> LottoWinningType.valueOf(MATCH_COUNT_9999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
