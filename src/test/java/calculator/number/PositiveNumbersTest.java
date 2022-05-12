package calculator.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PositiveNumbersTest {

    @DisplayName("빈 값이 입력될 경우 0 반환")
    @Test
    void test_empty_text() {
        //given
        String text = "";

        //when
        PositiveNumbers positiveNumbers = PositiveNumbers.newInstance(text);
        List<PositiveNumber> positiveNumberList = positiveNumbers.getPositiveNumbers();

        //then
        assertThat(positiveNumberList.size()).isEqualTo(1);
        assertThat(positiveNumberList.get(0).parseNumber()).isEqualTo(0);
    }

    @DisplayName("null 이 입력될 경우 0 반환")
    @Test
    void test_null_text() {
        //given
        String text = null;

        //when
        PositiveNumbers positiveNumbers = PositiveNumbers.newInstance(text);
        List<PositiveNumber> positiveNumberList = positiveNumbers.getPositiveNumbers();

        //then
        assertThat(positiveNumberList.size()).isEqualTo(1);
        assertThat(positiveNumberList.get(0).parseNumber()).isEqualTo(0);
    }

    @DisplayName("기본 구분자인 쉼표(,)와 콜론(:)으로 PositiveNumber 배열 반환")
    @Test
    void test_기본_구분자로_PositiveNumber_배열() {
        //given
        String text = "1,2:3";

        //when
        PositiveNumbers positiveNumbers = PositiveNumbers.newInstance(text);
        List<PositiveNumber> positiveNumberList = positiveNumbers.getPositiveNumbers();

        //then
        assertThat(positiveNumberList.size()).isEqualTo(3);
    }

    @DisplayName("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자로 PositiveNumber 배열 반환")
    @Test
    void test_커스텀_구분자로_PositiveNumber_배열() {
        //given
        String text = "//;\n1;2;3";

        //when
        PositiveNumbers positiveNumbers = PositiveNumbers.newInstance(text);
        List<PositiveNumber> positiveNumberList = positiveNumbers.getPositiveNumbers();

        //then
        assertThat(positiveNumberList.size()).isEqualTo(3);
    }
}