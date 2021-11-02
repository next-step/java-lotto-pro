package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {
    @DisplayName("컴마를 기준으로 문자열 분리")
    @Test
    void usingComma() {
        assertThat(StringSplitter.split("1,2,3")).containsExactly("1","2","3");
    }

    @DisplayName("콜론을 기준으로 문자열 분리")
    @Test
    void usingColon() {
        assertThat(StringSplitter.split("4:5:6")).containsExactly("4","5","6");
    }

    @DisplayName("콜론과 컴마를 기준으로 문자열 분리")
    @Test
    void usingCommaAndColon() {
        assertThat(StringSplitter.split("7,8:9")).containsExactly("7","8","9");
    }

}
