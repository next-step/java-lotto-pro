package lotto.domain.statistics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lotto.domain.lotto.Fixture;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Matches;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class MatchingResultTest {
    @DisplayName("결과가 같으면, 동일하다.")
    @Test
    void 동일성() {
        final MatchingResult one = new MatchingResult(
                new HashMap<Matches, Long>() {{
                    put(Matches.SIX, 1L);
                }}
        );
        final MatchingResult another = new MatchingResult(
                new HashMap<Matches, Long>() {{
                    put(Matches.SIX, 1L);
                    put(Matches.FIVE, 0L);
                    put(Matches.FOUR, 0L);
                    put(Matches.THREE, 0L);
                    put(Matches.BLANK, 0L);
                }}
        );

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("로또 목록은 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 로또_목록_null(final List<Lotto> lottos) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> MatchingResult.matches(lottos, Fixture.winningNumbers123456()))
                .withMessage("로또 목록은 null이 아니어야 합니다.");
    }

    @DisplayName("당첨 번호는 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 당첨번호_null(final Lotto winningNumbers) {
        final List<Lotto> lottos = Collections.singletonList(new Lotto(1, 2, 3, 4, 5, 6));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> MatchingResult.matches(lottos, winningNumbers))
                .withMessage("당첨 번호는 null이 아니어야 합니다.");
    }

    @Test
    void 당첨_결과() {
        final List<Lotto> lottos = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(40, 41, 42, 43, 44, 45)
        );
        final MatchingResult expected = new MatchingResult(
                new HashMap<Matches, Long>() {{
                    put(Matches.SIX, 1L);
                    put(Matches.BLANK, 1L);
                }}
        );

        final MatchingResult actual = MatchingResult.matches(lottos, Fixture.winningNumbers123456());

        assertThat(actual).isEqualTo(expected);
    }
}
