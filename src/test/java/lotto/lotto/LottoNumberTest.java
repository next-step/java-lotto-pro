package lotto.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoNumber 클래스 테스트")
class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(strings = { "1", "5", "10", "15", "20", "25", "30", "35", "40", "45" })
    void successfulCreate(String value) {
        assertThat(LottoNumber.of(value)).isNotNull();
    }

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

    @ParameterizedTest
    @ValueSource(ints = { LottoNumber.MIN_VALUE - 1, LottoNumber.MAX_VALUE + 1 })
    void failureCreateThrownLottoNumberOutOfBoundsException(int value) {
        assertThatThrownBy(() -> {
            LottoNumber.of(value);
        })
        .isInstanceOf(LottoNumberOutOfBoundsException.class)
        .hasMessageContaining("LottoNumber 범위가 아닙니다.");
    }

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
}
