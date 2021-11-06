package common;

import lotto.domain.PurchasePrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * packageName : common
 * fileName : CustomEmptyExceptionTest
 * author : haedoang
 * date : 2021/11/06
 * description : 빈값 예외 처리 테스트 클래스
 */
public class CustomEmptyExceptionTest {

    @ParameterizedTest(name = "빈값 예외 처리 테스트 : " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
    @ValueSource(strings = {""})
    @NullSource()
    public void T01_emptyTest(String candidate) {
        Assertions.assertThatThrownBy(() -> new PurchasePrice(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈값이나 null은 허용되지 않습니다.");
    }
}
