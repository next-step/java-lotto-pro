package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("문자열 분할 테스트")
    @Test
    void 문자열_분할_테스트() {
        // given
        String input = "1,2";

        // when
        String[] actual = input.split(",");

        // then
        assertThat(actual).contains("1", "2");
    }

    @DisplayName("문자열 분할 정확성 테스트")
    @Test
    void 문자열_분할_정확성_테스트() {
        // given
        String input = "1";

        // when
        String[] actual = input.split(",");

        // then
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("문자열 추출 테스트")
    @Test
    void 문자열_추출_테스트() {
        // given
        String input = "(1,2)";
        String expected = "1,2";

        // when
        String actual = input.substring(1, input.length() - 1);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("문자열 위치 탐색 테스트")
    @Test
    void 문자열_위치_탐색_테스트() {
        // given
        String input = "abc";
        char expected = 'a';

        // when
        char actual = input.charAt(0);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("문자열 위치 탐색 예외 테스트")
    @Test
    void 문자열_위치_탐색_예외_테스트() {
        // given
        String input = "abc";

        // then
        assertThatThrownBy(() -> {
            // when
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(3);
                })
                .withMessageMatching("String index out of range: \\d+");
    }
}
