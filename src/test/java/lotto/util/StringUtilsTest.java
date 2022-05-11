package lotto.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "    ", "\t", "\n"})
    public void isBlank_true(String text) {
        assertThat(StringUtils.isBlank(text)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "a", "!"})
    public void isBlank_false(String text) {
        assertThat(StringUtils.isBlank(text)).isFalse();
    }
}