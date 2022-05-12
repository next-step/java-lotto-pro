package lotto.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoNumber 클래스 테스트")
class LottoNumberTest {

    @DisplayName("LottoNumber 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = { "1", "5", "10", "15", "20", "25", "30", "35", "40", "45" })
    void successfulCreate(String value) {
        assertThat(LottoNumber.of(value)).isNotNull();
    }

    @DisplayName("형식에 맞지 않는 값을 입력 했을때 `LottoNumberFormatException` 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "l" })
    void failureCreateThrownLottoNumberFormatException(String value) {
        assertThatThrownBy(() -> {
            LottoNumber.of(value);
        })
        .isInstanceOf(LottoNumberFormatException.class)
        .hasMessageContaining("LottoNumber 형식에 어긋납니다.");
    }

    @DisplayName("범위 값이 맞지 않는 값을 입력 했을때 `LottoNumberOutOfBoundsException` 발생")
    @ParameterizedTest
    @ValueSource(ints = { LottoNumber.MIN_VALUE - 1, LottoNumber.MAX_VALUE + 1 })
    void failureCreateThrownLottoNumberOutOfBoundsException(int value) {
        assertThatThrownBy(() -> {
            LottoNumber.of(value);
        })
        .isInstanceOf(LottoNumberOutOfBoundsException.class)
        .hasMessageContaining("LottoNumber 범위가 아닙니다.");
    }

    @DisplayName("LottoNumber 동등성 비교")
    @ParameterizedTest
    @ArgumentsSource(EqualsArgumentsProvider.class)
    void equals(LottoNumber lottoNumber, LottoNumber other, boolean expected) {
        assertThat(lottoNumber.equals(other)).isEqualTo(expected);
    }

    static class EqualsArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(LottoNumber.of(LottoNumber.MIN_VALUE), LottoNumber.of(1), true),
                    Arguments.of(LottoNumber.of(LottoNumber.MIN_VALUE), LottoNumber.of(2), false),
                    Arguments.of(LottoNumber.of(LottoNumber.MAX_VALUE), LottoNumber.of(45), true),
                    Arguments.of(LottoNumber.of(LottoNumber.MAX_VALUE), LottoNumber.of(44), false),
                    Arguments.of(LottoNumber.of(31), LottoNumber.of(31), true),
                    Arguments.of(LottoNumber.of(31), LottoNumber.of(32), false)
            );
        }
    }

    @DisplayName("LottoNumber 정렬")
    @ParameterizedTest
    @ArgumentsSource(SortArgumentsProvider.class)
    void sort(List<LottoNumber> lottoNumbers, List<LottoNumber> expected) {
        Collections.sort(lottoNumbers);
        assertThat(lottoNumbers).isEqualTo(expected);
    }

    static class SortArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)),
                                 Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3))),
                    Arguments.of(Arrays.asList(LottoNumber.of(5), LottoNumber.of(3), LottoNumber.of(4)),
                                 Arrays.asList(LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5)))
            );
        }
    }
}
