package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("숫자두개 ,로 분리 테스트")
    void splitTwoNumberTest() {
        String[] testData = "1,2".split(",");
        assertThat(testData).containsExactly("1","2");
    }

    @Test
    @DisplayName("숫자 한개 ,로 분리 테스트")
    void splitOneNumberTest() {
        String[] testData = "1".split(",");
        assertThat(testData).contains("1");
    }

    @Test
    @DisplayName("인덱스 밖의 문자열 조회 테스트")
    void splitSmallBracketTest() {
        String testData = "abc";
        int index = 3;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    testData.charAt(index);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
