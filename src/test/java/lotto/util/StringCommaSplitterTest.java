package lotto.util;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StringCommaSplitterTest {
    @DisplayName("쉼표(,) 구분자로 split 처리")
    @Test
    void test_쉼표_구분자로_문자열_split() {
        //given
        String inputNumbers = "1,2,3,4,5,6";
        //when
        List<Integer> numbers = StringCommaSplitter.splitNumbers(inputNumbers);
        //then
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("쉼표(,) 구분자로 split 처리 시 공백이 있으면 trim 처리")
    @Test
    void test_쉼표_구분자인_문자열에_공백_처리() {
        //given
        String inputNumbers = "1, 2,3   ,4 ,  5,6   ";
        //when
        List<Integer> numbers = StringCommaSplitter.splitNumbers(inputNumbers);
        //then
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("공백 입력 시 예외 처리")
    @Test
    void test_공백_입력() {
        //given
        String inputNumbers = "";
        //when & then
        assertThatThrownBy(() -> StringCommaSplitter.splitNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER_FORMAT);
    }
}