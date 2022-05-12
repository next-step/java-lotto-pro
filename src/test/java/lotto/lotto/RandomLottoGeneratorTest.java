package lotto.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RandomLottoGenerator 클래스 테스트")
class RandomLottoGeneratorTest {

    private final List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2),
                                                                 LottoNumber.of(3), LottoNumber.of(4),
                                                                 LottoNumber.of(5), LottoNumber.of(6));

    @Test
    void successfulCreate() {
        assertThat(new RandomLottoGenerator(lottoNumbers)).isNotNull();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ArgumentsSource(FailureCreateArgumentsProvider.class)
    void failureCreate(List<LottoNumber> lottoNumbers) {
        assertThatThrownBy(() -> {
            new RandomLottoGenerator(lottoNumbers);
        })
        .isInstanceOf(FailureCreatingLottoGeneratorException.class)
        .hasMessageContaining("LottoGenerator 생성 실패했습니다.");
    }

    static class FailureCreateArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2),
                                               LottoNumber.of(3), LottoNumber.of(4),
                                               LottoNumber.of(5)))
            );
        }
    }

    @Test
    void generate() {
        final LottoGenerator fixedLottoGenerator = new RandomLottoGenerator(lottoNumbers);
        final Lotto lotto = fixedLottoGenerator.generate();
        assertThat(lotto).isEqualTo(Lotto.of(1, 2, 3, 4, 5, 6));
    }
}
