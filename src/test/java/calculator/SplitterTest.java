package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @Test
    @DisplayName("null이 들어왔을 경우 검증")
    public void checkNull() {
        Splitter splitter = new Splitter(null);
        assertThat(splitter.getSplitResult()).contains("0");
    }

    @ParameterizedTest
    @DisplayName("빈 문자열이 들어왔을 경우 검증")
    @ValueSource(strings = {"", " ", "  "})
    public void checkBlank(String input) {
        Splitter splitter = new Splitter(input);
        assertThat(splitter.getSplitResult()).contains("0");
    }

    @ParameterizedTest
    @DisplayName("문자열 중간에 공백이 있을 경우")
    @ValueSource(strings = {"1,2, 3", "1,2: 3 "})
    public void checkGapBetween(String input) {
        Splitter splitter = new Splitter(input);
        assertThat(splitter.getSplitResult()).contains("3");
    }
}
