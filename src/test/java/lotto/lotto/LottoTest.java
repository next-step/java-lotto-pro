package lotto.lotto;

import lotto.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto 클래스 테스트")
class LottoTest {

    @DisplayName("로또는 1000원이다.")
    @Test
    void lottoPrice() {
        final Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        assertThat(lotto.price()).isEqualTo(Money.ONE_THOUSAND);
    }

    @DisplayName("생성시 중복되는 로또 번호가 존재하여 `AlreadyExistsLottoNumberException` 발생")
    @Test
    void duplicatedLottoNumber() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 6);
        assertThatThrownBy(() -> {
            Lotto.of(numbers);
        })
        .isInstanceOf(AlreadyExistsLottoNumberException.class)
        .hasMessageContaining("이미 존재하는 로또 번호입니다.");
    }

    @DisplayName("생성시 로또 번호의 갯수가 올바르지 않아 `IncorrectLottoNumberSizeException` 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ArgumentsSource(IncorrectLottoNumberSizeArgumentsProvider.class)
    void incorrectLottoNumberSize(List<Integer> numbers) {
        assertThatThrownBy(() -> {
            Lotto.of(numbers);
        })
        .isInstanceOf(IncorrectLottoNumberSizeException.class)
        .hasMessageContaining("로또 번호의 갯수가 올바르지 않습니다.");
    }

    static class IncorrectLottoNumberSizeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Collections.singletonList(1)),
                    Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
            );
        }
    }

    @DisplayName("일치하는 LottoNumber의 갯수를 반환")
    @ParameterizedTest
    @ArgumentsSource(CountMatchesArgumentsProvider.class)
    void countMatches(Lotto lotto, Lotto other, int expected) {
        assertThat(lotto.countMatches(other)).isEqualTo(expected);
    }

    static class CountMatchesArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                 Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                 6),
                    Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                 Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7)),
                                 5),
                    Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                 Lotto.of(Arrays.asList(1, 2, 3, 4, 7, 8)),
                                 4),
                    Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                 Lotto.of(Arrays.asList(1, 2, 3, 7, 8, 9)),
                                 3),
                    Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                 Lotto.of(Arrays.asList(1, 2, 7, 8, 9, 10)),
                                 2),
                    Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                 Lotto.of(Arrays.asList(1, 7, 8, 9, 10 ,11)),
                                 1),
                    Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                 Lotto.of(Arrays.asList(7, 8, 9, 10, 11, 12)),
                                 0),
                    Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                 Lotto.of(Arrays.asList(6, 5, 4, 3, 2, 1)),
                                 6)
            );
        }
    }
}
