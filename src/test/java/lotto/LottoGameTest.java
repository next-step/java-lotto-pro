package lotto;

import lotto.domain.LottoCount;
import lotto.domain.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @ParameterizedTest
    @MethodSource("purchase")
    void 로또_구매_성공(LottoCount lottoCount, List<String> manualLottoNumbers, int expected) {
        assertThat(LottoGame.purchase(lottoCount, manualLottoNumbers).count()).isEqualTo(expected);
    }

    private static Stream<Arguments> purchase() {
        return Stream.of(
                Arguments.of(LottoCount.of(Money.from(5000), 2), Arrays.asList("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38"), 5),
                Arguments.of(LottoCount.of(Money.from(3500), 2), Arrays.asList("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38"), 3)
        );
    }
}
