package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterFinderTest {
    private final String DEFAULT_DELIMITER_REGEX = "[:,]";

    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "1,2,3"})
    @DisplayName("입력 문자열에 // \\n 가 없다면 default delimiter 를 반환한다")
    void findReturnDefaultDelimiter(String input) {
        final DelimiterFinder delimiterFinder = new DelimiterFinder(input);
        final String delimiter = delimiterFinder.find();
        assertThat(delimiter).isEqualTo(DEFAULT_DELIMITER_REGEX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//?\\n1?2?3", "//.\\n1.2.3", "//~\\n1~2~3", "//|\\n1|2|3", "//`\\n1`2`3"})
    @DisplayName("입력 문자열에서 // 와 \\n 사이에 다른 문자열이 있다면 custom delimiter 를 반환한다")
    void findReturnCustomDelimiter(String input) {
        final DelimiterFinder delimiterFinder = new DelimiterFinder(input);
        final String delimiter = delimiterFinder.find();
        assertThat(delimiter).isEqualTo(DEFAULT_DELIMITER_REGEX);
    }
}
