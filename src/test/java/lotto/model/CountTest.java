package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CountTest {

    @Test
    @DisplayName("카운트 객체가 동일한지 검증")
    void verifyEqualsCount() {
        Count twoCount = Count.of(2);

        assertEquals(Count.of(2), twoCount);
    }

    @ParameterizedTest(name = "0이하의 값이 들어오면 IllegalArgumentException이 발생")
    @ValueSource(ints = {0, -2})
    void inputInvalidCount(int invalidCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Count.of(invalidCount))
                .withMessage("횟수는 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("카운트를 1회 감소")
    void decreaseCount() {
        Count count = Count.of(2);
        count.decrease();

        assertEquals(Count.of(1), count);
    }

    @Test
    @DisplayName("0인 횟수에서 카운트 감소시 IllegalStateException이 발생")
    void invalidDecreaseCount() {
        Count count = Count.of(1);
        count.decrease();

        assertThatIllegalStateException()
                .isThrownBy(count::decrease)
                .withMessage("현재 횟수가 0이라 감소할 수 없습니다.");
    }

    @Test
    @DisplayName("카운트가 0인지 확인")
    void isZeroCount() {
        Count count = Count.of(1);
        count.decrease();

        assertThat(count.isZero()).isTrue();
    }
}
