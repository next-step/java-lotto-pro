package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Test
    void 중복_검사() {
        // given, when, then
        assertThatThrownBy(() -> new WinningNumbers(new int[] {1, 1}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 로또 번호가 입력될 수 없습니다. (입력값: " + 1 + ")");
    }
}