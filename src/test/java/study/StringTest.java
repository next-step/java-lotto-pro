package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("문자열 콤마 split 테스트")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("콤마가 없는 문자열의 split 테스트")
    void splitStringWithNoDelimiter() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("문자열 처음과 끝 괄호 제거 테스트")
    void getStringWithoutBrackets() {
        String testData = "(1,2)";
        String result = testData.substring(1, testData.length()-1);
        assertThat(result).isEqualTo("1,2");
    }
}
