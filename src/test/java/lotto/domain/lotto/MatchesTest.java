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
                .isThrownBy(() -> Matches.of(matchCount, false))
                .withMessageContaining("일치 개수는 로또 길이 이내여야 합니다.");
    }

    @ParameterizedTest(name = "일치 개수:{0}, 보너스볼 일치여부: {1}, 결과: {2}")
    @CsvSource({
            "6, false, SIX",

            "5, true,  FIVE_WITH_BONUS",
            "5, false,  FIVE",

            "4, true, FOUR",
            "4, false, FOUR",

            "3, true, THREE",
            "3, false, THREE",

            "2, true, BLANK",
            "2, false, BLANK",

            "1, true, BLANK",
            "1, false, BLANK",

            "0, false, BLANK"
    })
    void 일치개수(final long matchCount, final boolean containsBonus, final Matches expected) {
        final Matches actual = Matches.of(matchCount, containsBonus);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}에 당첨되면 당첨금 단위는 {1}원이다.")
    @CsvSource({
            "SIX, 2000000000",
            "FIVE_WITH_BONUS, 30000000",
            "FIVE, 1500000",
            "FOUR, 50000",
            "THREE, 5000",
            "BLANK, 0"
    })
    void 당첨금(final Matches match, final long expectedMoney) {
        final Money expected = new Money(expectedMoney);

        final Money actual = match.getUnitPrize();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}에 2개 당첨되면 당첨금은 {1}원이다.")
    @CsvSource({
            "SIX, 4000000000",
            "FIVE_WITH_BONUS, 60000000",
            "FIVE, 3000000",
            "FOUR, 100000",
            "THREE, 10000",
            "BLANK, 0"
    })
    void 당첨금_계산(final Matches match, final long expectedMoney) {
        final Money expected = new Money(expectedMoney);

        final Money actual = match.calculatePrize(2L);

        assertThat(actual).isEqualTo(expected);
    }
}
