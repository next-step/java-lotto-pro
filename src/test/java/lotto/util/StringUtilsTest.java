package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "    ", "\t", "\n"})
    public void isBlank_true(String text) {
        Assertions.assertThat(StringUtils.isBlank(text)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "a", "!"})
    public void isBlank_false(String text) {
        Assertions.assertThat(StringUtils.isBlank(text)).isFalse();
    }
}