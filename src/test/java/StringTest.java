import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @ParameterizedTest
    @ValueSource(strings = "1,2")
    @DisplayName("\",\" 포멧문자열을 String.split() 후 입력 값 포함 및 순서 테스트")
    void stringSplitTest(String input) {
        // given

        // when
        String[] stringSplit = input.split(",");

        // then
        assertThat(stringSplit).contains("1");
        assertThat(stringSplit).containsExactly("1", "2");
    }

    @Test
    @DisplayName("콤마 없는 문자열을 split 할 경우 배열에 입력 문자열만 포함된다.")
    void singleStringSplitTest() {
        // given
        String input = "A";
        String[] expected = {input};

        // when
        String[] stringSplit = input.split(",");

        // then
        assertThat(stringSplit).isEqualTo(expected);
    }

    @Test
    @DisplayName("빈문자열을 split 할 경우 배열에 빈문자열만 포함된다.")
    void emptySplitTest() {
        // given
        String input = "";
        String[] expected = {""};

        // when
        String[] stringSplit = input.split(",");

        // then
        assertThat(stringSplit).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"(1,2):1,2"}, delimiter = ':')
    @DisplayName("substring 을 활용하여 맨 앞뒤 '(', ')' 제거 테스트")
    void stringSubstringTest(String input, String expected) {
        // given
        int startIndex = 1;
        int lastIndex = input.length() - 1;

        // when
        String stringSub = input.substring(startIndex, lastIndex);

        // then
        assertThat(stringSub).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "abc,0,a",
        "def,1,e",
        "ghi,2,i"
    })
    @DisplayName("String.charAt() 특정 위치의 문자열 비교 테스트")
    void validateSpecificIndexCharacter(String input, int validIndex, char expected) {
        // given

        // when , then
        assertEquals(input.charAt(validIndex), expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "abc:3",
        "abc:-1"
    }, delimiter = ':')
    @DisplayName("문자열 'length' 범위를 벗어나게하여 String.charAt() 의 StringIndexOutOfBoundsException 예외발생 테스트")
    void charAtIndexOutOfBoundsExceptionTest(String input, int overRangeIndex) {
        // given

        // when
        assertThatThrownBy(() -> {
            Character c = input.charAt(overRangeIndex);
        })// then
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: " + overRangeIndex);
    }

}
