package lotto;

import lotto.domain.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @ParameterizedTest
    @MethodSource("purchase")
    void 로또_구매_성공(Money money, int expected) {
        assertThat(LottoGame.purchase(money).count()).isEqualTo(expected);

    }

    private static Stream<Arguments> purchase() {
        return Stream.of(
                Arguments.of(Money.from(5000), 5),
                Arguments.of(Money.from(3500), 3)
        );
    }
}
