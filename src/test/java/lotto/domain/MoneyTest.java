package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @Test
    void 돈_생성_성공() {
        Money money = Money.from(1000);
        assertThat(money).isNotNull();
    }

    @Test
    void 마이너스_돈_생성_실패() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Money.from(-100)
        ).withMessageContaining("돈은 0보다 작을 수 없습니다.");

    }

    @ParameterizedTest
    @MethodSource("isMoreThanOrEqual")
    void 돈_크기비교(Money money1, Money money2, boolean expected) {
        assertThat(money1.isMoreThanOrEqual(money2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minus")
    void 돈_차감(Money money1, Money money2, Money expected) {
        assertThat(money1.minus(money2)).isEqualTo(expected);
    }

    private static Stream<Arguments> isMoreThanOrEqual() {
        return Stream.of(
                Arguments.of(Money.from(1000), Money.from(2000), false),
                Arguments.of(Money.from(3500), Money.from(1000), true)
        );
    }

    private static Stream<Arguments> minus() {
        return Stream.of(
                Arguments.of(Money.from(3000), Money.from(2000), Money.from(1000)),
                Arguments.of(Money.from(3500), Money.from(1000), Money.from(2500))
        );
    }

}
