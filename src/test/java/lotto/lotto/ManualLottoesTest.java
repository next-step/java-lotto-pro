package lotto.lotto;

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

    @DisplayName("ManualLottoes의 갯수은 n개의 Lotto 갯수")
    @ParameterizedTest
    @ArgumentsSource(SizeArgumentsProvider.class)
    void size(List<String> rawLottoes, int expected) {
        final ManualLottoes manualLottoes = ManualLottoes.of(rawLottoes);
        assertThat(manualLottoes.size()).isEqualTo(expected);
    }

    static class SizeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Arrays.asList(),
                            0),
                    Arguments.of(Arrays.asList("1, 2, 3, 4, 5, 6"),
                            1),
                    Arguments.of(Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6"),
                            2)
            );
        }
    }

    @DisplayName("수동 로또 구매 여부")
    @ParameterizedTest
    @ArgumentsSource(IsPurchaseArgumentsProvider.class)
    void isPurchase(List<String> rawLottoes, boolean expected) {
        final ManualLottoes manualLottoes = ManualLottoes.of(rawLottoes);
        assertThat(manualLottoes.isPurchase()).isEqualTo(expected);
    }

    static class IsPurchaseArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Arrays.asList(),
                                 true),
                    Arguments.of(Arrays.asList("1, 2, 3, 4, 5, 6"),
                                 false),
                    Arguments.of(Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6"),
                                 false)
            );
        }
    }
}
