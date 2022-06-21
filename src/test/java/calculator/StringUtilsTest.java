package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3값", "1,two,3", "//구분자\n1;2;3"})
    void readInvalidString(String input) {
        assertThatThrownBy(() -> StringUtils.readString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readEmptyString() {
        assertThat(StringUtils.readString(null)).isEqualTo("0");
        assertThat(StringUtils.readString("")).isEqualTo("0");
    }
}
