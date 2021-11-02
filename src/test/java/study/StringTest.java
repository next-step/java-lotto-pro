package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @Test
    @DisplayName("1,2를 , 를 구분하여 split() 메소드 사용시, 1과 2를 포함 하는 배열을 반환한다.")
    void split() {
        // given
        final String text = "1,2";
        // when
        final String[] result = text.split(",");
        // then
        assertAll(() -> {
            assertThat(result).contains("1");
            assertThat(result).contains("2");
            assertThat(result).containsExactly("1", "2");
        });

    }

    @Test
    @DisplayName(" \"(1,2)\" 문자열을 substring 메소드를 통해 양쪽 괄호를 제거할 수 있다.")
    void substring() {
        // given
        final String text = "(1,2)";
        // when
        final String result = text.substring(1, text.length() - 1);
        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 사용시, 인덱스 값을 벗어나면 예외가 발생한다.")
    void charAtExceptionTest() {
        // given
        final String text = "abc";
        //when
        final ThrowableAssert.ThrowingCallable textCharAtThrowingCallable = () -> {
            text.charAt(text.length());
        };
        // then
        assertAll(() -> {
            assertThatThrownBy(textCharAtThrowingCallable)
                    .isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: 3");

            assertThatExceptionOfType(IndexOutOfBoundsException.class)
                    .isThrownBy(textCharAtThrowingCallable)
                    .withMessageMatching("String index out of range: \\d+");
        });
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void charAt() {
        // given
        final String text = "abc";
        // when
        final char textA = text.charAt(0);
        final char textB = text.charAt(1);
        final char textC = text.charAt(2);
        // then
        assertAll(() -> {
            assertThat(textA).isEqualTo('a');
            assertThat(textB).isEqualTo('b');
            assertThat(textC).isEqualTo('c');
        });
    }
}
