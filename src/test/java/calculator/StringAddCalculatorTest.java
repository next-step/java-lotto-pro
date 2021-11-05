package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Nested
    @DisplayName("만든 테스트 케이스")
    class SelfTestCase {
        @DisplayName("빈 문자 or null 입력 테스트")
        @Test
        void splitAndSumNullOrEmptyText() {
            // given
            String text = "";
            // when
            int result = StringAddCalculator.splitAndSum(text);
            // then
            assertThat(result).isEqualTo(0);
        }

        @DisplayName("커스텀 구분자 없이 입력 후 합계 확인")
        @Test
        void splitAndSumNullWithoutCustomDelimiter() {
            // given
            String text = "1,2,3";
            // when
            int result = StringAddCalculator.splitAndSum(text);
            // then
            assertThat(result).isEqualTo(6);
        }

        @DisplayName("커스텀 구분자가 있는 입력 후 합계 확인")
        @Test
        void splitAndSumNullWithCustomDelimiter() {
            // given
            String text = "//b\n1b2b3";
            // when
            int result = StringAddCalculator.splitAndSum(text);
            // then
            assertThat(result).isEqualTo(6);
        }

        @DisplayName("값 하나 합계 테스트")
        @Test
        void splitAndSumNullSingle() {
            // given
            String text = "//b\n1";
            // when
            int result = StringAddCalculator.splitAndSum(text);
            // then
            assertThat(result).isEqualTo(1);
        }

        @DisplayName("값 여러개 합계 테스트")
        @Test
        void splitAndSumNullMultiple() {
            // given
            String text = "//b\n1,2b3";
            // when
            int result = StringAddCalculator.splitAndSum(text);
            // then
            assertThat(result).isEqualTo(6);
        }
    }

    @Nested
    @DisplayName("넥스트 스탭에서 다운로드 받은 테스트 케이스")
    class NextStepTestCase {
        // 넥스트 스탭 소스 코드
        @DisplayName("빈문자 또는 null 테스트")
        @Test
        public void splitAndSumNullOrEmptyString() {
            int result = StringAddCalculator.splitAndSum(null);
            assertThat(result).isEqualTo(0);

            result = StringAddCalculator.splitAndSum("");
            assertThat(result).isEqualTo(0);
        }

        @DisplayName("숫자 하나 테스트")
        @Test
        public void splitAndSumSingleNumber() throws Exception {
            int result = StringAddCalculator.splitAndSum("1");
            assertThat(result).isEqualTo(1);
        }

        @DisplayName("숫자 여러개 테스트 (구분자 하나)")
        @Test
        public void splitAndSumMultipleNumber() throws Exception {
            int result = StringAddCalculator.splitAndSum("1,2");
            assertThat(result).isEqualTo(3);
        }

        @DisplayName("숫자 여러개 테스트 (구분자 개수 2개)")
        @Test
        public void splitAndSumMultipleNumberMultipleDelimiter() throws Exception {
            int result = StringAddCalculator.splitAndSum("1,2:3");
            assertThat(result).isEqualTo(6);
        }

        @DisplayName("숫자 여러개 테스트 (커스텀 구분자)")
        @Test
        public void splitAndSumCustomDelimiter() throws Exception {
            int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
            assertThat(result).isEqualTo(6);
        }

        @DisplayName("음수 예외 검사 테스트")
        @Test
        public void splitAndSumNegative() throws Exception {
            assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                    .isInstanceOf(RuntimeException.class);
        }
    }
}
