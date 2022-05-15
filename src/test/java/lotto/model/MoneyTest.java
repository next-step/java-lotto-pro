package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    Money money;

    @BeforeEach
    void setUp() {
        money = Money.from(10000);
    }

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
                .isThrownBy(() -> this.money = Money.from(input))
                .withMessage("음수가 입력되어 유효하지 않습니다.");
    }

    @DisplayName("1000원 단위 최대 로또 갯수 테스트")
    @ParameterizedTest(name = "금액 {0}로 {1}의 최대 로또를 살 수 있다.")
    @CsvSource(value = {"1100:1", "3333:3", "10000:10"}, delimiter = ':')
    void moneyMaxLottoCount(int input, int expect) {
        assertThat(Money.from(input)
                .maxLottoCount()).isEqualTo(expect);
    }

    @DisplayName("금액 끼리는 더할 수 있다.")
    @ParameterizedTest(name = "금액 {0}은 {1}와 더해 {2}이 된다.")
    @CsvSource(value = {"1000:2000:3000", "100:0:100", "10000:10:10010"}, delimiter = ':')
    void add(int input, int other, int expect) {
        assertThat(Money.from(input).add(Money.from(other))).isEqualTo(Money.from(expect));
    }

    @DisplayName("금액은 곱할 수 있다.")
    @ParameterizedTest(name = "금액 {0}은 {1}와 곱해 금액 {2}이 된다.")
    @CsvSource(value = {"1000:2:2000", "100:0:0", "10000:10:100000"}, delimiter = ':')
    void multiply(int input, int other, int expect) {
        assertThat(Money.from(input).multiply(other)).isEqualTo(Money.from(expect));
    }

    @DisplayName("금액은 나눌 수 있다.")
    @ParameterizedTest(name = "금액 {0}은 {1}로 나눠 {2}이 된다.")
    @CsvSource(value = {"1000:2:500.00", "100:3:33.33"}, delimiter = ':')
    void divideBy(int input, int other, BigDecimal expect) {
        assertThat(Money.from(input).divideBy(Money.from(other))).isEqualTo(expect);
    }

    @DisplayName("금액을 0으로 나누면 IllegalArgumentException 발생.")
    @ParameterizedTest(name = "금액{0}을 0으로 나누면 IllegalArgumentException 발생.")
    @CsvSource(value = {"1000:0", "0:0"}, delimiter = ':')
    void divideBy(int input, int other) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.from(input).divideBy(Money.from(other)))
                .withMessage("0원으로 나눌 수 없습니다.");
    }
}
