package util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilTest {
    @DisplayName("null 값이 isEmpty에서 빈 값으로 분류되는지 확인")
    @Test
    public void isEmptyWithNull() {
        assertThat(StringUtil.isEmpty(null)).isTrue();
    }

    @DisplayName("Empty String 객체가 isEmpty에서 빈 값으로 분류되는지 확인")
    @Test
    public void isEmptyWithEmpty() {
        assertThat(StringUtil.isEmpty("")).isTrue();
    }

    @DisplayName("비어있지 않은 String 객체가 isEmpty에서 비지 않은 것으로 분류되는지 확인")
    @Test
    public void isEmptyWithNotEmpty() {
        assertThat(StringUtil.isEmpty("ABC")).isFalse();
    }


    @DisplayName("기본 Delimiter로 단일 숫자 문자를 split")
    @Test
    public void splitNumbersStringWithSingleNumber() {
        assertThat(StringUtil.splitNumbersString("1")).containsExactly(1);
    }

    @DisplayName("기본 Delimiter ','로 숫자열 문자를 split")
    @Test
    public void splitNumbersStringWithComma() {
        assertThat(StringUtil.splitNumbersString("1,2,3")).containsExactly(1, 2, 3);
    }

    @DisplayName("기본 Delimiter ':'로 숫자열 문자를 split")
    @Test
    public void splitNumbersStringWithColon() {
        assertThat(StringUtil.splitNumbersString("1:2:3")).containsExactly(1, 2, 3);
    }

    @DisplayName("커스텀 Delimiter '\t'로 숫자열 문자를 split")
    @Test
    public void splitNumbersStringWithCustomDelimiter() {
        assertThat(StringUtil.splitNumbersString("1\t2\t3")).containsExactly(1, 2, 3);
    }

    @DisplayName("기본 Delimiter로 빈 문자열을 split")
    @Test
    public void splitNumbersStringWithEmptyString() {
        assertThat(StringUtil.splitNumbersString("")).isEmpty();
    }

    @DisplayName("기본 Delimiter로 null을 split")
    @Test
    public void splitNumbersStringWithNull() {
        assertThat(StringUtil.splitNumbersString(null)).isEmpty();
    }

    @DisplayName("숫자가 아닌 값이 들어있는 String split 시 Exception 확인")
    @Test
    public void splitNumbersStringWithNoneNumber() {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> StringUtil.splitNumbersString("A,2,3"));
    }


}