package calculator.sum;

import calculator.number.PositiveNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumNumbersTest {
    @DisplayName("숫자의 합 계산")
    @Test
    void test_sum() {
        //given
        String text = "1,2,3";
        PositiveNumbers positiveNumbers = PositiveNumbers.newInstance(text);
        SumNumbers sumNumbers = new SumNumbers(positiveNumbers);

        //when
        int sumResult = sumNumbers.getSumResult();

        //then
        assertThat(sumResult).isEqualTo(6);
    }

    @DisplayName("계산할 숫자가 없는 경우 0 반환")
    @Test
    void test_empty() {
        //given
        String text = "";
        PositiveNumbers positiveNumbers = PositiveNumbers.newInstance(text);
        SumNumbers sumNumbers = new SumNumbers(positiveNumbers);

        //when
        int sumResult = sumNumbers.getSumResult();

        //then
        assertThat(sumResult).isEqualTo(0);
    }
}