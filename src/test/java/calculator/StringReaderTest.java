package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringReaderTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3값", "1,two,3", "//구분자\n1;2;3"})
    void 숫자_이외의_값_입력(String input) {
        assertThatThrownBy(() -> StringReader.readString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열_또는_NULL_0으로_바꿈() {
        assertThat(StringReader.readString(null)).isEqualTo("0");
        assertThat(StringReader.readString("")).isEqualTo("0");
    }
}
