package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


/**
 *   피드백 내용
 *      1) 테스트를 설명할 DisplayName을 작성한다.
 *
 * */

/**
 * packageName : calculator
 * fileName : StringAddCalculatorTest
 * author : haedoang
 * date : 2021-11-02
 * description : 문자열 덧셈 계산기 테스트 클래스
 */
public class StringAddCalculatorTest {
    @Test
    @DisplayName("splitAndSum의 함수는 null 또는 빈문자가 입력될 경우 0을 반환한다.")
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("splitAndSum 함수는 숫자하나가 입력될 경우 해당 문자를 숫자로 형변환하여 반환한다. 숫자가 아닌경우는 RuntimeException 예외를 발생한다.")
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("splitAndSum 함수는 쉼표를 구분자로 문자열을 자른 후 각 문자열에 해당하는 숫자를 더한 값을 반환한다.")
    public void splitAndSum_쉼표구분자() throws Exception {

        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("splitAndSum 함수는 쉼표 또는 콜론을 구분자로 문자열을 자른 후 각 문자열에 해당하는 숫자를 더한 값을 반환한다.")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum 함수는 커스텀 구분자를 기준으로 문자열을 자를 수 있다.")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum 함수는 음수의 값이 입력될 경우 RuntimeException 예외를 발생한다.")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("splitAndSum 함수는 숫자가 아닌 경우 RuntimeException 예외를 발생한다.")
    public void splitAndSum_숫자가_아닌_경우() {
        //WHEN
        Throwable thrown = catchThrowable(() -> StringAddCalculator.splitAndSum("a"));
        //THEN
        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("0~9 사이의 숫자만 입력이 가능합니다.");
    }
}