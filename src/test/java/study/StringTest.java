package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1").contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt(): StringIndexOutOfBoundsException 예외 발생 확인")
    @Test
    void charAt() {
        String exampleString = "abc";
        int index = 3;

        assertAll(
                () -> assertThatThrownBy(() -> exampleString.charAt(index))
                        .isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("index out of range"),

                () -> assertThatThrownBy(() -> exampleString.charAt(index))
                        .isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("%d", index),

                () ->  assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                        .isThrownBy(() -> exampleString.charAt(index))
                        .withMessageMatching("String index out of range: " + index),

                () -> assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                        .isThrownBy(() -> exampleString.charAt(index))
                        .withMessageMatching("String index out of range: \\d")
        );

    }
}
