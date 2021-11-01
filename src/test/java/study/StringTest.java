package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest {

    public static final String DELIMITER = ",";

    @Test
    @DisplayName("복수문자 나누기")
    void splitMultiString() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(DELIMITER);

        // then
        assertThat(result)
                .contains("1", "2");
    }

    @Test
    @DisplayName("단일문자 나누기")
    void splitSingleString() {
        // given
        String input = "1";

        // when
        String[] result = input.split(DELIMITER);

        // then
        assertThat(result)
                .contains("1");
    }

    @Test
    @DisplayName("문자의 앞 뒤 제거")
    void subStringEachEnd() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, input.length() - 1);

        // then
        assertThat(result)
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치 문자 가져오기")
    void charAtFromCorrectIndex() {
        // given
        String input = "abc";

        // when
        char testResult = input.charAt(1);

        // then
        assertThat(testResult)
                .isEqualTo('b');
    }

    @Test
    @DisplayName("벗어난 범위 문자 가져오기")
    void charAtFromIncorrectIndex() {
        // given
        String input = "abc";
        int inCorrectIndex = 5;

        // when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> input.charAt(inCorrectIndex);

        // then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(throwingCallable)
                .withMessage("String index out of range: %d", inCorrectIndex);
    }
}
