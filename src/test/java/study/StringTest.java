package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @Test
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
    void substring() {
        // given
        final String text = "(1,2)";
        // when
        final String result = text.substring(1, text.length() - 1);
        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
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
}
