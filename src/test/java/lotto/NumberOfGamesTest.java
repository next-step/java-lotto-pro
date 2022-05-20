package lotto;

import lotto.domain.NumberOfGames;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberOfGamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "-1"})
    void 생성_예외(String input) {
        assertThatThrownBy(() -> new NumberOfGames(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
