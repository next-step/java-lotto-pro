package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName : calculator
 * fileName : StringAddCalculatorTest
 * author : haedoang
 * date : 2021-11-02
 * description : 문자열 덧셈 계산기 테스트 클래스
 */
public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {

        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitAndSum_숫자가_아닌_경우() {
        //WHEN
        Throwable thrown = catchThrowable(() -> StringAddCalculator.splitAndSum("a"));
        //THEN
        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("0~9 사이의 숫자만 입력이 가능합니다.");
    }
}
