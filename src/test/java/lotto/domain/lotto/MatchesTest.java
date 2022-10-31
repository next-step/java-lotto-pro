package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MatchesTest {
    @ParameterizedTest(name = "로또 길이를 벗어날 수 없다. [{0}]")
    @ValueSource(longs = {-1, 7})
    void 범위를_벗어난_값(final long matchCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Matches.of(matchCount))
                .withMessageContaining("일치 개수는 로또 길이 이내여야 합니다.");
    }

    @ParameterizedTest(name = "{0}개 일치하면, {1}을 반환한다.")
    @CsvSource({
            "6, SIX",
            "5, FIVE",
            "4, FOUR",
            "3, THREE",
            "2, BLANK",
            "1, BLANK",
            "0, BLANK"
    })
    void 일치개수(final long matchCount, final Matches expected) {
        final Matches actual = Matches.of(matchCount);

        assertThat(actual).isEqualTo(expected);
    }
}
