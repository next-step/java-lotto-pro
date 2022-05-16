package calculator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.domain.ExpressionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("더하기 Expression 유효성 테스트")
class ExpressionUtilsTest {

    @DisplayName("빈 값인지 체크하는 로직에 null 혹은 공백을 넘기면 정상적으로 통과되어야 한다")
    @Test
    void empty_expression_test() {
        assertTrue(ExpressionUtils.isEmptyExpression(""));
        assertTrue(ExpressionUtils.isEmptyExpression(null));
    }

    @DisplayName("숫자 하나인지 체크하는 로직에 숫자 하나를 문자열로 넘기면 정상적으로 통과되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void single_number_expression_test(String input) {
        assertTrue(ExpressionUtils.isSingleNumberExpression(input));
    }

    @DisplayName("Default 인지 체크하는 로직에 숫자 두개를 컴마 구분자로 넘기면 정상적으로 통과되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "2,5", "3,4", "7,7"})
    void default_number_expression_test(String input) {
        assertTrue(ExpressionUtils.isDefaultExpression(input));
    }

    @DisplayName("Default 인지 체크하는 로직에 숫자 두개를 콜론 구분자로 넘기면 정상적으로 통과되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1:2", "2:5", "3:4", "7:7"})
    void default_number_expression_test_2(String input) {
        assertTrue(ExpressionUtils.isDefaultExpression(input));
    }

    @DisplayName("Default 인지 체크하는 로직에 숫자 세개 이상을 콜론/컴마 구분자로 넘기면 정상적으로 통과되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "2:5:1,0", "3:4,2,8", "7:7,9"})
    void default_number_expression_test_3(String input) {
        assertTrue(ExpressionUtils.isDefaultExpression(input));
    }

    @DisplayName("Default 인지 체크하는 로직에 숫자 세개 이상을 콜론/컴마 구분자로 넘기면 정상적으로 통과되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//]\n3]2]3", "//_\n4_5_3"})
    void custom_number_expression_test(String input) {
        assertTrue(ExpressionUtils.isCustomExpression(input));
    }

    @DisplayName("음수가 포함된 식에 대해서는 모두 false 가 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:-3", "-2:5:1,0", "3:4,2,-8", "7:-7,9"})
    void negative_number_expression_test(String input) {
        assertFalse(ExpressionUtils.isEmptyExpression(input));
        assertFalse(ExpressionUtils.isSingleNumberExpression(input));
        assertFalse(ExpressionUtils.isDefaultExpression(input));
        assertFalse(ExpressionUtils.isCustomExpression(input));
    }

    @DisplayName("알 수 없는 형식의 식에 대해서는 모두 false 가 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,", "asdgg", "ee2,q"})
    void invalid_number_expression_test_2(String input) {
        assertFalse(ExpressionUtils.isEmptyExpression(input));
        assertFalse(ExpressionUtils.isSingleNumberExpression(input));
        assertFalse(ExpressionUtils.isDefaultExpression(input));
        assertFalse(ExpressionUtils.isCustomExpression(input));
    }
}
