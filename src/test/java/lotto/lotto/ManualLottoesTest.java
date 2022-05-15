package lotto.lotto;

import lotto.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ManualLottoes 클래스 테스트")
class ManualLottoesTest {

    @DisplayName("ManualLottoes의 가격은 n개의 Lotto 곱")
    @ParameterizedTest
    @ArgumentsSource(PriceArgumentsProvider.class)
    void price(List<Lotto> lottoes, Money expected) {
        final ManualLottoes manualLottoes = ManualLottoes.of(lottoes);
        assertThat(manualLottoes.price()).isEqualTo(expected);
    }

    static class PriceArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Arrays.asList(),
                                 Money.of(0L)),
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 3, 4, 5, 6)),
                                 Money.of(1000L)),
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 3, 4, 5, 6), Lotto.of(1, 2, 3, 4, 5, 6)),
                                 Money.of(2000L)),
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 3, 4, 5, 6), Lotto.of(1, 2, 3, 4, 5, 6),
                                               Lotto.of(1, 2, 3, 4, 5, 6)),
                                 Money.of(3000L))
            );
        }
    }

    @DisplayName("ManualLottoes의 갯수은 n개의 Lotto 갯수")
    @ParameterizedTest
    @ArgumentsSource(SizeArgumentsProvider.class)
    void size(List<Lotto> lottoes, int expected) {
        final ManualLottoes manualLottoes = ManualLottoes.of(lottoes);
        assertThat(manualLottoes.size()).isEqualTo(expected);
    }

    static class SizeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Arrays.asList(),
                                 0),
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 3, 4, 5, 6)),
                                 1),
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 3, 4, 5, 6), Lotto.of(1, 2, 3, 4, 5, 6)),
                                 2)
            );
        }
    }
}
