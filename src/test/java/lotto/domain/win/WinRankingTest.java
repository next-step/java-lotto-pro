package lotto.domain.win;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinRankingTest {

    @Test
    @DisplayName("1등 확인")
    void firstRanking() {
        Assertions.assertThat(WinRanking.of(6, true)).isEqualTo(WinRanking.FIRST);
        Assertions.assertThat(WinRanking.of(6, false)).isEqualTo(WinRanking.FIRST);
    }

    @Test
    @DisplayName("2등 확인")
    void secondRanking() {
        Assertions.assertThat(WinRanking.of(5, true)).isEqualTo(WinRanking.SECOND);
    }

    @Test
    @DisplayName("3등 확인")
    void thirdRanking() {
        Assertions.assertThat(WinRanking.of(5, false)).isEqualTo(WinRanking.THIRD);
    }

    @Test
    @DisplayName("4등 확인")
    void fourthRanking() {
        Assertions.assertThat(WinRanking.of(4, true)).isEqualTo(WinRanking.FOURTH);
        Assertions.assertThat(WinRanking.of(4, false)).isEqualTo(WinRanking.FOURTH);
    }

    @Test
    @DisplayName("5등 확인")
    void fifthRanking() {
        Assertions.assertThat(WinRanking.of(3, false)).isEqualTo(WinRanking.FIFTH);
        Assertions.assertThat(WinRanking.of(3, true)).isEqualTo(WinRanking.FIFTH);
    }

    @ParameterizedTest(name = "{displayName} | matchCount = {argumentsWithNames}")
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("당첨 안됨")
    void noRanking(int input) {
        Assertions.assertThat(WinRanking.of(input, false)).isEqualTo(WinRanking.MISS);
        Assertions.assertThat(WinRanking.of(input, true)).isEqualTo(WinRanking.MISS);
    }

    @ParameterizedTest(name = "{displayName} | matchCount = {argumentsWithNames}")
    @ValueSource(ints = {-1, 7})
    @DisplayName("0 ~ 6 이외의 값을 matchCount로 입력되면 IllegalArgumentException 예외를 던진다.")
    void rankException(int input) {
        Assertions.assertThatThrownBy(() -> WinRanking.of(input, true))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> WinRanking.of(input, false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 등수만 조회되는지 확인")
    void winnableRankings() {
        Assertions.assertThat(WinRanking.winnableRankings())
                .containsExactlyInAnyOrder(
                        WinRanking.FIRST,
                        WinRanking.SECOND,
                        WinRanking.THIRD,
                        WinRanking.FOURTH,
                        WinRanking.FIFTH
                );
    }
}
