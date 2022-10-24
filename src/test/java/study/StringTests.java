package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringTests {

    @ParameterizedTest
    @MethodSource("stringProvider")
    void split이_잘_되는지_확인(String input, String[] expected) {
        String[] split = input.split(",");

        assertThat(split).containsExactly(expected);
    }

    @Test
    void substring이_잘_되는지_확인() {
        String input = "(1,2)";
        String[] substring = input.substring(1, input.length() - 1).split(",");

        assertThat(substring).containsExactly("1", "2");
    }

    @ParameterizedTest
    @MethodSource("chatAtProvider")
    void chatAt이_잘_되는지_확인(int index, char expected) {
        String input = "abc";
        char charAt = input.charAt(index);

        assertThat(charAt).isEqualTo(expected);
    }

    @Test
    void 범위를_벗어나는_인덱스를_입력하면_예외가_발생한다() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    private static Stream<Arguments> chatAtProvider() {
        return Stream.of(
                Arguments.of(0, 'a'),
                Arguments.of(1, 'b'),
                Arguments.of(2, 'c')
        );
    }

    private static Stream<Arguments> stringProvider() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }
}
