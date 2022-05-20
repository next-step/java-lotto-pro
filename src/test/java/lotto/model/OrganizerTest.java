package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrganizerTest {
    Lotto lotto;
    Organizer organizer;

    @BeforeEach
    private void setup() {
        organizer = new Organizer("1, 12, 21, 33, 41, 45", 7);
    }

    @ParameterizedTest
    @DisplayName("지난 주 당첨 번호 비교 확인")
    @MethodSource("compareLottoSource")
    public void compareNumber(int sameCount, Integer[] userLotto) {
        lotto = new Lotto(userLotto);
        assertThat(organizer.userNumberSameCount(lotto)).isEqualTo(sameCount);
    }

    private static Stream<Arguments> compareLottoSource() {
        return Stream.of(
                Arguments.of(3, new Integer[]{1, 12, 21, 3, 4, 5}),
                Arguments.of(4, new Integer[]{1, 12, 21, 33, 4, 5}),
                Arguments.of(5, new Integer[]{1, 12, 21, 33, 41, 5}),
                Arguments.of(6, new Integer[]{1, 12, 21, 33, 41, 45})
        );
    }

    @Test
    @DisplayName("로또 당첨 결과 정상 확인")
    public void checkWinningResults() {
        Lottos lottos = new Lottos(
                new Lotto[]{new Lotto(1, 12, 21, 3, 4, 5)}
        );
        assertThat(organizer.winningResults(lottos).get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 수익률 계산 정상 동작 확인")
    public void checkRateOfReturn() {
        Lottos lottos = new Lottos(
                new Lotto[]{new Lotto(1, 12, 21, 3, 4, 5)}
        );
        organizer.winningResults(lottos);
        assertThat(organizer.winningRate(15000)).isEqualTo("0.33");
    }

    @ParameterizedTest
    @DisplayName("비정상 값 검증")
    @CsvSource(
            value = {"1, 2, 2, 3, 4, 5:7", "a, 2, 3, 4, 5, 6:7", "1, 2, 3, 4, 5:7", "1, 2, 3, 4, 5, 6:2"}
            , delimiter = ':'
    )
    public void checkNotValid(String winningNumbers, int bonus) {
        assertThatThrownBy(() -> {new Organizer(winningNumbers, bonus);}).isInstanceOf(IllegalArgumentException.class);
    }
}

