package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilsTest {

    @DisplayName("소수점 버림 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> decimal: {0}, places: {1}, expected: {2}")
    @CsvSource(value = {"1.2345:1:1.0", "1.2345:2:1.2", "1.2345:3:1.23"}, delimiter = ':')
    void roundDown(double decimal, int places, double expected) {
        // when
        double result = NumberUtils.roundDown(decimal, places);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
