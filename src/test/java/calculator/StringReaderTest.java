package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringReaderTest {
    @DisplayName("숫자 이외의 값 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3값", "1,two,3", "//구분자\n1;2;3"})
    void 숫자_이외의_값_입력(String input) {
        assertThatThrownBy(() -> StringReader.readString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 문자열 또는 NULL은 \"0\"으로 바꿈")
    @Test
    void 빈_문자열_또는_NULL은_0으로_바꿈() {
        assertThat(StringReader.readString(null)).isEqualTo("0");
        assertThat(StringReader.readString("")).isEqualTo("0");
    }
}
