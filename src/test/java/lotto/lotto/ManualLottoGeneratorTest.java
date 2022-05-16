package lotto.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("ManualLottoGenerator 클래스 테스트")
class ManualLottoGeneratorTest {

    @DisplayName("여러개의 Lotto를 생성")
    @ParameterizedTest
    @ArgumentsSource(BatchGenerateArgumentsProvider.class)
    void batchGenerate(List<String> maybeLottoNumbers) {
        final ManualLottoes manualLottoes = ManualLottoes.of(maybeLottoNumbers);
        final ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(manualLottoes);
        final List<Lotto> lottoes = manualLottoGenerator.batchGenerate();
        assertThat(lottoes).hasSize(manualLottoes.size());
        assertThat(manualLottoGenerator.hasMore()).isFalse();
    }

    static class BatchGenerateArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Arrays.asList()),
                    Arguments.of(Arrays.asList("1, 2, 3, 4, 5, 6"),
                                 false),
                    Arguments.of(Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6"),
                                 false)
            );
        }
    }

    @DisplayName("더 이상 생성할 수 없을 때 생성하려고 하면 예외 발생")
    @Test
    void failureGenerate() {
        final ManualLottoes manualLottoes = ManualLottoes.empty();
        final ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(manualLottoes);
        assertThatThrownBy(() -> {
            manualLottoGenerator.generate();
        })
        .isInstanceOf(CanNotGenerateLottoException.class)
        .hasMessageContaining("Lotto를 생성할 수 없습니다.");
    }
}