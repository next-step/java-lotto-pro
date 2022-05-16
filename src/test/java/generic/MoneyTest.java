package generic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"1000;2000;3000", "1000;1000;2000"}, delimiterString = ";")
    @DisplayName("원 더하기 테스트")
    void plus(int number1, int number2, int result) {
        // when & then
        assertThat(Money.valueOf(number1).plus(Money.valueOf(number2)))
                .isEqualTo(Money.valueOf(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"3000;2000;1000", "1000;1000;0"}, delimiterString = ";")
    @DisplayName("원 빼기 테스트")
    void minus(int number1, int number2, int result) {
        // when & then
        assertThat(Money.valueOf(number1).minus(Money.valueOf(number2)))
                .isEqualTo(Money.valueOf(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000;2;2000", "1000;10;10000"}, delimiterString = ";")
    @DisplayName("원 배수 테스트")
    void times(int number, int times, int result) {
        // when & then
        assertThat(Money.valueOf(number).times(times))
                .isEqualTo(Money.valueOf(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"14000;1000;14", "2000;60;33"}, delimiterString = ";")
    @DisplayName("원 나누기 테스트(소수점은 버림)")
    void divide(int number, int times, int result) {
        // when & then
        assertThat(Money.valueOf(number).divide(times))
                .isEqualTo(Money.valueOf(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"14000;1000;14", "2000;60;33"}, delimiterString = ";")
    @DisplayName("원 나누기 원으로 수량 계산")
    void count(int number1, int number2, int result) {
        // when & then
        assertThat(Money.valueOf(number1).count(Money.valueOf(number2)))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("1000원 값만 문자열로 반환")
    void toStringValue() {
        // when & then
        assertThat(Money.valueOf(1000).toStringValue()).isEqualTo("1000");
    }

    @Test
    @DisplayName("0원 인지 확인")
    void isZero() {
        // when & then
        assertThat(Money.ZERO).isEqualTo(Money.valueOf(0));
        assertThat(Money.ZERO.isZero()).isTrue();
    }

    @Test
    @DisplayName("원을 비교하여 작인지 확인")
    void isLessThan() {
        // when & then
        assertThat(Money.ZERO.isLessThan(Money.valueOf("1000"))).isTrue();
    }
}