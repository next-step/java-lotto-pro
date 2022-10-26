package step2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitNumberTest {

    @DisplayName("음수 값이 입력된 경우 런타임 에러 발생되는지 확인")
    @Test
    void splitNumber_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
