package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    void moneyNegativeNumber(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.from(input))
                .withMessage("음수가 입력되어 유효하지 않습니다.");
    }

    @DisplayName("1000원 단위 최대 로또 갯수 테스트")
    @ParameterizedTest(name = "금액 {0}로 {1}의 최대 로또를 살 수 있다.")
    @CsvSource(value = {"1100:1", "3333:3", "10000:10"}, delimiter = ':')
    void moneyMaxLottoCount(int input, int expect) {
        assertThat(Money.from(input)
                .maxLottoCount()).isEqualTo(expect);
    }
}
