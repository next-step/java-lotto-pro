package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void 문자열_콤마로_split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void 구분자가_없는_문자열의_split() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void 문자열_처음과_끝_괄호_제거() {
        String testData = "(1,2)";
        String result = testData.substring(1, testData.length()-1);
        assertThat(result).isEqualTo("1,2");
    }
}
