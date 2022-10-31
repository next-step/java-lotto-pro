package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {
    @DisplayName("값이 같으면 동일하다.")
    @Test
    void 동일성() {
        final Money one = new Money(100);
        final Money another = new Money(100);

        assertThat(one).isEqualTo(another);
    }

    @ParameterizedTest(name = "{0}원 == 0원? {1}")
    @CsvSource({
            "0, true",
            "1, false"
    })
    void zero(final int value, final boolean expectedZero) {
        final Money money = new Money(value);

        assertThat(money.isZero()).isEqualTo(expectedZero);
    }

    @DisplayName("ZERO는 0원이다.")
    @Test
    void static_ZERO() {
        assertThat(Money.ZERO.isZero()).isTrue();
    }

    @DisplayName("금액은 음수가 아니어야 한다.")
    @Test
    void 음수가_아니어야_함() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(-1000))
                .withMessageContaining("금액은 음수가 아니어야 합니다.");
    }

    @DisplayName("금액을 금액으로 나눌 수 있다.")
    @ParameterizedTest(name = "{0} / {1} = {2} (몫만 반환)")
    @CsvSource({
            "10000, 1000, 10",
            "0, 1000, 0",
            "1500, 1000, 1"
    })
    void 나누기(final int oneValue, final int otherValue, final int expected) {
        final Money something = new Money(oneValue);
        final Money other = new Money(otherValue);

        final int actual = something.divide(other);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("0으로 나눌 수 없다.")
    @Test
    void 영으로_나누기() {
        final Money something = new Money(1000);
        final Money zero = new Money(0);

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> something.divide(zero));
    }

    @DisplayName("금액을 곱할 수 있다.")
    @Test
    void 곱하기() {
        final Money something = new Money(1000);
        final Money expected = new Money(1_000_000);

        final Money actual = something.multiply(1_000);

        assertThat(actual).isEqualTo(expected);
    }
}
