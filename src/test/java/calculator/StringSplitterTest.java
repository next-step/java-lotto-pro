package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringSplitterTest {

    @Test
    @DisplayName("쉼표(,)를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.")
    void splitByCommaDelimiter() {
        String input = "1,2";

        String[] results = StringSplitter.split(input);

        Assertions.assertThat(results).containsExactly("1", "2");
    }

    @Test
    @DisplayName("콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.")
    void splitByColonDelimiter() {
        String input = "1:2";

        String[] results = StringSplitter.split(input);

        Assertions.assertThat(results).containsExactly("1", "2");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1:2,3"})
    @DisplayName("쉼표(,)와 콜론(:) 구분자가 섞여 있는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.")
    void splitByDefaultDelimiter(String input) {
        String[] results = StringSplitter.split(input);

        Assertions.assertThat(results).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//!\n1!2!3", "//#\n1#2#3"})
    @DisplayName("커스텀 구분자를 가지는 문자열을 전달하는 경우 커스텀 구분자를 기준을 분리한다.")
    void splitByCustomDelimiter(String input) {
        String[] results = StringSplitter.split(input);

        Assertions.assertThat(results).containsExactly("1", "2", "3");
    }
}
