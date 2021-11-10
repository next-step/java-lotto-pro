package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCountTest {
    public static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        "3",
                        new Money("2000")
                )
        );
    }

    @DisplayName("음수를 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2"})
    void invalidCountTest(String input) {

        assertThatThrownBy(() -> {
            new LottoCount(input, new Money("3000"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 갯수가 구입 금액을 초과하는 경우 테스트")
    @ParameterizedTest
    @MethodSource("args")
    void exceedCountTest(String lottoCount, Money money) {
        assertThatThrownBy(() -> {
            new LottoCount(lottoCount, money);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
