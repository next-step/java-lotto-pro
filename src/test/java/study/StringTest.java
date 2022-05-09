package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트를 작성")
class StringTest {


    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2을 포함하는 배열을 반환")
    @Test
    void splitMultiple() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열을 반환")
    @Test
    void splitSingle() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");

    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 substring()를 활용해 ()을 제거하고 \"1,2\"를 반환")
    @Test
    void substring() {
        final String input = "(1,2)";
        final String actual = input.substring(1, input.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 charAt()를 활용해 특정 위치의 문자를 반환")
    @ParameterizedTest
    @CsvSource({
            "0, a",
            "1, b",
            "2, c"
    })
    void successfulCharAt(int index, char expected) {
        final char actual = "abc".charAt(index);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("charAt()를 활용할 때 위치 값이 벗어나면 `StringIndexOutOfBoundsException`이 발생")
    @Test
    void failureCharAt() {
        final String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(input.length());
        })
        .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range:");
    }
}
