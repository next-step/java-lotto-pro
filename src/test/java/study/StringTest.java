package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("요구사항1 - 1과2로 분리되는지 확인")
    @Test
    void matchStringListWhenSplitTwoWordsByComma() {
        String testValue = "1,2";
        String[] result = testValue.split(",");
        assertThat(result).contains("1","2");
    }

    @DisplayName("요구사항1 - 1만을 포함하는 배열이 반환되는 지 확인")
    @Test
    void matchStringListWhenSplitOneWordByComma() {
        String testValue = "1";
        String[] result = testValue.split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("요구사항2 - ()제거하고 안의 문자열 추출 확인")
    @Test
    void matchStringWhenExtractStringWithinBrackets () {
        String testValue = "(1,2)";
        String openingBracket = "(";
        String closingBracket = ")";

        int beginIndex = testValue.indexOf(openingBracket) + 1;
        int endIndex = testValue.indexOf(closingBracket);
        String result = testValue.substring(beginIndex, endIndex);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항3 - 특정 위치의 문자를 가져올 때 값의 위치를 벗어났을 경우 에러 발생")
    @Test
    void throwsIndexOutOfRangeExceptionWhenReturnCharAtTheSpecifiedIndex() {
        String testValue = "abc";
        int outOfBoundIndex = testValue.length() + 1;

        assertThatThrownBy(() -> testValue.charAt(outOfBoundIndex))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
