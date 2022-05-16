package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OrganizerTest {
    Lotto lotto;
    Organizer organizer;

    @BeforeEach
    private void setup() {
        organizer = new Organizer("1, 12, 21, 33, 41, 45");
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
        assertThat(organizer.winningResults(lottos).get(3)).isEqualTo(1);
    }
}

