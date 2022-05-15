package lotto.domain;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchCountTest {
    @DisplayName("매칭 개수가 벗어난 경우 예외 처리")
    @Test
    void test_범위_벗어난_매칭() {
        //given & when & then
        assertThatThrownBy(() -> MatchCount.from(7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE_MATCH);
    }
}