package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("금액은 음수가 아니어야 한다.")
    @Test
    void 음수가_아니어야_함() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(-1000))
                .withMessageContaining("금액은 음수가 아니어야 합니다.");
    }
}
