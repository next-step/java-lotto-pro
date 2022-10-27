package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterFinderTest {
    @ParameterizedTest
    @ValueSource(strings = {"//\\n", "//~\\n", "//.,\\n"})
    @DisplayName("입력 문자열에 // 와 \\n 둘 다 포함하는 경우 ifIncludeBothSlashAndNewline 메서드의 결과값은 '참' 이 된다")
    void trueIfIncludeBothDoubleSlashAndNewline(String input) {
        final DelimiterFinder delimiterFinder = new DelimiterFinder(input);
        final boolean checkResult = delimiterFinder.ifIncludeBothSlashAndNewline();
        assertThat(checkResult).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "//", "\\n"})
    @DisplayName("입력 문자열에 // 와 \\n 둘 중에 하나라도 경우 ifIncludeBothSlashAndNewline 메서드의 결과값은 '거짓' 이 된다")
    void falseIfNeitherIncludeDoubleSlashNorNewline(String input) {
        final DelimiterFinder delimiterFinder = new DelimiterFinder(input);
        final boolean checkResult = delimiterFinder.ifIncludeBothSlashAndNewline();
        assertThat(checkResult).isFalse();
    }
}
