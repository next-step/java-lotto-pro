package generic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        assertThat(Money.wons(number1).plus(Money.wons(number2)))
                .isEqualTo(Money.wons(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"3000;2000;1000", "1000;1000;0"}, delimiterString = ";")
    @DisplayName("원 빼기 테스트")
    void minus(int number1, int number2, int result) {
        // when & then
        assertThat(Money.wons(number1).minus(Money.wons(number2)))
                .isEqualTo(Money.wons(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000;2;2000", "1000;10;10000"}, delimiterString = ";")
    @DisplayName("원 배수 테스트")
    void times(int number, int times, int result) {
        // when & then
        assertThat(Money.wons(number).times(times))
                .isEqualTo(Money.wons(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"14000;1000;14", "2000;60;33"}, delimiterString = ";")
    @DisplayName("원 나누기 테스트(소수점은 버림)")
    void divide(int number, int times, int result) {
        // when & then
        assertThat(Money.wons(number).divide(times))
                .isEqualTo(Money.wons(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"14000;1000;14", "2000;60;33"}, delimiterString = ";")
    @DisplayName("원 나누기 원으로 수량 계산")
    void count(int number1, int number2, int result) {
        // when & then
        assertThat(Money.wons(number1).count(Money.wons(number2)))
                .isEqualTo(result);
    }
}