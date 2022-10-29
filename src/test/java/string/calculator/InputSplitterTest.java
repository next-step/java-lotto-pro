package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputSplitterTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "9"})
    @DisplayName("입력 문자열이 숫자 하나인 경우")
    void singleDigitInput(String input) {
        final InputSplitter inputSplitter = new InputSplitter(input);
        final String[] tokens = inputSplitter.split();
        assertThat(tokens).contains(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "1,2,3"})
    @DisplayName("입력 문자열이 기본 구분자를 사용하는 경우")
    void splitInputWithDefaultDelimiter(String input) {
        final InputSplitter inputSplitter = new InputSplitter(input);
        final String[] tokens = inputSplitter.split();
        assertThat(tokens).contains("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//?\n1?2?3", "//.\n1.2.3", "//~\n1~2~3", "//|\n1|2|3", "//`\n1`2`3"})
    @DisplayName("입력 문자열이 커스텀 구분자를 사용하는 경우")
    void splitInputWithCustomDelimiter(String input) {
        final InputSplitter inputSplitter = new InputSplitter(input);
        final String[] tokens = inputSplitter.split();
        assertThat(tokens).contains("1", "2", "3");
    }
}
