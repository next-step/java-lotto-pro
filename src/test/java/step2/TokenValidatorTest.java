package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TokenValidatorTest {
    @Test
    @DisplayName("숫자만 존재하는지 여부")
    void isNumberOnly() throws Exception {
        assertThat(TokenValidator.isNumberOnly("1")).isTrue();
        assertThat(TokenValidator.isNumberOnly("a4")).isFalse();
    }

    @Test
    @DisplayName("음수를 입력하면 RuntimeException 예외 발생")
    void validate_음수() throws Exception {
        assertThatThrownBy(() -> TokenValidator.validateTokens("-1,2,3".split(",")))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 이외의 값을 입력하면 RuntimeException 예외 발생")
    void validate_숫자_이외의_값() throws Exception {
        assertThatThrownBy(() -> TokenValidator.validateTokens("a,b,1,2,3".split(",")))
                .isInstanceOf(RuntimeException.class);
    }
}
