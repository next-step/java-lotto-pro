package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {

    @ParameterizedTest
    @DisplayName("문자열 위치를 벗어 날 경우 EX 발생")
    @ValueSource(strings = "abc")
    void charAt_ex(String data) {
        assertThatNoException().isThrownBy(() -> data.charAt(0));
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> data.charAt(3))
                .withMessageContaining("String index out of range");
    }

    @ParameterizedTest
    @ValueSource(strings = "(1,2)")
    void substring(String data) {
        data = data.substring(1, data.length() - 1);
        assertThat(data).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = "1,2:1:,", delimiter = ':')
    void split(String data1, String data2, String seperator) {
        assertThat(data1.split(seperator)).contains("1", "2");
        assertThat(data1.split(seperator)).containsExactly("1", "2");
        assertThat(data2.split(seperator)).containsOnly("1");
    }
}
