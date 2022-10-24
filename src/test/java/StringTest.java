import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @TestInstance(Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("요구사항 1")
    class Requirements1 {

        @ParameterizedTest(name = "{displayName} - Text: [\"{0}\"], Regex: [\",\"], Expected: [{1}]")
        @MethodSource("expectedParameters")
        @DisplayName("split 테스트")
        public void testStringSplit(String input, String[] expected) {
            assertThat(input.split(","))
                    .isNotEmpty()
                    .containsExactly(expected);
        }

        private Stream<Arguments> expectedParameters() {
            return Stream.of(
                    Arguments.of("1,2", new String[]{"1", "2"}),
                    Arguments.of("1", new String[]{"1"})
            );
        }
    }

    @Nested
    @DisplayName("요구사항 2")
    class Requirements2 {

        @Test
        @DisplayName("substring 테스트 - Text: [\"(1,2)\"], Expected: [\"1,2\"]")
        public void testSubstring() {
            String text = "(1,2)";
            String substring = text.substring(1, text.length() - 1);
            assertThat(substring).isEqualTo("1,2");
        }
    }

    @TestInstance(Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("요구사항 3")
    class Requirements3 {

        private final String text = "abc";

        @ParameterizedTest(name = "{displayName} - Text: [\"abc\"], Index: [{0}], Expected: [{1}]")
        @MethodSource("expectedParameters")
        @DisplayName("charAt 테스트")
        public void testCharAt(int index, char expected) {
            char result = text.charAt(index);
            assertThat(result).isEqualTo(expected);
        }

        @SuppressWarnings("all")
        @Test
        @DisplayName("charAt 테스트 - Text: [\"abc\"], Index: [3], Exception: [StringIndexOutOfBoundsException]")
        public void testInvalidCharAt() {
            assertThatThrownBy(() -> {
                char result = text.charAt(3);
            }).isInstanceOf(StringIndexOutOfBoundsException.class);
        }

        private Stream<Arguments> expectedParameters() {
            return Stream.of(
                    Arguments.of(0, 'a'),
                    Arguments.of(1, 'b'),
                    Arguments.of(2, 'c')
            );
        }
    }
}
