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
    @DisplayName("문자값이 들어오면 IllegalArgumentException이 발생")
    void inputCharacterValue() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Count.of("abc"))
                .withMessage("횟수는 Integer 값만 올 수 있습니다.");
    }

    @Test
    @DisplayName("카운트 두 객체 비교 검증")
    void verifyCompareCount() {
        Count one = Count.of(1);
        Count two = Count.of(2);

        assertThat(one).isLessThan(two);
    }

    @Test
    @DisplayName("두 카운트를 뺀 결과를 검증")
    void verifySubtractCount() {
        Count two = Count.of(2);
        Count one = Count.of(1);

        assertEquals(1, two.subtract(one));
    }

    @Test
    @DisplayName("현재 카운트보다 큰 카운트를 빼면 IllegalStateException이 발생")
    void subtractBiggerCount() {
        Count one = Count.of(1);
        Count two = Count.of(2);

        assertThatIllegalStateException()
                .isThrownBy(() -> one.subtract(two))
                .withMessage("현재 횟수보다 큰 값으로 뺄 수 없습니다.");
    }
}
