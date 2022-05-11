package study.step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {
    @Test
    @DisplayName("문자열 분리 - 콤마 포함 문자열")
    void splitTest_withDelimiter() {
        String[] result = StringUtil.split("1,2", ",");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(result).contains("1");
        softAssertions.assertThat(result).contains("2");
        softAssertions.assertThat(result).containsExactly("1", "2");
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("문자열 분리 - 콤마 미포함 문자열")
    void splitTest_withoutDelimiter() {
        String[] result = "1".split(",");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(result).contains("1");
        softAssertions.assertThat(result).containsExactly("1");
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("괄호 제거 - 괄호가 포함된 문자열")
    void removeBracket_useSubString() {
        String result = StringUtil.removeBrackets("(1,2)");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("괄호 제거 - 괄호와 앞뒤 공백이 포함된 문자열")
    void removeBracket_useSubString_includeSpace() {
        String result = StringUtil.removeBrackets("    (1,2)   ");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 특정 index값 가져오기")
    void getChar() {
        char result = StringUtil.getChar("abcde", 3);
        assertThat(result).isEqualTo('d');
    }

    @Test
    @DisplayName("문자열의 특정 index값 가져오기 - 범위 밖 index")
    void getChar_outOfBoundsException() {
        assertThatThrownBy(() -> StringUtil.getChar("abcde", 99))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
