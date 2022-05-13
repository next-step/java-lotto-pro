package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    private final Money money = Money.from(10000);

    @DisplayName("돈 초기화 테스트")
    @Test
    void money() {
        assertThat(Money.from(10000)).isEqualTo(money);
    }

    @DisplayName("음수로 돈을 초기화하면 IllegalArgumentException 예외")
    @ParameterizedTest(name = "음수 {0}로 돈을 초기화하면 IllegalArgumentException 예외")
    @ValueSource(ints = {-1, -100, -10000})
    void lottoNotMinMaxRange(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.from(input))
                .withMessage("음수가 입력되어 유효하지 않습니다.");
    }
}
