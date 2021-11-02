package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("StringAddCalculator.splitAndSum 의 null 또는 빈문자 입력시 0 리턴")
    public void splitAndSum_null_또는_빈문자(String input) {
        // given, when
        int result = StringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("문자 길이 1일때 그대로 반환, \"1\" 문자열 입력시 1을 반환")
    public void splitAndSum_숫자하나() {
        // given, when
        int result = StringAddCalculator.splitAndSum("1");

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("콤마로 구분된 숫자 문자 (1,2) 입력 결과 3 검증")
    public void splitAndSum_쉼표구분자() throws Exception {
        // given, when
        int result = StringAddCalculator.splitAndSum("1,2");

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마,콜론 혼용 문자 (1,2:3:3) 입력 결과 9 검증")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        // given, when
        int result = StringAddCalculator.splitAndSum("1,2:3:3");

        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("커스텀 구분자 (//A\n1A2A3A3) 입력 결과 9 검증")
    public void splitAndSum_custom_구분자() throws Exception {
        // given, when
        int result = StringAddCalculator.splitAndSum("//A\n1A2A3A3");

        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("음수 입력 시 RuntimeException 발생")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("계산에 문자 입력 시 RuntimeException 발생")
    public void splitAndSum_string_sum_exception() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a,2,3"))
            .isInstanceOf(RuntimeException.class);
    }

}
