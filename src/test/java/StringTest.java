import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void 숫자를_콤마로_나눈다() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    void 하나의_숫자를_콤마로_나눈다() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void 괄호를_제거한다() {
        final String text = "(1,2)";
        assertThat(text.substring(1, text.length() - 1)).isEqualTo("1,2");
    }

    @DisplayName("특정 인덱스의 문제를 반환한다")
    @ParameterizedTest(name = "{0}번 인덱스 문자 {1}")
    @CsvSource(value = {"0,a","1,b","2,c"})
    void 특정_인덱스의_문자를_반환한다(int index, char expected) {
        assertThat("abc".charAt(index)).isEqualTo(expected);
    }

    @DisplayName("특정 인덱스를 벗어나면 StringIndexOutOfBoundsException 발생한다")
    @ParameterizedTest(name = "{0}번 인덱스에서 에러 발생")
    @ValueSource(ints = {-1, 10})
    void 특정_인덱스를_벗어나면_StringIndexOutOfBoundsException_발생한다(int index) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(index))
                .withMessage("String index out of range: " + index);
    }
}
