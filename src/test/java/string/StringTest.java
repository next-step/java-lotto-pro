package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split을 사용하여 구분자를 기준으로 두 개의 토큰을 만든다.")
    void splitTwoTokens() {
        final String givenString = "1,2";
        final String[] tokens = givenString.split(",");
        assertThat(tokens).contains("1", "2");
    }

    @Test
    @DisplayName("split을 사용하여 구분자가 없을 때 한 개의 토큰을 만든다.")
    void springOneToken() {
        final String givenString = "1";
        final String[] tokens = givenString.split(",");
        assertThat(tokens).containsExactly("1");
    }

    @Test
    @DisplayName("substring을 사용하여 괄호안의 문자열을 가져온다.")
    void substring() {
        final String givenString = "(1,2)";
        final String result = givenString.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("chatAt을 사용하여 특정 위치의 char를 가져온다.")
    @ParameterizedTest
    @CsvSource({"0,a", "1,b", "2,c"})
    void charAt(int index, char expected) {
        final String givenString = "abc";
        final char result = givenString.charAt(index);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt은 유효하지 않은 인덱스와 함께 호출하면 IndexOutOfBoundsException을 던진다.")
    void charAtIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            final String givenString = "abc";
            final char result = givenString.charAt(10);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 10");
    }
}
