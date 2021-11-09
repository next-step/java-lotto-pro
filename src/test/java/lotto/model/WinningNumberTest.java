package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    public static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new LottoNumber(1)
                )
        );
    }

    @DisplayName("당첨 번호와 같은 보너스볼 일 경우 테스트")
    @ParameterizedTest
    @MethodSource("args")
    void duplicateBonusBallTest(Lotto winningNumber, LottoNumber bonusBall) {
        assertThatThrownBy(() -> {
            new WinningNumber(winningNumber, bonusBall);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}