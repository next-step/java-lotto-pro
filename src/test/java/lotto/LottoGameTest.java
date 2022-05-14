package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGameTest {

    @ParameterizedTest
    @MethodSource("purchase")
    void 로또_구매_성공(Money money, int expected) {
        assertThat(LottoGame.purchase(money).count()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {500, -500})
    void 로또_구매_실패(int invalidMoney){
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoGame.purchase(Money.from(invalidMoney))
        );
    }

    private static Stream<Arguments> purchase() {
        return Stream.of(
                Arguments.of(Money.from(5000), 5),
                Arguments.of(Money.from(3500), 3)
        );
    }
}
