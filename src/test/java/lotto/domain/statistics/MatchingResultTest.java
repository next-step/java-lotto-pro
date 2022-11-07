package lotto.domain.statistics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Fixture;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Matches;
import lotto.domain.lotto.Money;
import lotto.domain.lotto.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class MatchingResultTest {
    @DisplayName("결과가 같으면, 동일하다.")
    @Test
    void 동일성() {
        final Money oneTotalSpendAmount = new Money(10000);
        final Map<Matches, Long> oneMatchingCount = new HashMap<Matches, Long>() {{
            put(Matches.SIX, 1L);
        }};
        final MatchingResult one = new MatchingResult(oneMatchingCount, oneTotalSpendAmount);

        final Money anotherTotalSpendAmount = new Money(10000);
        final Map<Matches, Long> anotherMatchingCount = new HashMap<Matches, Long>() {{
            put(Matches.SIX, 1L);
            put(Matches.FIVE, 0L);
            put(Matches.FOUR, 0L);
            put(Matches.THREE, 0L);
            put(Matches.BLANK, 0L);
        }};
        MatchingResult another = new MatchingResult(anotherMatchingCount, anotherTotalSpendAmount);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("로또 목록은 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 로또_목록_null(final List<Lotto> lottos) {
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> MatchingResult.analyze(lottos, Fixture.lottoUnitPrice1000(),
                                Fixture.winningNumbers123456()))
                .withMessage("로또 목록은 null이 아니어야 합니다.");
    }

    @DisplayName("당첨 번호는 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 당첨번호_null(final WinningNumbers winningNumbers) {
        final List<Lotto> lottos = Collections.singletonList(new Lotto(1, 2, 3, 4, 5, 6));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> MatchingResult.analyze(lottos, Fixture.lottoUnitPrice1000(), winningNumbers))
                .withMessage("당첨 번호는 null이 아니어야 합니다.");
    }

    @DisplayName("로또 단위 가격은 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 로또단위가격_null(final Money lottoUnitPrice) {
        final List<Lotto> lottos = Collections.singletonList(new Lotto(1, 2, 3, 4, 5, 6));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> MatchingResult.analyze(lottos, lottoUnitPrice, Fixture.winningNumbers123456()))
                .withMessage("로또 단위 가격은 null이 아니어야 합니다.");
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
                }},
                new Money(2000)
        );

        final MatchingResult actual = MatchingResult.analyze(
                lottos,
                Fixture.lottoUnitPrice1000(),
                Fixture.winningNumbers123456()
        );

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("당첨 결과에 따라 수익률을 계산할 수 있다.")
    @Test
    void 수익률() {
        final Money totalAmount = new Money(1_000_000L);
        final MatchingResult matchingResult = new MatchingResult(
                new HashMap<Matches, Long>() {{
                    put(Matches.THREE, 2L);
                }},
                totalAmount
        );
        final BigDecimal expected = BigDecimal.valueOf(0.01);

        final BigDecimal actual = matchingResult.computeReturnOnInvestment();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("결과를 Map으로 반환할 수 있다.")
    @Test
    void toMap() {
        final MatchingResult result = new MatchingResult(
                new HashMap<Matches, Long>() {{
                    put(Matches.SIX, 1L);
                    put(Matches.BLANK, 1L);
                }},
                new Money(2000)
        );
        final Map<Matches, Long> expected = new HashMap<Matches, Long>() {{
            put(Matches.SIX, 1L);
            put(Matches.FIVE_WITH_BONUS, 0L);
            put(Matches.FIVE, 0L);
            put(Matches.FOUR, 0L);
            put(Matches.THREE, 0L);
            put(Matches.BLANK, 1L);
        }};

        final Map<Matches, Long> actual = result.toMap();

        assertThat(actual).isEqualTo(expected);
    }
}
