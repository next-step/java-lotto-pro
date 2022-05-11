import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.ExpressionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("더하기 Expression 유효성 테스트")
class ExpressionUtilsTest {

    @DisplayName("빈 값인지 체크하는 로직에 null 혹은 공백을 넘기면 정상적으로 통과되어야 한다")
    @Test
    void empty_expression_test() {
        assertTrue(ExpressionUtils.isEmptyExpression(""));
        assertTrue(ExpressionUtils.isEmptyExpression(null));
    }
}
