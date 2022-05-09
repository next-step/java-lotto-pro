package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("컴마(,) 사이로 구성된 문자열을 자르기")
    void splitNormal() {
        String[] split = "1,2".split(",");

        assertAll(
                () -> assertThat(split).containsExactly("1", "2"),
                () -> assertThat(split).hasSize(2)
        );
    }

    @Test
    @DisplayName("컴마(,)로 끝나는 문자열을 자르기")
    void splitAbnormal() {
        String[] split = "1,".split(",");

        assertAll(
                () -> assertThat(split).contains("1"),
                () -> assertThat(split).hasSize(1)
        );
    }

    @Test
    @DisplayName("괄호를 제거하기")
    void removeBracket() {
        String str = "(1,2)";
        String removeBracketString = str.substring(1, str.length() - 1);

        assertEquals("1,2", removeBracketString);
    }

    @Test
    @DisplayName("chatAt 메소드를 통해 특정위치의 문자 가져오기")
    void getCharacterByCharAtMethod() {
        String str = "abc";

        assertAll(
                () -> assertEquals('a', str.charAt(0)),
                () -> assertEquals('b', str.charAt(1)),
                () -> assertEquals('c', str.charAt(2))
        );
    }

    @Test
    @DisplayName("charAt 메소드는 문자열 범위를 벗어나면 StringIndexOutOfBoundsException이 발생")
    void throwExceptionIfOutOfBounds() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(5))
                .withMessageMatching("String index out of range: \\d+");
    }
}
