package calculator.split;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {
    @DisplayName("기본 구분자인 쉼표(,)와 콜론(:)으로 split 처리")
    @Test
    void test_기본_구분자로_문자열_split() {
        //given
        String text = "1,2:3";
        StringSplitter stringSplitter = new StringSplitter(text);

        //when
        String[] splitNumbers = stringSplitter.splitText();

        //then
        assertThat(splitNumbers.length).isEqualTo(3);
    }

    @DisplayName("기본 구분자가 아닌 문자 사용")
    @Test
    void test_기본_구분자가_아닌_문자로_split() {
        //given
        String text = "1,2&3";
        StringSplitter stringSplitter = new StringSplitter(text);

        //when
        String[] splitNumbers = stringSplitter.splitText();

        //then
        assertThat(splitNumbers.length).isNotEqualTo(3);
    }

    @DisplayName("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자로 split 처리")
    @Test
    void test_커스텀_구분자로_문자열_split() {
        //given
        String text = "//;\n1;2;3";
        StringSplitter stringSplitter = new StringSplitter(text);

        //when
        String[] splitNumbers = stringSplitter.splitText();

        //then
        assertThat(splitNumbers.length).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자가 아닌 문자 사용")
    @Test
    void test_커스텀_구분자가_아닌_문자로_split() {
        //given
        String text = "//;\n1;2&3";
        StringSplitter stringSplitter = new StringSplitter(text);

        //when
        String[] splitNumbers = stringSplitter.splitText();

        //then
        assertThat(splitNumbers.length).isNotEqualTo(3);
    }
}