package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoTest {

    @DisplayName("로또는 숫자 6개를 입력이 안될 경우 RuntimeException 을 발생한다")
    @ParameterizedTest
    @MethodSource("provideIntegerArrays")
    void invalidInputTest(final int[] numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(createLottoNumberArray(numbers)))
                .withMessageContaining("LottoNumberArray invalid size : ");
    }

    private static Stream<Arguments> provideIntegerArrays() {
        return Stream.of(
                Arguments.of(new int[]{1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5})
        );
    }

    private LottoNumber[] createLottoNumberArray(final int[] numbers) {
        return Arrays.stream(numbers).mapToObj(LottoNumber::new).toArray(LottoNumber[]::new);
    }
}
