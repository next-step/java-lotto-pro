package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAdderCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈_문자열을_전달할_경우_0을_반환한다(String 빈_문자열) {
        int 덧셈_결과 = StringAdderCalculator.splitAndSum(빈_문자열);
        assertThat(덧셈_결과).isEqualTo(0);
    }

    @Test
    void Null을_전달할_경우_0을_반환한다() {
        int 덧셈_결과 = StringAdderCalculator.splitAndSum(null);
        assertThat(덧셈_결과).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"0,1,100"})
    void 숫자하나를_전달할_경우_숫자를_그대로_반환한다(String 숫자하나) {
        int 덧셈_결과 = StringAdderCalculator.splitAndSum(숫자하나);
        assertThat(정수_변환(숫자하나)).isEqualTo(덧셈_결과);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1;1","-1,-2;-3","100,200;300"}, delimiter = ';')
    void 숫자_두_개가_쉼표_구분자로_입력할_경우_두_숫자를_분리하여_더한다(String 두_개_숫자, int 덧셈_결과) {
        int 예상_덧셈_결과 = StringAdderCalculator.splitAndSum(두_개_숫자);
        assertThat(예상_덧셈_결과).isEqualTo(덧셈_결과);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1;1","-1:-2;-3","100:200;300"}, delimiter = ';')
    void 숫자_두_개가_콜론_구분자로_입력할_경우_두_숫자를_분리하여_더한다(String 두_개_숫자, int 덧셈_결과) {
        int 예상_덧셈_결과 = StringAdderCalculator.splitAndSum(두_개_숫자);
        assertThat(예상_덧셈_결과).isEqualTo(덧셈_결과);
    }

    private int 정수_변환(String literalInteger) {
        return Integer.parseInt(literalInteger);
    }


}
